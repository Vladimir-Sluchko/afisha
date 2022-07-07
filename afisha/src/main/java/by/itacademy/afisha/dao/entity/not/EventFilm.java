package by.itacademy.afisha.dao.entity.not;

import by.itacademy.afisha.controller.utils.json.LocalDateTimeDeserializer;
import by.itacademy.afisha.controller.utils.json.LocalDateTimeSerializer;
import by.itacademy.afisha.dao.entity.enums.Status;
import by.itacademy.afisha.dao.entity.enums.Type;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

/*
@Entity
@Table(name = "event", schema ="afisha_test")
@SecondaryTable(name = "films",pkJoinColumns = @PrimaryKeyJoinColumn(name ="uuid_film"), schema = "afisha_test")
*/
public class EventFilm {
   /* private UUID uuid;
    private LocalDateTime dtCreate;
    private LocalDateTime dtUpdate;
    private String title;
    private String description;
    private LocalDateTime dtEvent;
    private LocalDateTime dtEndOfSale;
    private Type type;
    private Status status;
    private UUID country;
    private Integer releaseYear;
    private String releaseDate;
    private Integer duration;




    public EventFilm() {
    }

    public EventFilm(UUID uuid, LocalDateTime dtCreate, LocalDateTime dtUpdate,
                     String title, String description, LocalDateTime dtEvent,
                     LocalDateTime dtEndOfSale, Type type, Status status,
                     UUID country, Integer releaseYear, String releaseDate,
                     Integer duration) {
        this.uuid = uuid;
        this.dtCreate = dtCreate;
        this.dtUpdate = dtUpdate;
        this.title = title;
        this.description = description;
        this.dtEvent = dtEvent;
        this.dtEndOfSale = dtEndOfSale;
        this.type = type;
        this.status = status;
        this.country = country;
        this.releaseYear = releaseYear;
        this.releaseDate = releaseDate;
        this.duration = duration;
    }

    @Id
    *//*@GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")*//*
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    public UUID getUuid() {
        return uuid;
    }


    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    public LocalDateTime getDtCreate() {
        return dtCreate;
    }


    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    public LocalDateTime getDtUpdate() {
        return dtUpdate;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    public LocalDateTime getDtEvent() {
        return dtEvent;
    }

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    public LocalDateTime getDtEndOfSale() {
        return dtEndOfSale;
    }

    @Enumerated(EnumType.STRING)
    public Type getType() {
        return type;
    }

    @Enumerated(EnumType.STRING)
    public Status getStatus() {
        return status;
    }

    @Column(table = "films")
    public UUID getCountry() {
        return country;
    }

    @Column(table = "films")
    public Integer getReleaseYear() {
        return releaseYear;
    }

    @Column(table = "films")
    public String getReleaseDate() {
        return releaseDate;
    }

    @Column(table = "films")
    public Integer getDuration() {
        return duration;
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

    public void setDtEvent(LocalDateTime dtEvent) {
        this.dtEvent = dtEvent;
    }

    public void setDtEndOfSale(LocalDateTime dtEndOfSale) {
        this.dtEndOfSale = dtEndOfSale;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setCountry(UUID country) {
        this.country = country;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }*/
}
