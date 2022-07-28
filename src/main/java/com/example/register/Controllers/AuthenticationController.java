package com.example.register.Controllers;

import com.example.register.utils.MessageData;
import com.example.register.Exceptions.AuthenticationFailedException;
import com.example.register.Models.SignIn;
import com.example.register.Services.Interf.AuthorizationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.NoSuchElementException;

@Controller
@AllArgsConstructor
public class AuthenticationController {
    public static final String currentUserKey = "current_user";

    private final AuthorizationService authorizationService;

    @GetMapping("/sign-in")
    String Index(Model model){
        model.addAttribute("auth_service", authorizationService);
        model.addAttribute("user", new SignIn());
        return "Authorization/index";
    }

    @PostMapping("/sign-in")
    String SignIn(@ModelAttribute("user") SignIn signIn){
        try{
            var currentUser = authorizationService.signIn(signIn.getEmail(), signIn.getPassword());
            MessageData.setSuccessMessage("Вхід здійснено");
        }
        catch(NoSuchElementException | AuthenticationFailedException e){
            MessageData.setFailedMessage("Вхід не здійснено");
            return "redirect:/failed";
        }

        return "redirect:/success";
    }

    @GetMapping("/sign-out")
    String SignOut(){
        authorizationService.signOut();
        return "redirect:/";
    }
}
