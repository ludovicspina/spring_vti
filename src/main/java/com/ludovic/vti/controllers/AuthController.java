package com.ludovic.vti.controllers;

import com.ludovic.vti.models.Game;
import com.ludovic.vti.models.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    @GetMapping("/login")
    public String showLogin() {
        return "/login";
    }
}
