package com.lab7sorawit.lab7_673380064_8_sec1.controller;

import com.lab7sorawit.lab7_673380064_8_sec1.model.Game;
import com.lab7sorawit.lab7_673380064_8_sec1.service.GameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/games")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public String listGames(
            @RequestParam(required = false) String message,
            Model model) {
        model.addAttribute("games", gameService.getAllGames());
        model.addAttribute("message", message);
        return "games/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("game", new Game());
        return "games/add";
    }

    @PostMapping("/save")
    public String saveGame(@ModelAttribute Game game) {
        gameService.saveGame(game);
        return "redirect:/games?message=เพิ่มข้อมูลเกมสำเร็จ";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("game", gameService.getGameById(id));
        return "games/edit";
    }

    @PostMapping("/update/{id}")
    public String updateGame(@PathVariable Long id, @ModelAttribute Game game) {
        game.setId(id);
        gameService.saveGame(game);
        return "redirect:/games?message=แก้ไขข้อมูลเกมสำเร็จ";
    }

    @GetMapping("/delete/{id}")
    public String showDeleteForm(@PathVariable Long id, Model model) {
        model.addAttribute("game", gameService.getGameById(id));
        return "games/delete";
    }

    @PostMapping("/delete/{id}")
    public String deleteGame(@PathVariable Long id) {
        gameService.deleteGame(id);
        return "redirect:/games?message=ลบข้อมูลเกมสำเร็จ";
    }
}