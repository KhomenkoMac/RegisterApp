package com.example.register;

import com.example.register.Models.User;
import com.example.register.Models.*;
import com.example.register.Repositories.ActivityKindsRepo;
import com.example.register.Repositories.OwnershipTypesRepo;
import com.example.register.Repositories.PassportSeriesRepo;
import com.example.register.Repositories.RolesRepo;
import com.example.register.Services.Interf.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class RegisterApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(RegisterApplication.class, args);
    }

    @Autowired
    private UsersService usersService;

    @Autowired
    private RolesRepo roleRepo;

    @Autowired
    private PassportSeriesRepo passportSeriesRepo;

    @Autowired
    private ActivityKindsRepo activityKindRepo;

    @Autowired
    private OwnershipTypesRepo ownershipTypesRepo;

    private void userSeedGenerate(){
        var passportSeries1 = PassportSeries.builder()
                .name("CV")
                .build();

        var passportSeries2 = PassportSeries.builder()
                .name("TT")
                .build();

        var passportSeries3 = PassportSeries.builder()
                .name("AA")
                .build();

        passportSeriesRepo.save(passportSeries1);
        passportSeriesRepo.save(passportSeries2);
        passportSeriesRepo.save(passportSeries3);

        var place = Place.builder()
                .city("City1")
                .street("Street1")
                .building("11-A")
                .apartment("34A")
                .build();

        var role = Role.builder()
                .name("адміністратор")
                .build();
        var role2 = Role.builder()
                .name("реєстратор")
                .build();

        roleRepo.save(role);
        roleRepo.save(role2);

        var passportData = PassportData.builder()
                .passportNumber("123123")
                .passportIssuanceDate(new Date())
                .taxPayerCode("123321")
                .build();

        User newOne = User.builder()
                .name("Name1")
                .surname("surname1")
                .patronymic("patron1")
                .birthdate(new Date())
                .email("surname1@ukr.net")
                .password("123")
                .role(role)
                .passportData(passportData)
                .build();
        usersService.addUser(newOne);
    }

    private void ownershipTypesSeed(){
        var ownershipType1 = OwnershipType.builder()
                .name("Недержавна власність")
                .build();

        var ownershipType2 = OwnershipType.builder()
                .name("Тип власності 2")
                .build();

        var ownershipType3 = OwnershipType.builder()
                .name("Тип власності 3")
                .build();

        ownershipTypesRepo.save(ownershipType1);
        ownershipTypesRepo.save(ownershipType2);
        ownershipTypesRepo.save(ownershipType3);
    }

    private void activityKindsSeed(){
        var activityKind1 = ActivityKind.builder()
                .name("94.99 Діяльність інших громадських організацій, н.в.і.у.")
                .build();

        var activityKind2 = ActivityKind.builder()
                .name("Вид Діяльності 2")
                .build();

        var activityKind3 = ActivityKind.builder()
                .name("Вид Діяльності 3")
                .build();

        activityKindRepo.save(activityKind1);
        activityKindRepo.save(activityKind2);
        activityKindRepo.save(activityKind3);
    }

    @Override
    public void run(String... args) throws Exception {
//        userSeedGenerate();
//       activityKindsSeed();
//        ownershipTypesSeed();
    }
}
