package com.example.LoginRegisterEmail.entities;

import javax.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "generic")
public class Generic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "generic_id")
    private Long genericId;

    @Column(name = "name")
    private String name;
}
