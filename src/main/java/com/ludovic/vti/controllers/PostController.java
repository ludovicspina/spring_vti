package com.ludovic.vti.controllers;



import com.ludovic.vti.models.Game;
import com.ludovic.vti.models.Post;
import com.ludovic.vti.repositories.GameRepository;
import com.ludovic.vti.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PostController {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private GameRepository gameRepository;

    @GetMapping("/posts/list")
    public String showPosts(Model model) {
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "posts/list";
    }

    @GetMapping("/posts/add")
    public String addPost(Model model) {
        List<Game> games = gameRepository.findAll();
        model.addAttribute("post", new Post());
        model.addAttribute("games", games);
        return "/posts/add";
    }

    @PostMapping("/posts/add")
    public String addPost(@ModelAttribute Post post) {
        postRepository.save(post);
        return "redirect:/posts/list";
    }
}

