package com.ludovic.vti.controllers;



import com.ludovic.vti.models.Game;
import com.ludovic.vti.models.Post;
import com.ludovic.vti.models.Users;
import com.ludovic.vti.repositories.GameRepository;
import com.ludovic.vti.repositories.PostRepository;
import com.ludovic.vti.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PostController {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private UserRepository userRepository;


    @GetMapping("/admin/posts/list")
    public String showPosts(Model model) {
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "/admin/posts/list";
    }

    @GetMapping("/admin/posts/add")
    public String addPost(Model model) {
        List<Game> games = gameRepository.findAll();
        model.addAttribute("post", new Post());
        model.addAttribute("games", games);
        model.addAttribute("users", userRepository.findAll());
        return "/admin/posts/add";
    }

    @PostMapping("/admin/posts/add")
    public String addPost(@ModelAttribute Post post, @RequestParam("user.id") Long userId) {
        Users user = userRepository.findById(userId).orElse(null);
        post.setUser(user);
        postRepository.save(post);
        return "redirect:/admin/posts/list";
    }


    @GetMapping("/posts")
    public String showSitePosts(Model model) {
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        Iterable<Game> games = gameRepository.findAll();
        model.addAttribute("games", games);
        Iterable<Users> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "/site/posts";
    }

    @GetMapping("/posts/add")
    public String addSitePost(Model model) {
        List<Game> games = gameRepository.findAll();
        model.addAttribute("post", new Post());
        model.addAttribute("games", games);
        model.addAttribute("users", userRepository.findAll());
        return "/site/posts/add";
    }

    @PostMapping("/posts/add")
    public String addSitePost(@ModelAttribute Post post, @RequestParam("user.id") Long userId) {
        Users user = userRepository.findById(userId).orElse(null);
        post.setUser(user);
        postRepository.save(post);
        return "redirect:/posts";
    }


    @PostMapping("/admin/posts/delete")
    public String deletePost(@RequestParam("postId") Long postId) {
        postRepository.deleteById(postId);
        return "redirect:/admin/posts/list";
    }

    @PostMapping("/posts/delete")
    public String deleteMyPost(@RequestParam("postId") Long postId) {
        postRepository.deleteById(postId);
        return "redirect:/posts/offers";
    }


    @GetMapping("/posts/offers")
    public String listOfferPosts(Model model) {
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        Iterable<Game> games = gameRepository.findAll();
        model.addAttribute("games", games);
        Iterable<Users> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "/site/myPosts";
    }


    @PostMapping("/posts/makeOffer")
    public String makePostOffer(@RequestParam("postId") Long postId, @RequestParam("userId") Long userId) {
        Post post = postRepository.findById(postId).orElse(null);
        Users user = userRepository.findById(userId).orElse(null);
        if (post != null && user != null) {
            post.setBuyer(user);
            postRepository.save(post);
        }
        return "redirect:/posts";
    }


}

