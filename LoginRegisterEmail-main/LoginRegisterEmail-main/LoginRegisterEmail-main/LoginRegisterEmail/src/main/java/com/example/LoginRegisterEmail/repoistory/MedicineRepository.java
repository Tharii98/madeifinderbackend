package com.example.LoginRegisterEmail.repoistory;

import com.example.LoginRegisterEmail.entities.Medicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long> {
    // You can define custom queries here if needed
}


