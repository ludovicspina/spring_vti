package com.ludovic.vti.controllers;

import com.ludovic.vti.models.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController {

    @GetMapping("/")
    public String index() {
        return "base";
    }

}
