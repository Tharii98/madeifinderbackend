package com.example.LoginRegisterEmail.registration;


import lombok.*;

@Getter
@Setter
public class RegisterRequest {
    private String FirstName;
    private String lastName;
    private Integer mobileNo;
    private String email;
    private String password;

    public RegisterRequest(String firstName, String lastName, Integer mobileNo, String email, String password) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setMobileNo(mobileNo);
        this.setEmail(email);
        this.setPassword(password);
    }
}
