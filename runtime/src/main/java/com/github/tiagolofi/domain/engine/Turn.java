package com.github.tiagolofi.domain.engine;

import com.github.tiagolofi.adapters.Creature;
import com.github.tiagolofi.adapters.Location;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class Turn {
    private Engaged engagedPlayer1;
    private Engaged engagedPlayer2;

    @Inject
    Burst burst;

    @Inject
    Board board;

    public Engaged getEngagedPlayer1() {
        return this.engagedPlayer1;
    }

    public void setEngagedPlayer1(Engaged engagedPlayer1) {
        this.engagedPlayer1 = engagedPlayer1;
    }

    public Engaged getEngagedPlayer2() {
        return this.engagedPlayer2;
    }

    public void setEngagedPlayer2(Engaged engagedPlayer2) {
        this.engagedPlayer2 = engagedPlayer2;
    }

    public void startTurn() {
        Location location = (Location) board.getLocation();
        Creature creaturePlayer1 = (Creature) engagedPlayer1.getCreature();
        Creature creaturePlayer2 = (Creature) engagedPlayer2.getCreature();

        location.getEffects()
            .forEach(effect -> burst.addTrigger(effect));

        creaturePlayer1.getAbilities()
            .forEach(ability -> burst.addTrigger(ability));

        creaturePlayer2.getAbilities()
            .forEach(ability -> burst.addTrigger(ability));
    }

}
