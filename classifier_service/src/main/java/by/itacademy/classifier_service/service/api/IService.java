package by.itacademy.classifier_service.service.api;

import by.itacademy.classifier_service.service.dto.PageDto;

import java.util.UUID;

public interface IService<C,R> {
    C create (C dto);
    PageDto<R> getAll(int page, int size );

    boolean сheckUuid(UUID uuid);
}
