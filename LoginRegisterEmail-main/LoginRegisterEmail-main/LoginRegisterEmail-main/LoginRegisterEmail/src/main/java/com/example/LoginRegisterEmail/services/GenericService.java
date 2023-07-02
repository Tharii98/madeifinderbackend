package com.example.LoginRegisterEmail.services;

import com.example.LoginRegisterEmail.entities.Generic;
import com.example.LoginRegisterEmail.repoistory.GenericRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
@AllArgsConstructor
public class GenericService implements Serializable {

    private GenericRepository genericRepository;
    public Generic addGeneric(Generic generic) {
        return genericRepository.save(generic);
    }
}
