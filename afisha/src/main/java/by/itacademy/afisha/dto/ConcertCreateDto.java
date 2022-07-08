package by.itacademy.afisha.dto;

import by.itacademy.afisha.dao.entity.enums.Status;
import by.itacademy.afisha.dao.entity.enums.Type;

import java.time.LocalDateTime;
import java.util.UUID;

public class ConcertCreateDto {
    private String title;
    private String description;
    private LocalDateTime dtEvent;
    private LocalDateTime dtEndOfSale;
    private Type type;
    private Status status;
    private UUID category;

    public ConcertCreateDto(String title, String description, LocalDateTime dtEvent,
                            LocalDateTime dtEndOfSale, Type type, Status status, UUID category) {

        this.title = title;
        this.description = description;
        this.dtEvent = dtEvent;
        this.dtEndOfSale = dtEndOfSale;
        this.type = type;
        this.status = status;
        this.category = category;
    }


    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDtEvent() {
        return dtEvent;
    }

    public LocalDateTime getDtEndOfSale() {
        return dtEndOfSale;
    }

    public Type getType() {
        return type;
    }

    public Status getStatus() {
        return status;
    }

    public UUID getCategory() {
        return category;
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

    public void setCategory(UUID category) {
        this.category = category;
    }

    public static final class Builder {

        private String title;
        private String description;
        private LocalDateTime dtEvent;
        private LocalDateTime dtEndOfSale;
        private Type type;
        private Status status;
        private UUID category;

        public Builder() {
        }


        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setDtEvent(LocalDateTime dtEvent) {
            this.dtEvent = dtEvent;
            return this;
        }

        public Builder setDtEndOfSale(LocalDateTime dtEndOfSale) {
            this.dtEndOfSale = dtEndOfSale;
            return this;
        }

        public Builder setType(Type type) {
            this.type = type;
            return this;
        }

        public Builder setStatus(Status status) {
            this.status = status;
            return this;
        }

        public Builder setCategory(UUID category) {
            this.category = category;
            return this;
        }

        public static Builder create(){
            return new Builder();
        }

        public ConcertCreateDto build(){
            return new ConcertCreateDto(title, description, dtEvent,
                                      dtEndOfSale, type, status, category);
        }
    }
}
