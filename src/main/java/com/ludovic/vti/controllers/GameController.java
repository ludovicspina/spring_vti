package com.ludovic.vti.controllers;

import com.ludovic.vti.models.Game;
import com.ludovic.vti.models.Users;
import com.ludovic.vti.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

//import javax.validation.Valid;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Controller
public class GameController {
    @Autowired
    private GameRepository gameRepository;

    @GetMapping("/admin/games/add")
    public String showForm(Game game) {
        return "/admin/games/add";
    }

    @GetMapping("/admin/games/list")
    public String showGames(Model model) {
        List<Game> games = gameRepository.findAll();
        model.addAttribute("games", games);
        return "/admin/games/list";
    }

    // PostMapping qui supprime un jeu
    @PostMapping("/admin/games/delete/{id}")
    public String deleteGame(@PathVariable("id") long id, Model model) {
        Game game = gameRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid game Id:" + id));
        gameRepository.delete(game);
        model.addAttribute("games", gameRepository.findAll());
        return "/admin/games/list";
    }

    @PostMapping("/admin/games/add")
    public String saveGame(@ModelAttribute("game") Game game) throws IOException {

        game.setName(game.getName());
        game.setDescription(game.getDescription());
        game.setMonnaie(game.getMonnaie());

        gameRepository.save(game);

        return "redirect:/admin/games/list";
    }

}
