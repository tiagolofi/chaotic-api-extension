package com.github.tiagolofi.domain.engine;

import java.util.List;

import com.github.tiagolofi.adapters.Creature;
import com.github.tiagolofi.domain.objects.Player;
import com.github.tiagolofi.ports.Card;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class Board {
    private Card location;

    @Inject
    Player player1;

    @Inject
    Player player2;

    @Inject
    Burst burst;

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
