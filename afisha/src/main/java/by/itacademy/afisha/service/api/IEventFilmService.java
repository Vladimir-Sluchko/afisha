package by.itacademy.afisha.service.api;

import by.itacademy.afisha.dao.entity.Film;
import by.itacademy.afisha.dto.FilmCreateDto;

import java.util.UUID;


public interface IEventFilmService {
    Film create (FilmCreateDto eventFilm);
    Film get (UUID uuid);
}
