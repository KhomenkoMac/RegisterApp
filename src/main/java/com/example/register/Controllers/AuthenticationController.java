package com.example.register.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AuthenticationController {

    @GetMapping("/SignIn")
    @ResponseBody
    String SignIn(String Email, String Password){
        return String.format("Sign in -> Email: %s;Password %s", Email, Password);
    }

    @GetMapping("/SignUp")
    @ResponseBody
    String SignUp(String email, String password){
        return String.format("Sign up -> Email: %s;Password %s", email, password);
    }
}
