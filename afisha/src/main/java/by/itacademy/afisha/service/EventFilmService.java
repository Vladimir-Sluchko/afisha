package by.itacademy.afisha.service;

import by.itacademy.afisha.dao.api.IFilmDao;
import by.itacademy.afisha.dao.entity.Film;
import by.itacademy.afisha.dto.FilmCreateDto;
import by.itacademy.afisha.dto.FilmReadDto;
import by.itacademy.afisha.service.api.IFilmService;
import by.itacademy.afisha.service.utils.mapper.EventFilmMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EventFilmService implements IFilmService {
    private final IFilmDao eventFilmDao;


    private final EventFilmMapper mapper;

    @Autowired
    public EventFilmService(IFilmDao eventFilmDao, EventFilmMapper mapper) {
        this.eventFilmDao = eventFilmDao;
        this.mapper = mapper;
    }


    @Override
    public FilmCreateDto create(FilmCreateDto eventFilm) {
        Film film = mapper.fromDtoToEntityFilm(eventFilm);
        eventFilmDao.save(film);
        film.getCountry();
        /*film.setUuid(UUID.randomUUID());
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
        film.setDuration(eventFilm.getDuration());*/
        return eventFilm;
    }

     @Override
    public FilmReadDto get(UUID uuid) {
        if (uuid == null) {
            throw new IllegalArgumentException("This field cannot be null");
        }

         Film film = eventFilmDao.findById(uuid).
                 orElseThrow(()-> {
                     throw new IllegalArgumentException("Нет такого фильма");
                 });
         //FilmReadDto dto = mapper.fromEntityToDto(film);
        return mapper.fromEntityToDto(film);
    }
}
