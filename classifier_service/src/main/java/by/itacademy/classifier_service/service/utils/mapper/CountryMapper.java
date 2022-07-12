package by.itacademy.classifier_service.service.utils.mapper;

import by.itacademy.classifier_service.dao.entity.Country;
import by.itacademy.classifier_service.service.api.IMapper;
import by.itacademy.classifier_service.service.dto.CountryCreateDto;
import by.itacademy.classifier_service.service.dto.CountryReadDto;
import by.itacademy.classifier_service.service.dto.PageDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class CountryMapper implements IMapper<Country, CountryCreateDto, CountryReadDto> {
    private final ModelMapper modelMapper;

    @Autowired
    public CountryMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public Country fromDtoToEntity(CountryCreateDto dto) {
        Country entity = modelMapper.map(dto,Country.class);
        entity.setUuid(UUID.randomUUID());
        entity.setDtCreate(LocalDateTime.now());
        entity.setDtUpdate(LocalDateTime.now());
        return entity;
    }

    @Override
    public CountryReadDto fromEntityToDto(Country entity) {
        CountryReadDto dto = modelMapper.map(entity, CountryReadDto.class);
        return dto;
    }

    @Override
    public List<CountryReadDto> mapList(List<Country> source, Class<CountryReadDto> targetClass) {
        return source
                .stream()
                .map(element -> modelMapper.map(element, targetClass))
                .collect(Collectors.toList());
    }

    @Override
    public PageDto<CountryReadDto> fromPageToDto(Page<CountryReadDto> source) {
        return modelMapper.map(source,PageDto.class);
    }
}
