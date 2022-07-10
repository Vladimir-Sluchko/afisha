package by.itacademy.afisha.service.utils.mapper;

import by.itacademy.afisha.dao.entity.Film;
import by.itacademy.afisha.dto.FilmCreateDto;
import by.itacademy.afisha.dto.FilmReadDto;
import by.itacademy.afisha.service.api.IMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.UUID;

public class EventFilmMapper implements IMapper<Film,FilmCreateDto,FilmReadDto> {
    private final ModelMapper modelMapper;

    @Autowired
    public EventFilmMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    @Override
    public Film fromDtoToEntityFilm(FilmCreateDto dto) {
        Film entity = modelMapper.map(dto,Film.class);
        entity.setUuid(UUID.randomUUID());
        entity.setDtCreate(LocalDateTime.now());
        entity.setDtUpdate(LocalDateTime.now());
        return entity;
    }

    @Override
    public FilmReadDto fromEntityToDto(Film entity) {
        FilmReadDto dto = modelMapper.map(entity,FilmReadDto.class);
        return dto;
    }
}
