package com.example.register.Services.Interf;

import com.example.register.Models.JuridicalPerson;

import java.util.Set;

public interface JuridicalPersonsService {
    JuridicalPerson addJuridicalPerson(JuridicalPerson model);
    void updateJuridicalPerson(JuridicalPerson model);
    Set<JuridicalPerson> getAllJuridicalPersons();
    JuridicalPerson removeJuridicalPerson(int juridicalPersonId);
    JuridicalPerson getJuridicalPerson(int juridicalPersonId);
}
