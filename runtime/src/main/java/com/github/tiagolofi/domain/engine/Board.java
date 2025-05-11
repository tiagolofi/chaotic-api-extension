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

    private static final String ABILITY_TYPE = "board";

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
        List<Card> cards = player1.getDeck()
            .getCreatures();

        cards.forEach(card -> {
            Creature creature = (Creature) card;
            creature.getAbilities()
                .stream()
                .filter(ability -> ABILITY_TYPE.equals(ability.getType()))
                .forEach(ability -> burst.addTrigger(ability));  
        });
    }

    private Player getPlayer(String who) {
        if ("player1".equalsIgnoreCase(who)) {
            return player1;
        } else if ("player2".equalsIgnoreCase(who)) {
            return player2;
        }
        return new Player();
    }

    public Card getAttack(String who) {
        Player player = getPlayer(who);
        Card attackCard = player.getDeck().getAttack(0);
        player.getDeck().removeAttack(attackCard);
        player.getDiscardPile().addAttack(attackCard);
        return attackCard;
    }


}
