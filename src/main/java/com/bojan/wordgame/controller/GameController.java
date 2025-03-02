package com.bojan.wordgame.controller;

import com.bojan.wordgame.service.GameService;
import com.bojan.wordgame.utils.GameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GameController {

    @Autowired
    private GameService gameService;

    @Autowired
    private GameUtils gameUtils;

    @GetMapping("/game-home")
    public String showGameHomePage(@RequestParam(value = "guessedCharacter", required = false) String guessedCharacter, Model model) {

        String randomWord = gameService.toString();

        if (guessedCharacter != null) {
            boolean isGuessedCorrect = gameService.addGuess(guessedCharacter.charAt(0));
            randomWord = gameService.toString();
            if (!isGuessedCorrect) {
                gameUtils.reduceTry();
            }
        }

        model.addAttribute("wordToDisplay", randomWord);

        model.addAttribute("triesLeft", gameUtils.getTriesRemaining());

        return "game-home-page";

    }

    @GetMapping("/reload")
    public String reloadGame() {

        gameService = gameUtils.reload();

        gameUtils.resetTries();

        return "redirect:/game-home";

    }

}
