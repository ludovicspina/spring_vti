package com.ludovic.vti.controllers;

import com.ludovic.vti.models.Role;
import com.ludovic.vti.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.ludovic.vti.repositories.UserRepository;
import com.ludovic.vti.repositories.RoleRepository;

@Controller
public class InitController {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @GetMapping("/init")
    public String init() {
        return "redirect:/init/roles/1";
    }

    @GetMapping("/init/roles/1")
    public String initRole1(@ModelAttribute("role") Role role) {
        role.setLabel("admin");
        roleRepository.save(role);
        return "redirect:/init/roles/2";
    }

    @GetMapping("/init/roles/2")
    public String initRole2(@ModelAttribute("role") Role role) {
        role.setLabel("user");
        roleRepository.save(role);
        return "redirect:/init/users/1";
    }

    @GetMapping("/init/users/1")
    public String initUser1(@ModelAttribute("user") Users user) {
        user.setName("admin");
        user.setId(1L);
        user.setRole(roleRepository.findByLabel("admin"));
        user.setPassword(passwordEncoder().encode("password"));
        userRepository.save(user);
        return "redirect:/init/users/2";
    }

    @GetMapping("/init/users/2")
    public String initUser2(@ModelAttribute("user") Users user) {
        user.setName("user");
        user.setId(2L);
        user.setRole(roleRepository.findByLabel("user"));
        user.setPassword(passwordEncoder().encode("password"));
        userRepository.save(user);
        return "redirect:/";
    }

}
