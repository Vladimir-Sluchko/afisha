package by.itacademy.afisha.service.api;

import by.itacademy.afisha.dao.entity.Film;
import by.itacademy.afisha.dto.FilmCreateDto;
import by.itacademy.afisha.dto.FilmReadDto;

import java.util.UUID;


public interface IFilmService extends IService<Film, FilmCreateDto, FilmReadDto> {
    @Override
    FilmCreateDto create(FilmCreateDto eventFilm);

    @Override
    FilmReadDto get(UUID uuid);
}
