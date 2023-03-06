package com.ludovic.vti.controllers;

import com.ludovic.vti.models.Users;
import com.ludovic.vti.repositories.UserRepository;
import org.apache.catalina.User;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users/add")
    public String showForm(Users users) {
        return "/users/add";
    }

    @GetMapping("/users/list")
    public String showUsers(Model model) {
        Iterable<Users> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "/users/list";
    }

    @PostMapping("/users/add")
    public String saveUser(@ModelAttribute("user") Users user) {
        user.setPassword(passwordEncoder().encode(user.getPassword()));
        userRepository.save(user);
        return "redirect:/users/list";
    }
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
