package by.itacademy.classifier_service.service.dto;

public class CountryCreateDto {
    private String title;
    private String description;

    public CountryCreateDto() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
