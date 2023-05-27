package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Player;
import com.example.demo.service.PlayerService;

@Controller
@RequestMapping("/players")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @GetMapping
    public String index(Model model) {
        List<Player> players = playerService.findAll();
        model.addAttribute("players", players); 
        return "index"; 
    }

    @GetMapping("new")
    public String newPlayer(Model model) {
        Player player = new Player();
        model.addAttribute("player", player);
        return "new";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable Long id, Model model) { 
    	Player player = playerService.findOne(id);
        model.addAttribute("player", player);
        return "edit";
    }

    @GetMapping("{id}")
    public String show(@PathVariable Long id, Model model) {
    	Player player = playerService.findOne(id);
        model.addAttribute("player", player);
        return "show";
    }

    @PostMapping
    public String create(@Validated @ModelAttribute Player player, BindingResult bindingResult) { 
        if(bindingResult.hasErrors()) return "new"; 
        playerService.save(player);
        return "redirect:/players";
    }

    @PutMapping("{id}/edit")
    public String update(@PathVariable Long id, @Validated @ModelAttribute Player player, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) return "edit";
        player.setId(id);
        playerService.save(player);
        return "redirect:/players";
    }

    @DeleteMapping("{id}")
    public String destroy(@PathVariable Long id) {
        playerService.delete(id);
        return "redirect:/players";
    }
}