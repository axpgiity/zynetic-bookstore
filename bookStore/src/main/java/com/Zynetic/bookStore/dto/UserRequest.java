package com.Zynetic.bookStore.dto;

public class UserRequest {
    private String email;
    private String password;

    public UserRequest() {
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}