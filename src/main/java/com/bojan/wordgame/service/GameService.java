package com.bojan.wordgame.service;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Random;

@Service
@Scope("prototype")
public class GameService {

    private String randomlyChosenWord = null;

    private String[] randomWords = {"father", "mother", "son", "daughter", "hello", "java", "mic", "light"};

    private char[] allCharactersOfRandomWord;

    Random rand = new Random();

    public GameService() {
        randomlyChosenWord = randomWords[rand.nextInt(randomWords.length)];
        allCharactersOfRandomWord = new char[randomlyChosenWord.length()];
    }

    @Override
    public String toString() {
        String ret = "";

        for (char c : allCharactersOfRandomWord) {
            if (c == '\u0000') {
                ret = ret + "_ ";
            }
            else {
                ret = ret + c;
            }
        }

        return ret;
    }

    public boolean addGuess(char guessedCharacter) {

        boolean isGuessedCorrect = false;

        for (int i = 0; i < randomlyChosenWord.length(); i++) {
            if (guessedCharacter == randomlyChosenWord.charAt(i)) {

                allCharactersOfRandomWord[i] = guessedCharacter;
                isGuessedCorrect = true;

            }
        }

        return isGuessedCorrect;

    }

}
