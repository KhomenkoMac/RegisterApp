package com.example.register.Services.Interf;

import com.example.register.Models.JuridicalPerson;
import com.example.register.Models.PhysicalPersonEntrepreneur;

import java.util.Set;

public interface PhysicalPersonEntrepreneursService {
    JuridicalPerson addPhysicalPersonEntrepreneur(PhysicalPersonEntrepreneur model);
    void updatePhysicalPersonEntrepreneur(PhysicalPersonEntrepreneur model);
    Set<JuridicalPerson> getAllPhysicalPersonEntrepreneurs();
    JuridicalPerson removePhysicalPersonEntrepreneur(int physicalPersonEntrepreneurId);
    JuridicalPerson getPhysicalPersonEntrepreneur(int physicalPersonEntrepreneurId);
}
