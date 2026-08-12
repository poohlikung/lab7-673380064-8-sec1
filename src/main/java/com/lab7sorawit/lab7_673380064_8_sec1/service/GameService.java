package com.lab7sorawit.lab7_673380064_8_sec1.service;

import com.lab7sorawit.lab7_673380064_8_sec1.model.Game;
import com.lab7sorawit.lab7_673380064_8_sec1.repository.GameRepository;
import com.lab7sorawit.lab7_673380064_8_sec1.strategy.DiscountContext;
import com.lab7sorawit.lab7_673380064_8_sec1.strategy.DiscountStrategy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    private final GameRepository gameRepository;
    private final DiscountContext discountContext;

    public GameService(GameRepository gameRepository, DiscountContext discountContext) {
        this.gameRepository = gameRepository;
        this.discountContext = discountContext;
    }

    public List<Game> getAllGames() {
        List<Game> games = gameRepository.findAll();
        games.forEach(this::calculatePrice);
        return games;
    }

    public Game getGameById(Long id) {
        Game game = gameRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ไม่พบเกมรหัส: " + id));

        calculatePrice(game);
        return game;
    }

    public Game saveGame(Game game) {
        return gameRepository.save(game);
    }

    public void deleteGame(Long id) {
        gameRepository.deleteById(id);
    }

    private void calculatePrice(Game game) {
        double price = game.getPrice() == null ? 0.0 : game.getPrice();

        DiscountStrategy strategy = discountContext.getStrategy(game.getDiscountType());

        game.setFinalPrice(strategy.calculateFinalPrice(price));
        game.setDiscountName(strategy.getDiscountName());
    }
}