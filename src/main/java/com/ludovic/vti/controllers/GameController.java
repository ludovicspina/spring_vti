package com.ludovic.vti.controllers;

import com.ludovic.vti.models.Game;
import com.ludovic.vti.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

//import javax.validation.Valid;
import java.util.List;

@Controller
public class GameController {
    @Autowired
    private GameRepository gameRepository;

    @GetMapping("/games/add")
    public String showForm(Game game) {
        return "/games/add";
    }

    @GetMapping("/games/list")
    public String showGames(Model model) {
        List<Game> games = gameRepository.findAll();
        model.addAttribute("games", games);
        return "/games/list";
    }

  /*  @PostMapping("/games/add")
    public String handleFormSubmit(@Valid Game game, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/games/add";
        }
        gameRepository.save(game);
        return "/games/confirm";
    }*/
}
