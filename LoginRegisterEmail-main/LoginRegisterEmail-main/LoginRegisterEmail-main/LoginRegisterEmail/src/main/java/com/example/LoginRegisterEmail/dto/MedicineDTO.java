package com.example.LoginRegisterEmail.dto;

import com.example.LoginRegisterEmail.entities.Medicine;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicineDTO {
        private Long id;
        private String name;
        private String description;
        private boolean available;
}


