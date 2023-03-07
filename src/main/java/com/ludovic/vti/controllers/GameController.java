package com.ludovic.vti.controllers;

import com.ludovic.vti.models.Game;
import com.ludovic.vti.models.Users;
import com.ludovic.vti.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

    @PostMapping("/games/add")
    public String saveGame(@ModelAttribute("game") Game game) {
        gameRepository.save(game);
        return "redirect:/games/list";
    }


//     @PostMapping("/games/edit/{id}")
//    public String updateGame(@ModelAttribute("game") Game game, @PathVariable("id") Integer id) {
//        game.setId(id);
//        gameRepository.save(game);
//        return "redirect:/games/list";
//    }
//
//    @GetMapping("/games/edit/{id}")
//    public String showEditForm(@PathVariable("id") Integer id, Model model) {
//        Game game = gameRepository.findById(Long.valueOf(id))
//                .orElseThrow(() -> new IllegalArgumentException("Invalid game Id:" + id));
//        model.addAttribute("game", game);
//        return "/games/edit";
//    }

}
