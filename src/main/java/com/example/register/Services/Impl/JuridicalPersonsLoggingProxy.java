package com.example.register.Services.Impl;

import com.example.register.Models.JuridicalPerson;
import com.example.register.Models.LogRecord;
import com.example.register.Repositories.LogRecordsRepo;
import com.example.register.Services.Interf.AuthorizationService;
import com.example.register.Services.Interf.JuridicalPersonsService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Primary
@Service
@AllArgsConstructor
public class JuridicalPersonsLoggingProxy implements JuridicalPersonsService {
    private final SimpleJuridicalPersonsService simpleJuridicalPersonsService;
    private final LogRecordsRepo logRecordsRepo;
    private final AuthorizationService authorizationService;

    @Override
    public JuridicalPerson addJuridicalPerson(JuridicalPerson model) {
        var result = simpleJuridicalPersonsService.addJuridicalPerson(model);
        logRecordsRepo.save(LogRecord.builder()
                .description("Додавання відомостей юридичної особи")
                .userEmail(authorizationService.getCurrentUser().getEmail())
                .build());
        return result;
    }

    @Override
    public void updateJuridicalPerson(JuridicalPerson model) {
        simpleJuridicalPersonsService.updateJuridicalPerson(model);
        logRecordsRepo.save(LogRecord.builder()
                .description("Оновлення відомостей юридичної особи")
                .userEmail(authorizationService.getCurrentUser().getEmail())
                .build());
    }

    @Override
    public List<JuridicalPerson> getAllJuridicalPersons() {
        return simpleJuridicalPersonsService.getAllJuridicalPersons();
    }

    @Override
    public void removeJuridicalPerson(int juridicalPersonId) {
        simpleJuridicalPersonsService.removeJuridicalPerson(juridicalPersonId);
        logRecordsRepo.save(LogRecord.builder()
                .description("Видалення відомостей юридичної особи")
                .userEmail(authorizationService.getCurrentUser().getEmail())
                .build());
    }

    @Override
    public JuridicalPerson getJuridicalPerson(int juridicalPersonId) throws NoSuchElementException {
        return simpleJuridicalPersonsService.getJuridicalPerson(juridicalPersonId);
    }
}

