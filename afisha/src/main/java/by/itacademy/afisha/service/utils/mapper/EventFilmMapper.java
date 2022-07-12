package by.itacademy.afisha.service.utils.mapper;

import by.itacademy.afisha.dao.entity.Film;
import by.itacademy.afisha.service.dto.FilmCreateDto;
import by.itacademy.afisha.service.dto.FilmReadDto;
import by.itacademy.afisha.service.api.IMapper;
import by.itacademy.afisha.service.dto.PageDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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

    @Override
    public List<FilmReadDto> mapList(List<Film> source, Class<FilmReadDto> targetClass) {
        return source
                .stream()
                .map(element -> modelMapper.map(element, targetClass))
                .collect(Collectors.toList());
    }

    @Override
    public PageDto<FilmReadDto> fromPageToDto(Page<FilmReadDto> source) {

        //PageDto<FilmReadDto> page = modelMapper.map(source,PageDto.class);
        return modelMapper.map(source,PageDto.class);
    }
}
