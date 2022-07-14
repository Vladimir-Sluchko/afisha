package by.itacademy.user.dao.entity;

import by.itacademy.user.dao.entity.enums.Role;
import by.itacademy.user.dao.entity.enums.Status;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "user",schema = "afisha_test")
public class User {
    private UUID uuid;
    private LocalDateTime dtCreate;
    private LocalDateTime dtUpdate;
    private String mail;
    private String nick;
    private Role role;
    private Status status;

    private String password;
    public User() {
    }
    @Id
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

    @Enumerated(EnumType.STRING)
    public Role getRole() {
        return role;
    }

    @Enumerated(EnumType.STRING)
    public Status getStatus() {
        return status;
    }

    public String getPassword() {
        return password;
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

    public void setRole(Role role) {
        this.role = role;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
