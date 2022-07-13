package by.itacademy.classifier_service.service;

import by.itacademy.classifier_service.dao.api.ICountryDao;
import by.itacademy.classifier_service.dao.entity.Country;
import by.itacademy.classifier_service.service.api.ICountryService;
import by.itacademy.classifier_service.service.dto.CountryCreateDto;
import by.itacademy.classifier_service.service.dto.CountryReadDto;
import by.itacademy.classifier_service.service.dto.PageDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;

public class CountryService implements ICountryService {
    private final ICountryDao repository;
    private final ModelMapper mapper;

    @Autowired
    public CountryService(ICountryDao repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Autowired


    @Override
    public CountryCreateDto create(CountryCreateDto dto) {
        Country entity = mapper.map(dto,Country.class);
        repository.save(entity);
        return dto;
    }

    @Override
    public PageDto<CountryReadDto> getAll(int page, int size) {
        List<Country> listEntity = repository.findAll();
        List<CountryReadDto> listDto = listEntity.stream()
                .map(element -> mapper.map(element, CountryReadDto.class))
                .collect(Collectors.toList());;
        Pageable pageRequest = PageRequest.of(--page,size);
        Page<Country> entities = repository.findAll(pageRequest);
        Page<CountryReadDto> pageDtoR = new PageImpl<>(listDto, pageRequest, entities.getTotalElements());
        PageDto<CountryReadDto> pageDto = mapper.map(pageDtoR,PageDto.class);
        return pageDto;
    }
}
