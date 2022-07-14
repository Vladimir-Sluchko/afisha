package by.itacademy.user.service.api;

import by.itacademy.user.service.dto.PageDto;

public interface IService<C,R> {
    C create (C dto);
    PageDto<R> getAll(int page, int size );
}
