package com.example.register.Repositories;

import com.example.register.Models.JuridicalPerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JuridicalPersonsRepo extends JpaRepository<JuridicalPerson, Integer> {
}
