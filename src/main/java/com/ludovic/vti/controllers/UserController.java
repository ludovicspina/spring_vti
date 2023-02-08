package com.ludovic.vti.controllers;

import com.ludovic.vti.models.Users;
import com.ludovic.vti.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//import javax.validation.Valid;
import java.util.List;

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
        List<Users> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "/users/list";
    }

    /*@PostMapping("/users/add")
    public String handleFormSubmit(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/users/add";
        }
        userRepository.save(user);
        return "/users/confirm";
    }*/

}
