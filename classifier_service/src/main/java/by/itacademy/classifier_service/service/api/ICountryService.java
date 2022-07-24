package by.itacademy.classifier_service.service.api;

import by.itacademy.classifier_service.service.dto.CountryCreateDto;
import by.itacademy.classifier_service.service.dto.CountryReadDto;
import by.itacademy.classifier_service.service.dto.PageDto;

public interface ICountryService extends IService<CountryCreateDto, CountryReadDto> {
    @Override
    CountryCreateDto create(CountryCreateDto dto);

    @Override
    PageDto<CountryReadDto> getAll(int page, int size);

}
