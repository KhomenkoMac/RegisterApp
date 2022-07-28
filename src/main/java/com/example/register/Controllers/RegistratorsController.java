package com.example.register.Controllers;

import com.example.register.Models.User;
import com.example.register.Repositories.PassportSeriesRepo;
import com.example.register.Repositories.RolesRepo;
import com.example.register.Services.Interf.AuthorizationService;
import com.example.register.Services.Interf.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
public class RegistratorsController {
    private final UsersService usersService;
    private final RolesRepo rolesRepo;
    private final PassportSeriesRepo passportSeriesRepo;
    private final AuthorizationService authorizationService;

    @GetMapping("/registrators")
    String index(Model model){
        model.addAttribute("auth_service", authorizationService);
        model.addAttribute("roles", rolesRepo.findAll());
        model.addAttribute("users", usersService.getAllUsers());
        return "Registrators/index";
    }

    @PostMapping("/registrators")
    String index(@RequestParam String surname, @RequestParam String name, @RequestParam String patronymic, @RequestParam String email, @RequestParam(defaultValue = "0") Integer roleId,   Model model){
        model.addAttribute("auth_service", authorizationService);
        model.addAttribute("roles", rolesRepo.findAll());
        //
        var init =  usersService.getAllUsers();

        if (!surname.isEmpty()) {
            init = init.stream().filter(obj-> obj.getSurname().equals(surname)).collect(Collectors.toList());
        }

        if (!name.isEmpty()) {
            init = init.stream().filter(obj-> obj.getName().equals(name)).collect(Collectors.toList());
        }

        if (!patronymic.isEmpty()) {
            init = init.stream().filter(obj-> obj.getPatronymic().equals(patronymic)).collect(Collectors.toList());
        }

        if (!email.isEmpty()) {
            init = init.stream().filter(obj-> obj.getEmail().equals(email)).collect(Collectors.toList());
        }

        if (roleId != 0) {
            init = init.stream().filter(obj-> obj.getRole().getId().equals(roleId)).collect(Collectors.toList());
        }

        model.addAttribute("users", init);

        return "Registrators/index";
    }

    @GetMapping("/registrators/create")
    String create(Model model){
        model.addAttribute("auth_service", authorizationService);
        model.addAttribute("user", new User());
        model.addAttribute("roles", rolesRepo.findAll());
        model.addAttribute("series", passportSeriesRepo.findAll());
        return "Registrators/create";
    }

    @PostMapping("/registrators/create")
    String create(@ModelAttribute("user") User user){
        usersService.addUser(user);
        return "redirect:/registrators";
    }

    @GetMapping("/registrators/edit/{id}")
    String edit(@PathVariable("id") int userId, Model model){
        model.addAttribute("auth_service", authorizationService);
        model.addAttribute("roles", rolesRepo.findAll());
        model.addAttribute("series", passportSeriesRepo.findAll());
        model.addAttribute("user", usersService.getUser(userId));
        return "Registrators/edit";
    }

    @PostMapping("/registrators/edit/{id}")
    String edit(@ModelAttribute("user") User user){
        usersService.updateUser(user);
        return "redirect:/registrators";
    }

    @GetMapping("/registrators/delete/{id}")
    String delete(@PathVariable("id") int userId, Model model){
        model.addAttribute("auth_service", authorizationService);
        model.addAttribute("user", usersService.getUser(userId));
        return "Registrators/delete";
    }

    @PostMapping("/registrators/delete/{id}")
    String deleteConfirmed(@PathVariable("id") int userId){
        usersService.removeUser(userId);
        return "redirect:/registrators";
    }

    @GetMapping("/registrators/details/{id}")
    String details(@PathVariable("id") int userId, Model model){
        model.addAttribute("auth_service", authorizationService);
        model.addAttribute("user", usersService.getUser(userId));
        return "Registrators/details";
    }
}
