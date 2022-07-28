package com.example.register.Services.Impl;

import com.example.register.Models.PhysicalPersonEntrepreneur;
import com.example.register.Repositories.PhysicalPersonEntrepreneursRepo;
import com.example.register.Services.Interf.PhysicalPersonEntrepreneursService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeSet;

@Service
@AllArgsConstructor
public class SimplePhysicalPersonEntrepreneursService implements PhysicalPersonEntrepreneursService {

    private final PhysicalPersonEntrepreneursRepo physicalPersonEntrepreneursRepo;

    @Override
    public PhysicalPersonEntrepreneur addPhysicalPersonEntrepreneur(PhysicalPersonEntrepreneur model) {
        return physicalPersonEntrepreneursRepo.save(model);
    }

    @Override
    public void updatePhysicalPersonEntrepreneur(PhysicalPersonEntrepreneur model) {
        physicalPersonEntrepreneursRepo.save(model);
    }

    @Override
    public List<PhysicalPersonEntrepreneur> getAllPhysicalPersonEntrepreneurs() {
        return physicalPersonEntrepreneursRepo.findAll();
    }

    @Override
    public void removePhysicalPersonEntrepreneur(int physicalPersonEntrepreneurId) {
        physicalPersonEntrepreneursRepo.deleteById(physicalPersonEntrepreneurId);
    }

    @Override
    public PhysicalPersonEntrepreneur getPhysicalPersonEntrepreneur(int physicalPersonEntrepreneurId) {
        return physicalPersonEntrepreneursRepo.findById(physicalPersonEntrepreneurId).orElseThrow(NoSuchElementException::new);
    }
}
