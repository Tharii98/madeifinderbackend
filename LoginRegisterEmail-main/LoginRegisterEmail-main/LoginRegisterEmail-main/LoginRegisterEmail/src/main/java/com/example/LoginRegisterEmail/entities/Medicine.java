package com.example.LoginRegisterEmail.entities;

import com.example.LoginRegisterEmail.entities.Generic;
import com.example.LoginRegisterEmail.entities.Pharmacy;
import javax.persistence.*;
import lombok.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString
@Entity
@Table(name = "medicine")
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String name;
    private String description;
    //@Column(nullable = false)
    private Boolean available;


    public void isAvailable(boolean available) {
    }

    public boolean isAvailable() {
        return available;
    }
}



