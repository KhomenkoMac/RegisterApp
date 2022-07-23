package com.example.register.Services.Impl;

import com.example.register.Models.JuridicalPerson;
import com.example.register.Services.Interf.JuridicalPersonsService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SimpleJuridicalPersonsService implements JuridicalPersonsService {

    @Override
    public JuridicalPerson addJuridicalPerson(JuridicalPerson model) {
        return null;
    }

    @Override
    public void updateJuridicalPerson(JuridicalPerson model) {

    }

    @Override
    public Set<JuridicalPerson> getAllJuridicalPersons() {
        return null;
    }

    @Override
    public JuridicalPerson removeJuridicalPerson(int juridicalPersonId) {
        return null;
    }

    @Override
    public JuridicalPerson getJuridicalPerson(int juridicalPersonId) {
        return null;
    }
}
