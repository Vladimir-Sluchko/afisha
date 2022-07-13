package by.itacademy.classifier_service.service.api;

import by.itacademy.classifier_service.service.dto.CategoryCreateDto;
import by.itacademy.classifier_service.service.dto.CategoryReadDto;
import by.itacademy.classifier_service.service.dto.PageDto;

public interface ICategoryService extends IService<CategoryCreateDto, CategoryReadDto> {
    @Override
    CategoryCreateDto create(CategoryCreateDto dto);

    @Override
    PageDto<CategoryReadDto> getAll(int page, int size);
}
