package com.example.register.Services.Impl;

import com.example.register.Models.LogRecord;
import com.example.register.Models.PhysicalPersonEntrepreneur;
import com.example.register.Repositories.LogRecordsRepo;
import com.example.register.Services.Interf.AuthorizationService;
import com.example.register.Services.Interf.PhysicalPersonEntrepreneursService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Primary
@Service
@AllArgsConstructor
public class PhysPersonsEntrepreneursLoggingProxy implements PhysicalPersonEntrepreneursService {
    private final SimplePhysicalPersonEntrepreneursService simplePhysicalPersonEntrepreneursService;
    private final LogRecordsRepo logRecordsRepo;
    private final AuthorizationService authorizationService;
    @Override
    public PhysicalPersonEntrepreneur addPhysicalPersonEntrepreneur(PhysicalPersonEntrepreneur model) {
        var result = simplePhysicalPersonEntrepreneursService.addPhysicalPersonEntrepreneur(model);
        logRecordsRepo.save(LogRecord.builder()
                .description("Додавання відомостей фізичної особи-підприємця")
                .userEmail(authorizationService.getCurrentUser().getEmail())
                .build());
        return result;
    }

    @Override
    public void updatePhysicalPersonEntrepreneur(PhysicalPersonEntrepreneur model) {
        simplePhysicalPersonEntrepreneursService.updatePhysicalPersonEntrepreneur(model);
        logRecordsRepo.save(LogRecord.builder()
                .description("Оновлення відомостей фізичної особи-підприємця")
                .userEmail(authorizationService.getCurrentUser().getEmail())
                .build());
    }

    @Override
    public List<PhysicalPersonEntrepreneur> getAllPhysicalPersonEntrepreneurs() {
        return simplePhysicalPersonEntrepreneursService.getAllPhysicalPersonEntrepreneurs();
    }

    @Override
    public void removePhysicalPersonEntrepreneur(int physicalPersonEntrepreneurId) {
        simplePhysicalPersonEntrepreneursService.removePhysicalPersonEntrepreneur(physicalPersonEntrepreneurId);
        logRecordsRepo.save(LogRecord.builder()
                .description("Видалення відомостей фізичної особи-підприємця")
                .userEmail(authorizationService.getCurrentUser().getEmail())
                .build());
    }

    @Override
    public PhysicalPersonEntrepreneur getPhysicalPersonEntrepreneur(int physicalPersonEntrepreneurId) throws NoSuchElementException {
        return simplePhysicalPersonEntrepreneursService.getPhysicalPersonEntrepreneur(physicalPersonEntrepreneurId);
    }
}
