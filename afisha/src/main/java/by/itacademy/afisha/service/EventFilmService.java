package by.itacademy.afisha.service;

import by.itacademy.afisha.dao.api.IFilmDao;
import by.itacademy.afisha.dao.entity.Film;
import by.itacademy.afisha.dao.entity.enums.Type;
import by.itacademy.afisha.service.dto.FilmCreateDto;
import by.itacademy.afisha.service.dto.FilmReadDto;
import by.itacademy.afisha.service.api.IFilmService;
import by.itacademy.afisha.service.dto.PageDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import javax.persistence.OptimisticLockException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EventFilmService implements IFilmService {
    private final IFilmDao repository;


    private final ModelMapper mapper;

    @Autowired
    public EventFilmService(IFilmDao eventFilmDao, ModelMapper mapper) {
        this.repository = eventFilmDao;
        this.mapper = mapper;
    }

    @Override
    public FilmCreateDto create(FilmCreateDto eventFilm) {
        Film entity = mapper.map(eventFilm, Film.class);
        entity.setUuid(UUID.randomUUID());
        entity.setDtCreate(LocalDateTime.now());
        entity.setDtUpdate(LocalDateTime.now());
        repository.save(entity);
        return eventFilm;
    }

    @Override
    public PageDto<FilmReadDto> getAll(int page, int size ) {
        List<Film> listEntity = repository.findByType(Type.FILMS);
        List<FilmReadDto> listDto = listEntity.stream()
                .map(element -> mapper.map(element, FilmReadDto.class))
                .collect(Collectors.toList());
        Pageable pageRequest = PageRequest.of(--page,size);
        Page<Film> entities = repository.findByType(Type.FILMS,pageRequest);
        Page<FilmReadDto> filmReadDto = new PageImpl<>(listDto, pageRequest, entities.getTotalElements());
        return mapper.map(filmReadDto, PageDto.class);
    }

    @Override
    public FilmCreateDto update(FilmCreateDto eventFilm, UUID uuid, Long dtUpdate) {
        LocalDateTime dateUpdate = LocalDateTime.ofInstant(Instant.ofEpochMilli(dtUpdate), ZoneId.systemDefault());
        Film film = repository.findById(uuid).orElseThrow(()-> {
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
            film.setDtUpdate(LocalDateTime.now());
            repository.save(film);
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
         Film film = repository.findById(uuid).
                 orElseThrow(()-> {
                     throw new IllegalArgumentException("Нет такого фильма");
                 });
        return mapper.map(film,FilmReadDto.class);
    }

}
