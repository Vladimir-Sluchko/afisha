package by.itacademy.afisha.service;

import by.itacademy.afisha.dao.api.IFilmDao;
import by.itacademy.afisha.dao.entity.Concert;
import by.itacademy.afisha.dao.entity.Film;
import by.itacademy.afisha.dao.entity.enums.Type;
import by.itacademy.afisha.service.dto.FilmCreateDto;
import by.itacademy.afisha.service.dto.FilmReadDto;
import by.itacademy.afisha.service.api.IFilmService;
import by.itacademy.afisha.service.dto.PageDto;
import by.itacademy.afisha.service.utils.mapper.EventFilmMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import javax.persistence.Converter;
import javax.persistence.OptimisticLockException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
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
        return eventFilm;
    }

    @Override
    public PageDto<FilmReadDto> getAll(int page, int size ) {
        //List<Film> listEntity = eventFilmDao.findAll();
        List<Film> listEntity = eventFilmDao.findByType(Type.FILMS);
        List<FilmReadDto> listDto = mapper.mapList(listEntity,FilmReadDto.class);
        Pageable pageRequest = PageRequest.of(--page,size);
        //Page<Film> entities = eventFilmDao.findAll(pageRequest);
        Page<Film> entities = eventFilmDao.findByType(Type.FILMS,pageRequest);
        Page<FilmReadDto> filmReadDto = new PageImpl<>(listDto, pageRequest, entities.getTotalElements());
        PageDto<FilmReadDto> filmReadDtoPageDto = mapper.fromPageToDto(filmReadDto);
        return filmReadDtoPageDto;
    }

    @Override
    public FilmCreateDto update(FilmCreateDto eventFilm, UUID uuid, Long dtUpdate) {
        LocalDateTime dateUpdate = LocalDateTime.ofInstant(Instant.ofEpochMilli(dtUpdate), ZoneId.systemDefault());
        Film film = eventFilmDao.findById(uuid).orElseThrow(()-> {
            throw new IllegalArgumentException("Нет такого фильма");
        });
        if (film.getDtUpdate().equals(dateUpdate)) {
            film.setTitle(eventFilm.getTitle());
            film.setDescription(eventFilm.getDescription());
            film.setDtEvent(eventFilm.getDtEvent());
            film.setDtEndOfSale(eventFilm.getDtEndOfSale());
            film.setType(eventFilm.getType());
            film.setStatus(eventFilm.getStatus());
            film.setCountry(eventFilm.getCountry());
            film.setReleaseYear(eventFilm.getReleaseYear());
            film.setReleaseDate(eventFilm.getReleaseDate());
            film.setDuration(eventFilm.getDuration());
            //film = mapper.fromDtoToEntityFilm(eventFilm);
            eventFilmDao.save(film);
        } else {
            throw new OptimisticLockException("Entity already updated");
        }
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
        return mapper.fromEntityToDto(film);
    }

}
