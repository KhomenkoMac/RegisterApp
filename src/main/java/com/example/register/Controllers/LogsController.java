package com.example.register.Controllers;

import com.example.register.Repositories.LogRecordsRepo;
import com.example.register.Services.Interf.AuthorizationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@AllArgsConstructor
@Controller
public class LogsController {
    private final LogRecordsRepo logRecordsRepo;
    private final AuthorizationService authorizationService;

    @GetMapping("/logs")
    String index(Model model){
        model.addAttribute("auth_service", authorizationService);
        model.addAttribute("logs", logRecordsRepo.findAll());
        return "Logs/index";
    }

}
