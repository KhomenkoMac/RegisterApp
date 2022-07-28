package com.example.register.Services.Interf;

import com.example.register.Models.PhysicalPersonEntrepreneur;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

public interface PhysicalPersonEntrepreneursService {
    PhysicalPersonEntrepreneur addPhysicalPersonEntrepreneur(PhysicalPersonEntrepreneur model);
    void updatePhysicalPersonEntrepreneur(PhysicalPersonEntrepreneur model);
    List<PhysicalPersonEntrepreneur> getAllPhysicalPersonEntrepreneurs();
    void removePhysicalPersonEntrepreneur(int physicalPersonEntrepreneurId);
    PhysicalPersonEntrepreneur getPhysicalPersonEntrepreneur(int physicalPersonEntrepreneurId) throws NoSuchElementException;
}
