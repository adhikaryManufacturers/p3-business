package com.example.demo.model;

public class LoginResponse {

    private boolean success;
    private String email;
    private String message;

    public LoginResponse() {}

    public LoginResponse(boolean success, String email, String message) {
        this.success = success;
        this.email = email;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}