package com.example.register.Controllers;

import com.example.register.Models.PhysicalPersonEntrepreneur;
import com.example.register.Repositories.PassportSeriesRepo;
import com.example.register.Services.Interf.AuthorizationService;
import com.example.register.Services.Interf.PhysicalPersonEntrepreneursService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
public class PhysicalPersonEntepreneursController {
    private final PhysicalPersonEntrepreneursService physPersService;
    private final PassportSeriesRepo passportSeriesRepo;
    private final AuthorizationService authorizationService;

    @GetMapping("/physpers")
    String index(Model model){
        model.addAttribute("auth_service", authorizationService);
        model.addAttribute("models", physPersService.getAllPhysicalPersonEntrepreneurs());
        return "PhysicalPersonEntepreneur/index";
    }

    @PostMapping("/physpers")
    String index(@RequestParam String surname, @RequestParam String name, @RequestParam String patronymic,  Model model){
        model.addAttribute("auth_service", authorizationService);

        //
        var init =  physPersService.getAllPhysicalPersonEntrepreneurs();

        if (!surname.isEmpty()) {
            init = init.stream().filter(obj-> obj.getSurname().equals(surname)).collect(Collectors.toList());
        }

        if (!name.isEmpty()) {
            init = init.stream().filter(obj-> obj.getName().equals(name)).collect(Collectors.toList());
        }

        if (!patronymic.isEmpty()) {
            init = init.stream().filter(obj-> obj.getPatronymic().equals(patronymic)).collect(Collectors.toList());
        }

        model.addAttribute("models", init);

        return "PhysicalPersonEntepreneur/index";
    }

    @GetMapping("/physpers/create")
    String create(Model model){
        model.addAttribute("auth_service", authorizationService);
        model.addAttribute("model", new PhysicalPersonEntrepreneur());
        model.addAttribute("series", passportSeriesRepo.findAll());
        return "PhysicalPersonEntepreneur/create";
    }

    @PostMapping("/physpers/create")
    String create(@ModelAttribute("model") PhysicalPersonEntrepreneur obj){
        physPersService.addPhysicalPersonEntrepreneur(obj);
        return "redirect:/physpers";
    }

    @GetMapping("/physpers/edit/{id}")
    String edit(@PathVariable("id") int userId, Model model){
        model.addAttribute("auth_service", authorizationService);
        model.addAttribute("series", passportSeriesRepo.findAll());
        model.addAttribute("model", physPersService.getPhysicalPersonEntrepreneur(userId));
        return "PhysicalPersonEntepreneur/edit";
    }

    @PostMapping("/physpers/edit/{id}")
    String edit(@ModelAttribute("model") PhysicalPersonEntrepreneur obj){
        physPersService.updatePhysicalPersonEntrepreneur(obj);
        return "redirect:/physpers";
    }

    @GetMapping("/physpers/delete/{id}")
    String delete(@PathVariable("id") int modelId, Model model){
        model.addAttribute("auth_service", authorizationService);
        model.addAttribute("model", physPersService.getPhysicalPersonEntrepreneur(modelId));
        return "PhysicalPersonEntepreneur/delete";
    }

    @PostMapping("/physpers/delete/{id}")
    String deleteConfirmed(@PathVariable("id") int modelId){
        physPersService.removePhysicalPersonEntrepreneur(modelId);
        return "redirect:/physpers";
    }

    @GetMapping("/physpers/details/{id}")
    String details(@PathVariable("id") int modelId, Model model){
        model.addAttribute("auth_service", authorizationService);
        model.addAttribute("model", physPersService.getPhysicalPersonEntrepreneur(modelId));
        return "PhysicalPersonEntepreneur/details";
    }
}
