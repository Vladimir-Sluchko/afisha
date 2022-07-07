package by.itacademy.afisha.service.api;

import by.itacademy.afisha.dao.entity.Film;
import by.itacademy.afisha.dto.FilmDto;


public interface IEventFilmService {
    Film create (FilmDto eventFilm);
    Film get (String uuid);
}
