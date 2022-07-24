package by.itacademy.user.service.dto.error;

import java.util.List;

public class MultipleError {
    private final String logref = "structured_error";
    private List<FieldError> errors;

    public MultipleError() {
    }

    public MultipleError(List<FieldError> errors) {
        this.errors = errors;
    }

    public String getLogref() {
        return logref;
    }

    public List<FieldError> getErrors() {
        return errors;
    }

    public void setErrors(List<FieldError> errors) {
        this.errors = errors;
    }
}
