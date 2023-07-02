package com.example.LoginRegisterEmail.repoistory;

import com.example.LoginRegisterEmail.entities.Generic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenericRepository extends JpaRepository<Generic,Long> {
}
