package by.itacademy.classifier_service.dao.entity;

import javax.persistence.*;
import java.io.Serializable;
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public UUID getUuid() {
        return uuid;
    }
    @Column(name = "dt_create")
    public LocalDateTime getDtCreate() {
        return dtCreate;
    }
    @Column(name = "dt_update")
    public LocalDateTime getDtUpdate() {
        return dtUpdate;
    }

    public String getTitle() {
        return title;
    }

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
