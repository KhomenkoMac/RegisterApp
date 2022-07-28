package com.example.register.Controllers;

import com.example.register.Services.Interf.AuthorizationService;
import com.example.register.utils.MessageData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    public static String successMessageKey = "success_message";
    public static String failMessageKey = "fail_message";

    private final AuthorizationService authorizationService;

    public HomeController(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @GetMapping("/")
    String index(Model model){
        model.addAttribute("auth_service", authorizationService);
        return "Home/index";
    }

    @GetMapping("/success")
    String success(Model model){
        model.addAttribute("auth_service", authorizationService);
        model.addAttribute(HomeController.successMessageKey, MessageData.getSuccessMessage().get());
        return "Home/success";
    }

    @GetMapping("/failed")
    String failed(Model model){
        model.addAttribute("auth_service", authorizationService);
        model.addAttribute(HomeController.failMessageKey, MessageData.getFailedMessage().get());
        return "Home/failed";
    }
}
