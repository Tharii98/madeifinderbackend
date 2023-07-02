package com.example.LoginRegisterEmail.controllers;

import com.example.LoginRegisterEmail.dto.PharmacyDTO;
import com.example.LoginRegisterEmail.services.PharmacyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pharmacies")
public class PharmacyController {
    private final PharmacyService pharmacyService;

    public PharmacyController(PharmacyService pharmacyService) {
        this.pharmacyService = pharmacyService;
    }

    @PostMapping
    public ResponseEntity<PharmacyDTO> createPharmacy(@RequestBody PharmacyDTO pharmacyDTO) {
        PharmacyDTO createdPharmacy = pharmacyService.createPharmacy(pharmacyDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPharmacy);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PharmacyDTO> getPharmacyById(@PathVariable Long id) {
        PharmacyDTO pharmacyDTO = pharmacyService.getPharmacyById(id);
        return ResponseEntity.ok(pharmacyDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PharmacyDTO> updatePharmacy(@PathVariable Long id, @RequestBody PharmacyDTO pharmacyDTO) {
        PharmacyDTO updatedPharmacy = pharmacyService.updatePharmacy(id, pharmacyDTO);
        return ResponseEntity.ok(updatedPharmacy);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePharmacy(@PathVariable Long id) {
        pharmacyService.deletePharmacy(id);
        return ResponseEntity.noContent().build();
    }
}
