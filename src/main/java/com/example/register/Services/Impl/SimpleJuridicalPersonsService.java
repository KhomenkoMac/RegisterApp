package com.example.register.Services.Impl;

import com.example.register.Models.JuridicalPerson;
import com.example.register.Repositories.JuridicalPersonsRepo;
import com.example.register.Services.Interf.JuridicalPersonsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeSet;

@Service
@AllArgsConstructor
public class SimpleJuridicalPersonsService implements JuridicalPersonsService {

    private final JuridicalPersonsRepo juridicalPersonsRepo;

    @Override
    public JuridicalPerson addJuridicalPerson(JuridicalPerson model) {
        return juridicalPersonsRepo.save(model);
    }

    @Override
    public void updateJuridicalPerson(JuridicalPerson model) {
        juridicalPersonsRepo.save(model);
    }

    @Override
    public List<JuridicalPerson> getAllJuridicalPersons() {
        return juridicalPersonsRepo.findAll();
    }

    @Override
    public void removeJuridicalPerson(int juridicalPersonId) {
        juridicalPersonsRepo.deleteById(juridicalPersonId);
    }

    @Override
    public JuridicalPerson getJuridicalPerson(int juridicalPersonId) throws NoSuchElementException {
        return juridicalPersonsRepo.findById(juridicalPersonId).orElseThrow(NoSuchElementException::new);
    }
}
