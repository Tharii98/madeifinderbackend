package com.example.LoginRegisterEmail.services;


import com.example.LoginRegisterEmail.dto.MedicineDTO;
import com.example.LoginRegisterEmail.entities.Medicine;
import com.example.LoginRegisterEmail.repoistory.MedicineRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MedicineService {
    private final MedicineRepository medicineRepository;

    public MedicineService(MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    public List<MedicineDTO> getAllMedicines() {
        List<Medicine> medicines = medicineRepository.findAll();
        List<MedicineDTO> medicineDTOs = new ArrayList<>();

        for (Medicine medicine : medicines) {
            medicineDTOs.add(convertToDTO(medicine));
        }

        return medicineDTOs;
    }

    public MedicineDTO getMedicineById(Long id) {
        Optional<Medicine> medicineOptional = medicineRepository.findById(id);
        return medicineOptional.map(this::convertToDTO).orElse(null);
    }

    public MedicineDTO createMedicine(MedicineDTO medicineDTO) {
        Medicine medicine = convertToEntity(medicineDTO);
        Medicine savedMedicine = medicineRepository.save(medicine);
        return convertToDTO(savedMedicine);
    }

    public MedicineDTO updateMedicine(Long id, MedicineDTO medicineDTO) {
        Optional<Medicine> medicineOptional = medicineRepository.findById(id);
        if (medicineOptional.isPresent()) {
            Medicine existingMedicine = medicineOptional.get();
            existingMedicine.setName(medicineDTO.getName());
            existingMedicine.setDescription(medicineDTO.getDescription());
            existingMedicine.setAvailable(medicineDTO.isAvailable());
            Medicine updatedMedicine = medicineRepository.save(existingMedicine);
            return convertToDTO(updatedMedicine);
        }
        return null;
    }

    public void deleteMedicine(Long id) {
        medicineRepository.deleteById(id);
    }

    private MedicineDTO convertToDTO(Medicine medicine) {
        MedicineDTO dto = new MedicineDTO();
        dto.setId(medicine.getId());
        dto.setName(medicine.getName());
        dto.setDescription(medicine.getDescription());
        dto.setAvailable(medicine.isAvailable());
        return dto;
    }

    private Medicine convertToEntity(MedicineDTO dto) {
        Medicine medicine = new Medicine();
        medicine.setId(dto.getId());
        medicine.setName(dto.getName());
        medicine.setDescription(dto.getDescription());
        medicine.setAvailable(dto.isAvailable());
        return medicine;
    }
}
