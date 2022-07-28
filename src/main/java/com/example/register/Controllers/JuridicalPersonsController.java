package com.example.register.Controllers;

import com.example.register.Models.JuridicalPerson;
import com.example.register.Repositories.ActivityKindsRepo;
import com.example.register.Repositories.OwnershipTypesRepo;
import com.example.register.Services.Interf.AuthorizationService;
import com.example.register.Services.Interf.JuridicalPersonsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
public class JuridicalPersonsController {
    private final JuridicalPersonsService jurPersService;
    private final OwnershipTypesRepo ownershipTypesRepo;
    private final ActivityKindsRepo activityKindsRepo;
    private final AuthorizationService authorizationService;

    @GetMapping("/jurpers")
    String index(Model model){
        model.addAttribute("auth_service", authorizationService);
        model.addAttribute("models", jurPersService.getAllJuridicalPersons());
        return "JuridicalPersons/index";
    }

    @PostMapping("/jurpers")
    String index(@RequestParam String enterprice_name, @RequestParam String edrpou, Model model){
        model.addAttribute("auth_service", authorizationService);

        //
        var init =  jurPersService.getAllJuridicalPersons();

        if (!enterprice_name.isEmpty()) {
            init = init.stream().filter(obj-> obj.getEnterpriseName().equals(enterprice_name)).collect(Collectors.toList());
        }

        if (!edrpou.isEmpty()) {
            init = init.stream().filter(obj-> obj.getEdrpou().equals(edrpou)).collect(Collectors.toList());
        }

        model.addAttribute("models", init);

        return "JuridicalPersons/index";
    }

    @GetMapping("/jurpers/create")
    String create(Model model){
        model.addAttribute("auth_service", authorizationService);
        model.addAttribute("model", new JuridicalPerson());
        model.addAttribute("ownershipTypes", ownershipTypesRepo.findAll());
        model.addAttribute("activityKinds", activityKindsRepo.findAll());
        return "JuridicalPersons/create";
    }

    @PostMapping("/jurpers/create")
    String create(@ModelAttribute("model") JuridicalPerson obj){
        jurPersService.addJuridicalPerson(obj);
        return "redirect:/jurpers";
    }

    @GetMapping("/jurpers/edit/{id}")
    String edit(@PathVariable("id") int userId, Model model){
        model.addAttribute("auth_service", authorizationService);
        model.addAttribute("ownershipTypes", ownershipTypesRepo.findAll());
        model.addAttribute("activityKinds", activityKindsRepo.findAll());
        model.addAttribute("model", jurPersService.getJuridicalPerson(userId));
        return "JuridicalPersons/edit";
    }

    @PostMapping("/jurpers/edit/{id}")
    String edit(@ModelAttribute("model") JuridicalPerson obj){
        jurPersService.updateJuridicalPerson(obj);
        return "redirect:/jurpers";
    }

    @GetMapping("/jurpers/delete/{id}")
    String delete(@PathVariable("id") int modelId, Model model){
        model.addAttribute("auth_service", authorizationService);
        model.addAttribute("model", jurPersService.getJuridicalPerson(modelId));
        return "JuridicalPersons/delete";
    }

    @PostMapping("/jurpers/delete/{id}")
    String deleteConfirmed(@PathVariable("id") int modelId){
        jurPersService.removeJuridicalPerson(modelId);
        return "redirect:/jurpers";
    }

    @GetMapping("/jurpers/details/{id}")
    String details(@PathVariable("id") int modelId, Model model){
        model.addAttribute("auth_service", authorizationService);
        model.addAttribute("model", jurPersService.getJuridicalPerson(modelId));
        return "JuridicalPersons/details";
    }
}

