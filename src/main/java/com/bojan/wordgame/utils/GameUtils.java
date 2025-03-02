package com.bojan.wordgame.utils;

import com.bojan.wordgame.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class GameUtils {

    @Autowired
    ConfigurableApplicationContext applicationContext;

    private int max_tries = 5;

    public void reduceTry() {
        max_tries--;
    }

    public int getTriesRemaining() {
        return max_tries;
    }

    public void resetTries() {
        max_tries = 5;
    }

    public GameService reload() {

        GameService gameService = applicationContext.getBean(GameService.class);

        return gameService;

    }

}
