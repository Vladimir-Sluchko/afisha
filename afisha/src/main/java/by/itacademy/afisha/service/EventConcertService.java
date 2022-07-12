package by.itacademy.afisha.service;

import by.itacademy.afisha.dao.api.IConcertDao;
import by.itacademy.afisha.dao.entity.Concert;
import by.itacademy.afisha.dao.entity.enums.Type;
import by.itacademy.afisha.service.api.IConcertService;
import by.itacademy.afisha.service.dto.ConcertCreateDto;
import by.itacademy.afisha.service.dto.ConcertReadDto;
import by.itacademy.afisha.service.dto.PageDto;
import by.itacademy.afisha.service.utils.mapper.EventConcertMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

@Service
public class EventConcertService implements IConcertService {
    private final IConcertDao eventConcertDao;


    private final EventConcertMapper mapper;

    public EventConcertService(IConcertDao eventConcertDao, EventConcertMapper mapper) {
        this.eventConcertDao = eventConcertDao;
        this.mapper = mapper;
    }



    @Override
    public ConcertCreateDto create(ConcertCreateDto eventConcert) {
        Concert concert = mapper.fromDtoToEntityFilm(eventConcert);
        eventConcertDao.save(concert);
        return eventConcert;
    }

    @Override
    public ConcertReadDto get(UUID uuid) {
        if (uuid == null) {
            throw new IllegalArgumentException("This field cannot be null");
        }
        Concert concert = eventConcertDao.findById(uuid).
                orElseThrow(()-> {
                    throw new IllegalArgumentException("Нет такого фильма");
                });
        return mapper.fromEntityToDto(concert);
    }

    @Override
    public PageDto<ConcertReadDto> getAll(int page, int size) {
        //List<Concert> listEntity = eventConcertDao.findAll();
        List<Concert> listEntity = eventConcertDao.findByType(Type.CONCERTS);
        List<ConcertReadDto> listDto = mapper.mapList(listEntity,ConcertReadDto.class);
        Pageable pageRequest = PageRequest.of(--page,size);
        //Page<Concert> entities = eventConcertDao.findAll(pageRequest);
        Page<Concert> entities = eventConcertDao.findByType(Type.CONCERTS, pageRequest);
        Page<ConcertReadDto> concertReadDto = new PageImpl<>(listDto, pageRequest, entities.getTotalElements());
        PageDto<ConcertReadDto> concertReadDtoPageDto = mapper.fromPageToDto(concertReadDto);
        return concertReadDtoPageDto;
    }

    @Override
    public ConcertCreateDto update(ConcertCreateDto eventConcert, UUID uuid, Long dtUpdate) {
        LocalDateTime dateUpdate = LocalDateTime.ofInstant(Instant.ofEpochMilli(dtUpdate), ZoneId.systemDefault());
        Concert concert = eventConcertDao.findById(uuid).orElseThrow(()-> {
            throw new IllegalArgumentException("Нет такого концерта");
        });
        if (concert.getDtUpdate().equals(dateUpdate)) {
            concert.setTitle(eventConcert.getTitle());
            concert.setDescription(eventConcert.getDescription());
            concert.setDtEvent(eventConcert.getDtEvent());
            concert.setDtEndOfSale(eventConcert.getDtEndOfSale());
            concert.setType(eventConcert.getType());
            concert.setStatus(eventConcert.getStatus());

            eventConcertDao.save(concert);
        } else {
            throw new OptimisticLockException("Entity already updated");
        }
        return eventConcert;
    }
}
