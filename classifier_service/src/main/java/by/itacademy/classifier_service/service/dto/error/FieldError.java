package by.itacademy.classifier_service.service.dto.error;

public class FieldError {
    private String message;
    private String field;

    public FieldError(String message, String field) {
        this.message = message;
        this.field = field;
    }

    public FieldError() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
