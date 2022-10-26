package com.julian.spring.controllers;

import com.julian.spring.models.Role;
import com.julian.spring.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class RoleController {
    @Autowired
    private RoleRepository roleRepo;

    @GetMapping("/roles/")
    public String viewHomePage(Model model) {
        model.addAttribute("roles_list", roleRepo.findAll());
        return "roles/index";
    }

    @GetMapping("/roles/addnew")
    public String addNewRole(Model model) {
        Role role = new Role();
        model.addAttribute("role", role);
        return "roles/new";
    }

    @PostMapping("/roles/save")
    public String saveRole(@ModelAttribute("role") Role role) {
        roleRepo.save(role);
        return "redirect:/roles/";
    }

    @GetMapping("/roles/showFormForUpdate/{id}")
    public String updateForm(@PathVariable(value = "id") int id, Model model) {
        Optional<Role> optional = roleRepo.findById(id);
        Role role = null;
        if (optional.isPresent()) {
            role = optional.get();
            model.addAttribute("role", role);
        }
        else
            throw new RuntimeException(
                    "Role not found for id : " + id);
        return "roles/update";
    }

    @GetMapping("/roles/deleteUser/{id}")
    public String deleteThroughId(@PathVariable(value = "id") int id) {
        roleRepo.deleteById(id);
        return "redirect:/roles/";
    }
}
