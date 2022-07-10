package by.itacademy.afisha.service.api;

import by.itacademy.afisha.dao.entity.Film;
import by.itacademy.afisha.dto.FilmCreateDto;

public interface IMapper <F,D,R> {
    F fromDtoToEntityFilm(D dto);
    R fromEntityToDto(F entity);
}
