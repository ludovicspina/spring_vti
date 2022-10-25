package com.julian.spring.controllers;

import com.julian.spring.models.User;
import com.julian.spring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.yaml.snakeyaml.events.Event;

import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepo;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("users_list", userRepo.findAll());
        return "index";
    }

    @GetMapping("/addnew")
    public String addNewUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "newuser";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user) {
        userRepo.save(user);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String updateForm(@PathVariable(value = "id") int id, Model model) {
        Optional<User> optional = userRepo.findById(id);
        User user = null;
        if (optional.isPresent()) {
            user = optional.get();
            model.addAttribute("user", user);
        }
        else
            throw new RuntimeException(
                    "User not found for id : " + id);
        return "update";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteThroughId(@PathVariable(value = "id") int id) {
        userRepo.deleteById(id);
        return "redirect:/";
    }
}
