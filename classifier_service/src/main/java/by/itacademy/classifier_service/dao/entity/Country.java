package by.itacademy.classifier_service.dao.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "country", schema = "afisha_test")
public class Country {

    private UUID uuid;
    private LocalDateTime dtCreate;
    private LocalDateTime dtUpdate;
    private String title;
    private String description;

    public Country() {
    }

    @Id
    public UUID getUuid() {
        return uuid;
    }

    @NotNull
    public LocalDateTime getDtCreate() {
        return dtCreate;
    }

    @Version
    @NotNull
    public LocalDateTime getDtUpdate() {
        return dtUpdate;
    }

    @NotNull
    public String getTitle() {
        return title;
    }

    @NotNull
    public String getDescription() {
        return description;
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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
