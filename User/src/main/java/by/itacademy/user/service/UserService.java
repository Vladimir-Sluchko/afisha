package by.itacademy.user.service;


import by.itacademy.user.dao.api.RoleRepository;
import by.itacademy.user.dao.api.UserRepository;

import by.itacademy.user.dao.entity.Role;
import by.itacademy.user.dao.entity.User;
import by.itacademy.user.dao.entity.enums.Status;
import by.itacademy.user.service.api.IUserService;
import by.itacademy.user.service.dto.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Service
public class UserService implements IUserService {
    private final UserRepository repository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder encoder;

    public UserService(UserRepository repository,PasswordEncoder encoder, RoleRepository roleRepository) {
        this.repository = repository;
        this.roleRepository = roleRepository;
        this.encoder = encoder;
    }

    public RegistrationDto save(RegistrationDto dto) {
        if (repository.existsByMail(dto.getMail())) {
            throw new EntityExistsException("User already exists");
        }

        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findByAuthority("USER"));

        User entity = new User();
        entity.setUuid(UUID.randomUUID());
        entity.setDtCreate(LocalDateTime.now());
        entity.setDtUpdate(LocalDateTime.now());
        entity.setMail(dto.getMail());
        entity.setUsername(dto.getNick());
        entity.setAuthorities(roles);
        entity.setStatus(Status.WAITING_ACTIVATION);
        entity.setPassword(encoder.encode(dto.getPassword()));
        entity.setAccountNonExpired(true);
        entity.setAccountNonLocked(true);
        entity.setCredentialsNonExpired(true);
        entity.setEnabled(true);
        repository.save(entity);
        return dto;
    }

    @Override
    public User login(LoginUserDto dto) {
        User user = repository.findByMail(dto.getMail());

        if(!encoder.matches(dto.getPassword(), user.getPassword())){
            throw new IllegalArgumentException("Wrong password");
        }
        if(!user.isEnabled()){
            throw new SecurityException("Account is blocked");
        }
        if (!user.getStatus().equals(Status.ACTIVATED)) {
            throw new SecurityException("Account not activated, wait for activation");
        }
        return user;
    }

    @Override
    public UserReadDto getMe(String mail) {
        return null;
    }

}
