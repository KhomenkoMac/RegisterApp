package com.example.register.Services.Impl;

import com.example.register.Models.JuridicalPerson;
import com.example.register.Models.PhysicalPersonEntrepreneur;
import com.example.register.Services.Interf.PhysicalPersonEntrepreneursService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SimplePhysicalPersonEntrepreneursService implements PhysicalPersonEntrepreneursService {
    @Override
    public JuridicalPerson addPhysicalPersonEntrepreneur(PhysicalPersonEntrepreneur model) {
        return null;
    }

    @Override
    public void updatePhysicalPersonEntrepreneur(PhysicalPersonEntrepreneur model) {

    }

    @Override
    public Set<JuridicalPerson> getAllPhysicalPersonEntrepreneurs() {
        return null;
    }

    @Override
    public JuridicalPerson removePhysicalPersonEntrepreneur(int physicalPersonEntrepreneurId) {
        return null;
    }

    @Override
    public JuridicalPerson getPhysicalPersonEntrepreneur(int physicalPersonEntrepreneurId) {
        return null;
    }
}
