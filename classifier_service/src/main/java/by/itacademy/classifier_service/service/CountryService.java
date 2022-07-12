package by.itacademy.classifier_service.service;

import by.itacademy.classifier_service.dao.api.ICountryDao;
import by.itacademy.classifier_service.dao.entity.Country;
import by.itacademy.classifier_service.service.api.ICountryService;
import by.itacademy.classifier_service.service.dto.CountryCreateDto;
import by.itacademy.classifier_service.service.dto.CountryReadDto;
import by.itacademy.classifier_service.service.dto.PageDto;
import by.itacademy.classifier_service.service.utils.mapper.CountryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class CountryService implements ICountryService {
    private final ICountryDao repository;
    private final CountryMapper mapper;

    @Autowired
    public CountryService(ICountryDao repository, CountryMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public CountryCreateDto create(CountryCreateDto dto) {
        Country entity = mapper.fromDtoToEntity(dto);
        repository.save(entity);
        return dto;
    }

    @Override
    public PageDto<CountryReadDto> getAll(int page, int size) {
        List<Country> listEntity = repository.findAll();
        List<CountryReadDto> listDto = mapper.mapList(listEntity,CountryReadDto.class);
        Pageable pageRequest = PageRequest.of(--page,size);
        Page<Country> entities = repository.findAll(pageRequest);
        Page<CountryReadDto> readDto = new PageImpl<>(listDto, pageRequest, entities.getTotalElements());
        PageDto<CountryReadDto> pageDto = mapper.fromPageToDto(readDto);
        return pageDto;
    }
}
