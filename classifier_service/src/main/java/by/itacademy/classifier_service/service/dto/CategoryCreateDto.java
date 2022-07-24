package by.itacademy.classifier_service.service.dto;

import javax.validation.constraints.NotBlank;

public class CategoryCreateDto {
    private String title;

    public CategoryCreateDto() {
    }

    @NotBlank
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
