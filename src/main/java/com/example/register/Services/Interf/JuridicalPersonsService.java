package com.example.register.Services.Interf;

import com.example.register.Models.JuridicalPerson;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

public interface JuridicalPersonsService {
    JuridicalPerson addJuridicalPerson(JuridicalPerson model);
    void updateJuridicalPerson(JuridicalPerson model);
    List<JuridicalPerson> getAllJuridicalPersons();
    void removeJuridicalPerson(int juridicalPersonId);
    JuridicalPerson getJuridicalPerson(int juridicalPersonId) throws NoSuchElementException;
}
