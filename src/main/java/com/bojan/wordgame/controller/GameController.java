package com.bojan.wordgame.controller;

import com.bojan.wordgame.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GameController {

    @Autowired
    GameService gameService;

    @GetMapping("/game-home")
    public String showGameHomePage(@RequestParam(value = "guessedCharacter", required = false) String guessedCharacter, Model model) {

        String randomWord = gameService.toString();

        if (guessedCharacter != null) {
            gameService.addGuess(guessedCharacter.charAt(0));
            randomWord = gameService.toString();
        }

        model.addAttribute("wordToDisplay", randomWord);

        return "game-home-page";

    }

}
