package com.example.LoginRegisterEmail.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PharmacyDTO {
    @Id
    private Long id;
    private String name;
    private String telephone;
    private String address;

}

