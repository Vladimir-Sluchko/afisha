package by.itacademy.afisha.service;

import by.itacademy.afisha.dao.api.IConcertDao;
import by.itacademy.afisha.dao.entity.Concert;
import by.itacademy.afisha.dao.entity.enums.Type;
import by.itacademy.afisha.service.api.IConcertService;
import by.itacademy.afisha.service.dto.ConcertCreateDto;
import by.itacademy.afisha.service.dto.ConcertReadDto;
import by.itacademy.afisha.service.dto.PageDto;
import by.itacademy.afisha.service.utils.CheckUuid;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.OptimisticLockException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EventConcertService implements IConcertService {
    private final IConcertDao repository;
    private final CheckUuid checkUuid;
    private final ModelMapper mapper;

    public EventConcertService(IConcertDao repository, CheckUuid checkUuid, ModelMapper mapper) {
        this.repository = repository;
        this.checkUuid = checkUuid;
        this.mapper = mapper;
    }

    @Override
    public ConcertCreateDto create(ConcertCreateDto eventConcert) {
        boolean check = checkUuid.isCheckUuid(eventConcert.getCategory(),"category");
        if (check){
            Concert entity = mapper.map(eventConcert,Concert.class);
            entity.setUuid(UUID.randomUUID());
            entity.setDtCreate(LocalDateTime.now());
            entity.setDtUpdate(LocalDateTime.now());
            repository.save(entity);
        }
        return eventConcert;
    }

    @Override
    public ConcertReadDto get(UUID uuid) {
        if (uuid == null) {
            throw new IllegalArgumentException("This field cannot be null");
        }
        Concert concert = repository.findById(uuid).
                orElseThrow(()-> {
                    throw new IllegalArgumentException("Нет такого фильма");
                });
        return mapper.map(concert,ConcertReadDto.class);
    }

    @Override
    public PageDto<ConcertReadDto> getAll(int page, int size) {
        List<Concert> listEntity = repository.findByType(Type.CONCERTS);
        List<ConcertReadDto> listDto = listEntity.stream()
                .map(element -> mapper.map(element, ConcertReadDto.class))
                .collect(Collectors.toList());
        Pageable pageRequest = PageRequest.of(--page,size);
        Page<Concert> entities = repository.findByType(Type.CONCERTS, pageRequest);
        Page<ConcertReadDto> pageConcert = new PageImpl<>(listDto, pageRequest, entities.getTotalElements());
        PageDto<ConcertReadDto> pageDto = mapper.map(pageConcert,PageDto.class);
        return pageDto;
    }

    @Override
    public ConcertCreateDto update(ConcertCreateDto eventConcert, UUID uuid, Long dtUpdate) {
        LocalDateTime dateUpdate = LocalDateTime.ofInstant(Instant.ofEpochMilli(dtUpdate), ZoneId.systemDefault());
        Concert concert = repository.findById(uuid).orElseThrow(()-> {
            throw new IllegalArgumentException("Нет такого концерта");
        });
        boolean check = checkUuid.isCheckUuid(eventConcert.getCategory(),"category");
        if (concert.getDtUpdate().equals(dateUpdate) && check) {
            concert.setTitle(eventConcert.getTitle());
            concert.setDescription(eventConcert.getDescription());
            concert.setDtEvent(eventConcert.getDtEvent());
            concert.setDtEndOfSale(eventConcert.getDtEndOfSale());
            concert.setType(eventConcert.getType());
            concert.setStatus(eventConcert.getStatus());

            concert.setDtUpdate(LocalDateTime.now());

            repository.save(concert);
        } else {
            throw new OptimisticLockException("Entity already updated");
        }
        return eventConcert;
    }
}
