package by.itacademy.afisha.dao.entity;

import by.itacademy.afisha.controller.utils.json.LocalDateTimeDeserializer;
import by.itacademy.afisha.controller.utils.json.LocalDateTimeSerializer;
import by.itacademy.afisha.dao.entity.enums.Status;
import by.itacademy.afisha.dao.entity.enums.Type;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "event", schema ="afisha_test")
@SecondaryTable(name = "films",pkJoinColumns = @PrimaryKeyJoinColumn(name ="uuid_film"), schema = "afisha_test")
public class Film extends Event{
    private UUID country;
    private Integer releaseYear;
    private String releaseDate;
    private Integer duration;

    public Film() {
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
    }
}
