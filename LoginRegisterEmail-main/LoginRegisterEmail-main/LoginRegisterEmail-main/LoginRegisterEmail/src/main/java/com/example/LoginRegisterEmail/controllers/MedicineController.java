package com.example.LoginRegisterEmail.controllers;

import com.example.LoginRegisterEmail.dto.MedicineDTO;
import com.example.LoginRegisterEmail.services.MedicineService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicines")
public class MedicineController {
    private final MedicineService medicineService;

    public MedicineController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    @GetMapping
    public List<MedicineDTO> getAllMedicines() {
        return medicineService.getAllMedicines();
    }

    @GetMapping("/{id}")
    public MedicineDTO getMedicineById(@PathVariable Long id) {
        return medicineService.getMedicineById(id);
    }

    @PostMapping
    public MedicineDTO createMedicine(@RequestBody MedicineDTO medicineDTO) {
        return medicineService.createMedicine(medicineDTO);
    }

    @PutMapping("/{id}")
    public MedicineDTO updateMedicine(@PathVariable Long id, @RequestBody MedicineDTO medicineDTO) {
        return medicineService.updateMedicine(id, medicineDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteMedicine(@PathVariable Long id) {
        medicineService.deleteMedicine(id);
    }
}




