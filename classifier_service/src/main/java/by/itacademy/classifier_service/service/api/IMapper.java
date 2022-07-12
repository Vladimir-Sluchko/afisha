package by.itacademy.classifier_service.service.api;

import by.itacademy.classifier_service.service.dto.PageDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IMapper<F,D,R> {
    F fromDtoToEntity(D dto);
    R fromEntityToDto(F entity);
    List<R> mapList(List<F> source, Class<R> targetClass);
    PageDto<R> fromPageToDto (Page<R> source);


}
