package by.itacademy.user.service;

import by.itacademy.user.dao.api.IUserDao;
import by.itacademy.user.dao.entity.User;
import by.itacademy.user.dao.entity.enums.Role;
import by.itacademy.user.dao.entity.enums.Status;
import by.itacademy.user.service.api.IServiceUsers;
import by.itacademy.user.service.dto.*;
import org.modelmapper.ModelMapper;
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
import java.util.stream.Collectors;

@Service
public class UserService implements IServiceUsers {
    private final IUserDao repository;
    private final ModelMapper mapper;

    @Autowired
    public UserService(IUserDao repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public UserCreatDto create(UserCreatDto dto) {
        User entity = mapper.map(dto, User.class);
        entity.setUuid(UUID.randomUUID());
        entity.setDtCreate(LocalDateTime.now());
        entity.setDtUpdate(LocalDateTime.now());
        repository.save(entity);
        return dto;
    }

    @Override
    public PageDto<UserReadDto> getAll(int page, int size) {
        List<User> listEntity = repository.findAll();
        List<UserReadDto> listDto = listEntity.stream()
                .map(element -> mapper.map(element, UserReadDto.class))
                .collect(Collectors.toList());;
        Pageable pageRequest = PageRequest.of(--page,size);
        Page<User> entities = repository.findAll(pageRequest);
        Page<UserReadDto> pageDtoR = new PageImpl<>(listDto, pageRequest, entities.getTotalElements());
        PageDto<UserReadDto> pageDto = mapper.map(pageDtoR,PageDto.class);
        return pageDto;
    }

    @Override
    public UserReadDto get(UUID uuid) {
        if (uuid == null) {
            throw new IllegalArgumentException("This field cannot be null");
        }
        User entity = repository.findById(uuid).
                orElseThrow(()-> {
                    throw new IllegalArgumentException("Нет такого User");
                });
        return mapper.map(entity,UserReadDto.class);
    }

    @Override
    public UserCreatDto update(UserCreatDto dto, UUID uuid, Long dtUpdate) {
        LocalDateTime dateUpdate = LocalDateTime.ofInstant(Instant.ofEpochMilli(dtUpdate), ZoneId.systemDefault());
        User entity = repository.findById(uuid).orElseThrow(()-> {
            throw new IllegalArgumentException("Нет такого User");
        });
        if (entity.getDtUpdate().equals(dateUpdate)) {
            entity.setDtUpdate(LocalDateTime.now());
            entity.setMail(dto.getMail());
            entity.setNick(dto.getNick());
            entity.setRole(dto.getRole());
            entity.setStatus(dto.getStatus());
            repository.save(entity);
        } else {
            throw new OptimisticLockException("Entity already updated");
        }
        return dto;
    }

    @Override
    public RegistrationDto registration (RegistrationDto dto) {
        User entity = mapper.map(dto, User.class);
        entity.setUuid(UUID.randomUUID());
        entity.setDtCreate(LocalDateTime.now());
        entity.setDtUpdate(LocalDateTime.now());
        entity.setRole(Role.USER);
        entity.setStatus(Status.WAITING_ACTIVATION);//////Вопрос по активации
        repository.save(entity);
        return dto;
    }

    @Override
    public LoginUserDto login(LoginUserDto dto) {
        User entity = repository.findByMail(dto.getMail());
        if (entity.getPassword().equals(dto.getPassword())){
            ///
        }
        return null;
    }
}
