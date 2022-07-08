package by.itacademy.afisha.service.utils.mapper;

import by.itacademy.afisha.dao.entity.Film;
import by.itacademy.afisha.dto.FilmCreateDto;
import org.modelmapper.ModelMapper;

import java.util.UUID;

public class EventFilmMapper {
    private final ModelMapper modelMapper;

    public EventFilmMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    public Film fromDtoToEntityFilm(FilmCreateDto dto) {
        Film entity = modelMapper.map(dto,Film.class);
        entity.setUuid(UUID.randomUUID());

    }
}
