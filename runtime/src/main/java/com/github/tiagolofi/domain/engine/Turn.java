package com.github.tiagolofi.domain.engine;

import java.util.Arrays;

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

    private String getIniciative(String iniciative) {
        if (Arrays.asList("fire", "water", "earth", "air").contains(iniciative)) {
            return "elements";
        } else if (Arrays.asList("courage", "power", "wisdom", "speed").contains(iniciative)) {
            return "stats";
        }
        return null;
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

        String iniciative = location.getInitiative();
        String attributeType = getIniciative(iniciative);

        if ("elements".equals(attributeType)) {
            if (creaturePlayer1.getElements().contains(iniciative)) {
                engagedPlayer1.setHasInitiative(true);
            } else if (creaturePlayer2.getElements().contains(iniciative)) {
                engagedPlayer2.setHasInitiative(true);
            }
        } else if ("stats".equals(attributeType)) {
            if (creaturePlayer1.getStats().get(iniciative) > creaturePlayer2.getStats().get(iniciative)) {
                engagedPlayer1.setHasInitiative(true);
            } else if (creaturePlayer2.getStats().get(iniciative) > creaturePlayer1.getStats().get(iniciative)) {
                engagedPlayer2.setHasInitiative(true);
            }
        }
    }

    public void event() {
        if (engagedPlayer1.hasInitiative()) {
            board.getAttack("player1");
            engagedPlayer1.setHasInitiative(false);
        } else {
            board.getAttack("player2");
            engagedPlayer1.setHasInitiative(false);
        }
    }

}
