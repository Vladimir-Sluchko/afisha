package by.itacademy.user.service.dto;

import by.itacademy.user.dao.entity.enums.Role;
import by.itacademy.user.dao.entity.enums.Status;

public class UserCreatDto {
    private String mail;
    private String nick;
    private Role role;
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

    public Role getRole() {
        return role;
    }

    public Status getStatus() {
        return status;
    }

    public String getPassword() {
        return password;
    }


}
