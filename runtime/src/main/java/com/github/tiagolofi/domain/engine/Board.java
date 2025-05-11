package com.github.tiagolofi.domain.engine;

import java.util.List;

import com.github.tiagolofi.adapters.Creature;
import com.github.tiagolofi.ports.Card;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class Board {
    private Card location;

    private static final String ABILITY_TYPE = "board";

    @Inject
    Match match;

    @Inject
    Burst burst;

    public Card getLocation() {
        return this.location;
    }

    public void setLocation(Card location) {
        this.location = location;
    }

    public void startBoard() {
        List<Card> cards = match.getPlayer1().getDeck()
            .getCreatures();

        cards.forEach(card -> {
            Creature creature = (Creature) card;
            creature.getAbilities()
                .stream()
                .filter(ability -> ABILITY_TYPE.equals(ability.getType()))
                .forEach(ability -> burst.addTrigger(ability));  
        });
    }
}
