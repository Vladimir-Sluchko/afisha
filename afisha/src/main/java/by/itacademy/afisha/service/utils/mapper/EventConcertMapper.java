package by.itacademy.afisha.service.utils.mapper;

import by.itacademy.afisha.dao.entity.Concert;
import by.itacademy.afisha.dao.entity.Film;
import by.itacademy.afisha.service.api.IMapper;
import by.itacademy.afisha.service.dto.ConcertCreateDto;
import by.itacademy.afisha.service.dto.ConcertReadDto;
import by.itacademy.afisha.service.dto.FilmReadDto;
import by.itacademy.afisha.service.dto.PageDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class EventConcertMapper implements IMapper<Concert, ConcertCreateDto, ConcertReadDto> {
    private final ModelMapper modelMapper;

    @Autowired
    public EventConcertMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public Concert fromDtoToEntityFilm(ConcertCreateDto dto) {
        Concert entity = modelMapper.map(dto,Concert.class);
        entity.setUuid(UUID.randomUUID());
        entity.setDtCreate(LocalDateTime.now());
        entity.setDtUpdate(LocalDateTime.now());
        return entity;
    }

    @Override
    public ConcertReadDto fromEntityToDto(Concert entity) {
        ConcertReadDto dto = modelMapper.map(entity,ConcertReadDto.class);
        return dto;
    }

    @Override
    public List<ConcertReadDto> mapList(List<Concert> source, Class<ConcertReadDto> targetClass) {
        return source
                .stream()
                .map(element -> modelMapper.map(element, targetClass))
                .collect(Collectors.toList());
    }

    @Override
    public PageDto<ConcertReadDto> fromPageToDto(Page<ConcertReadDto> source) {
        return modelMapper.map(source,PageDto.class);
    }
}
