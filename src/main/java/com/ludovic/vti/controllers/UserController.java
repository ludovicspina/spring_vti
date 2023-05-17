package com.ludovic.vti.controllers;

import com.ludovic.vti.models.Users;
import com.ludovic.vti.repositories.RoleRepository;
import com.ludovic.vti.repositories.UserRepository;
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
    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/admin/users/add")
    public String addNewUser(Model model) {
        Users user = new Users();
        model.addAttribute("user", user);
        model.addAttribute("roles_list", roleRepository.findAll());
        return "/admin/users/add";
    }

    @PostMapping("/admin/users/save")
    public String saveUser(@ModelAttribute("user") Users user) {
        user.setPassword(passwordEncoder().encode(user.getPassword()));
        userRepository.save(user);
        return "redirect:/admin/users/list";
    }




    @GetMapping("/admin/users/list")
    public String showUsers(Model model) {
        Iterable<Users> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "/admin/users/list";
    }

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
