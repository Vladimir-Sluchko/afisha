package by.itacademy.classifier_service.service;

import by.itacademy.classifier_service.dao.api.ICategoryDao;
import by.itacademy.classifier_service.dao.entity.Category;
import by.itacademy.classifier_service.dao.entity.Country;
import by.itacademy.classifier_service.service.api.ICategoryService;
import by.itacademy.classifier_service.service.dto.CategoryCreateDto;
import by.itacademy.classifier_service.service.dto.CategoryReadDto;
import by.itacademy.classifier_service.service.dto.CountryReadDto;
import by.itacademy.classifier_service.service.dto.PageDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CategoryService implements ICategoryService {
    private final ICategoryDao repository;
    private final ModelMapper mapper;

    @Autowired
    public CategoryService(ICategoryDao repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public CategoryCreateDto create(CategoryCreateDto dto) {
        Category entity = mapper.map(dto,Category.class);
        entity.setUuid(UUID.randomUUID());
        entity.setDtCreate(LocalDateTime.now());
        entity.setDtUpdate(LocalDateTime.now());
        repository.save(entity);
        return dto;
    }

    @Override
    public PageDto<CategoryReadDto> getAll(int page, int size) {
        List<Category> listEntity = repository.findAll();
        List<CategoryReadDto> listDto = listEntity.stream()
                .map(element -> mapper.map(element, CategoryReadDto.class))
                .collect(Collectors.toList());;
        Pageable pageRequest = PageRequest.of(--page,size);
        Page<Category> entities = repository.findAll(pageRequest);
        Page<CategoryReadDto> pageDtoR = new PageImpl<>(listDto, pageRequest, entities.getTotalElements());
        PageDto<CategoryReadDto> pageDto = mapper.map(pageDtoR,PageDto.class);
        return pageDto;
    }
}
