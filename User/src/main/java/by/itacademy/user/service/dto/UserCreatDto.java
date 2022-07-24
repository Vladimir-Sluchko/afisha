package by.itacademy.user.service.dto;

import by.itacademy.user.dao.entity.enums.RoleNoten;
import by.itacademy.user.dao.entity.enums.Status;

public class UserCreatDto {
    private String mail;
    private String nick;
    private RoleNoten role;
    private Status status;
    private String password;

    public UserCreatDto() {
    }

    public String getMail() {
        return mail;
    }

    public String getNick() {
        return nick;
    }

    public RoleNoten getRole() {
        return role;
    }

    public Status getStatus() {
        return status;
    }

    public String getPassword() {
        return password;
    }


}
