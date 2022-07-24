package by.itacademy.user.service.api;

import by.itacademy.user.dao.entity.User;
import by.itacademy.user.service.dto.*;


public interface IUserService {
    RegistrationDto save (RegistrationDto dto);
    User login(LoginUserDto dto);
    UserReadDto getMe(String mail);
}
