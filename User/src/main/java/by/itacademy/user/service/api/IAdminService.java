package by.itacademy.user.service.api;

import by.itacademy.user.service.dto.*;

import java.util.UUID;

public interface IAdminService {
    UserCreatDto create(UserCreatDto dto);

    PageDto<UserReadDto> getAll(int page, int size);

    UserReadDto get(UUID uuid);

    UserCreatDto update (UserCreatDto dto, UUID uuid, Long dtUpdate);
    RegistrationDto registration (RegistrationDto dto);

    LoginUserDto login(LoginUserDto dto);
}
