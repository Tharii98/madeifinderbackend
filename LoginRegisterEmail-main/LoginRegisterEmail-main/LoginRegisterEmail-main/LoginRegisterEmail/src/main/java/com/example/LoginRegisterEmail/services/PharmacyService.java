package com.example.LoginRegisterEmail.services;

import com.example.LoginRegisterEmail.dto.PharmacyDTO;
import com.example.LoginRegisterEmail.entities.Pharmacy;
import com.example.LoginRegisterEmail.repoistory.PharmacyRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class PharmacyService {
    private final PharmacyRepository pharmacyRepository;

    public PharmacyService(PharmacyRepository pharmacyRepository) {
        this.pharmacyRepository = pharmacyRepository;
    }

    public PharmacyDTO createPharmacy(PharmacyDTO pharmacyDTO) {
        Pharmacy pharmacy = new Pharmacy();
        pharmacy.setName(pharmacyDTO.getName());
        pharmacy.setTelephone(pharmacyDTO.getTelephone());
        pharmacy.setAddress(pharmacyDTO.getAddress());

        Pharmacy savedPharmacy = pharmacyRepository.save(pharmacy);

        return mapPharmacyToDTO(savedPharmacy);
    }

    public PharmacyDTO getPharmacyById(Long id) {
        Pharmacy pharmacy = pharmacyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pharmacy not found with id: " + id));

        return mapPharmacyToDTO(pharmacy);
    }

    public PharmacyDTO updatePharmacy(Long id, PharmacyDTO pharmacyDTO) {
        Pharmacy pharmacy = pharmacyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pharmacy not found with id: " + id));

        pharmacy.setName(pharmacyDTO.getName());
        pharmacy.setTelephone(pharmacyDTO.getTelephone());
        pharmacy.setAddress(pharmacyDTO.getAddress());

        Pharmacy updatedPharmacy = pharmacyRepository.save(pharmacy);

        return mapPharmacyToDTO(updatedPharmacy);
    }

    public void deletePharmacy(Long id) {
        Pharmacy pharmacy = pharmacyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pharmacy not found with id: " + id));

        pharmacyRepository.delete(pharmacy);
    }

    private PharmacyDTO mapPharmacyToDTO(Pharmacy pharmacy) {
        PharmacyDTO pharmacyDTO = new PharmacyDTO();
        pharmacyDTO.setId(pharmacy.getId());
        pharmacyDTO.setName(pharmacy.getName());
        pharmacyDTO.setTelephone(pharmacy.getTelephone());
        pharmacyDTO.setAddress(pharmacy.getAddress());

        return pharmacyDTO;
    }
}
