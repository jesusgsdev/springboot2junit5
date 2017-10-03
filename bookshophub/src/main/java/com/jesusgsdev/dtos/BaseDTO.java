package com.jesusgsdev.dtos;

public class BaseDTO {

    private String error;

    private String errorMessage;

    public BaseDTO() {
    }

    public BaseDTO(String error, String errorMessage) {
        this.error = error;
        this.errorMessage = errorMessage;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
