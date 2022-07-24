package by.itacademy.classifier_service.service.dto;

import com.sun.istack.NotNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class CountryCreateDto {
    private String title;
    private String description;

    public CountryCreateDto() {
    }

    @NotBlank
    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    @NotBlank
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
