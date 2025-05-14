package com.github.tiagolofi.domain.engine;

import java.util.List;

import com.github.tiagolofi.adapters.Creature;
import com.github.tiagolofi.ports.Card;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Board {
    private Card location;
    private Player player1;
    private Player player2;
    private Burst burst;

    public void setBurst(Burst burst) {
        this.burst = burst;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Card getLocation() {
        return this.location;
    }

    public void setLocation(Card location) {
        this.location = location;
    }

    public void startBoard() {
        List<Card> cardsPlayer1 = player1.getDeck()
            .getCreatures();

        List<Card> cardsPlayer2 = player2.getDeck()
            .getCreatures();

        cardsPlayer1.forEach(card -> {
            Creature creature = (Creature) card;
            creature.getAbilities()
                .forEach(ability -> burst.addTrigger(ability));  
        });

        cardsPlayer2.forEach(card -> {
            Creature creature = (Creature) card;
            creature.getAbilities()
                .forEach(ability -> burst.addTrigger(ability));  
        });
    }

    public Player getPlayer(String who) {
        if ("player1".equalsIgnoreCase(who)) {
            return player1;
        } else if ("player2".equalsIgnoreCase(who)) {
            return player2;
        }
        throw new IllegalArgumentException("Invalid player: " + who);
    }

}
