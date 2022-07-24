package by.itacademy.user.service.dto;

import by.itacademy.user.dao.entity.enums.RoleNoten;
import by.itacademy.user.dao.entity.enums.Status;

import java.time.LocalDateTime;
import java.util.UUID;

public class UserReadDto {
    private UUID uuid;
    private LocalDateTime dtCreate;
    private LocalDateTime dtUpdate;
    private String mail;
    private String nick;
    private RoleNoten role;
    private Status status;

    public UserReadDto() {
    }

    public UUID getUuid() {
        return uuid;
    }

    public LocalDateTime getDtCreate() {
        return dtCreate;
    }

    public LocalDateTime getDtUpdate() {
        return dtUpdate;
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

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public void setDtCreate(LocalDateTime dtCreate) {
        this.dtCreate = dtCreate;
    }

    public void setDtUpdate(LocalDateTime dtUpdate) {
        this.dtUpdate = dtUpdate;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public void setRole(RoleNoten role) {
        this.role = role;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
