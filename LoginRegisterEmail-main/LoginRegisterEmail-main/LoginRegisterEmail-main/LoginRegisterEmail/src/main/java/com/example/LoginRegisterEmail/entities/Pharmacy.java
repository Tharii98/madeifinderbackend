package com.example.LoginRegisterEmail.entities;

import javax.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "pharmacy")
public class Pharmacy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pharmacyId")
    private Long Id;


    private String name;


    private String telephone;

    private String address;

   // public void setName(Object name) {
  //  }



//    public Object getName() {
//        return null;
//    }
//
//    public void setName(Object name) {
//    }


//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "pharmacyLocation")
//    private Location pharmacyLocation;

//    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
//    Set<User> user;
}





