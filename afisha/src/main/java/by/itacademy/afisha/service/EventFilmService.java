package by.itacademy.afisha.service;

import by.itacademy.afisha.dao.api.IEventFilmDao;
import by.itacademy.afisha.dao.entity.Film;
import by.itacademy.afisha.dto.FilmDto;
import by.itacademy.afisha.service.api.IEventFilmService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class EventFilmService implements IEventFilmService {
    private final IEventFilmDao eventFilmDao;

    public EventFilmService(IEventFilmDao eventFilmDao) {
        this.eventFilmDao = eventFilmDao;
    }

    @Override
    public Film create(FilmDto eventFilm) {
        Film film = new Film();
        film.setUuid(UUID.randomUUID());
        film.setDtCreate(LocalDateTime.now());
        film.setDtUpdate(LocalDateTime.now());
        film.setTitle(eventFilm.getTitle());
        film.setDescription(eventFilm.getDescription());
        film.setDtEvent(eventFilm.getDtEvent());/// заменить на прав
        film.setDtEndOfSale(eventFilm.getDtEndOfSale());
        film.setType(eventFilm.getType());
        film.setStatus(eventFilm.getStatus());
        film.setCountry(eventFilm.getCountry());
        film.setReleaseYear(eventFilm.getReleaseYear());
        film.setReleaseDate(eventFilm.getReleaseDate());
        film.setDuration(eventFilm.getDuration());
        film.setDuration(eventFilm.getDuration());
        return this.eventFilmDao.save(film);
    }

    @Override
    public Film get(String uuid) {
        if (uuid == null) {
            throw new IllegalArgumentException("This field cannot be null");
        }
        return this.eventFilmDao.findById(uuid)
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("Нет такого фильма");
                });
    }
}
