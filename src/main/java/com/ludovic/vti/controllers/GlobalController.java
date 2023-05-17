package com.ludovic.vti.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.ludovic.vti.repositories.RoleRepository;

@ControllerAdvice
public class GlobalController {

    @Autowired
    private RoleRepository roleRepository;

    @ModelAttribute("getConnectedName")
    public String getConnectedName() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }

    @ModelAttribute("getConnectedRole")
    public String getConnectedRole() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getAuthorities().toString();
    }

    @ModelAttribute("getInit")
    public String getInit() {
        if (roleRepository.findByLabel("user") == null) {
            return "0";
        } else {
            return "1";
        }
    }
}
