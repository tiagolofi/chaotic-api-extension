package com.github.tiagolofi.domain.engine;

import java.util.Arrays;

import com.github.tiagolofi.adapters.Attack;
import com.github.tiagolofi.adapters.Creature;
import com.github.tiagolofi.adapters.Location;
import com.github.tiagolofi.adapters.Mugic;
import com.github.tiagolofi.adapters.targetable.Target;
import com.github.tiagolofi.adapters.valuable.Value;
import com.github.tiagolofi.ports.Card;

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
        Creature creaturePlayer1 = engagedPlayer1.getCreature();
        Creature creaturePlayer2 = engagedPlayer2.getCreature();

        location.getEffects()
                .forEach(effect -> burst.addTrigger(effect));

        creaturePlayer1.getAbilities()
                .forEach(ability -> burst.addTrigger(ability));

        creaturePlayer2.getAbilities()
                .forEach(ability -> burst.addTrigger(ability));

        burst.applyTriggers("player1", "player2");
        burst.applyTriggers("player2", "player1");

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

    public void eventAttack() {
        if (engagedPlayer1.hasInitiative()) {
            Player player = board.getPlayer("player1");
            player.attack();
            computeAttack(player, engagedPlayer1, engagedPlayer2);
            engagedPlayer1.setHasInitiative(false);
            engagedPlayer2.setHasInitiative(true);
        } else {
            Player player = board.getPlayer("player2");
            player.attack();
            computeAttack(player, engagedPlayer2, engagedPlayer1);
            engagedPlayer2.setHasInitiative(false);
            engagedPlayer1.setHasInitiative(true);
        }
    }

    public void mugicEvent(int index) {
        if (engagedPlayer1.hasInitiative()) {
            Player player = board.getPlayer("player1");
            player.useMugic(index);
            computeMugic(player, engagedPlayer1, engagedPlayer2);
            engagedPlayer1.setHasInitiative(false);
            engagedPlayer2.setHasInitiative(true);
        } else {
            Player player = board.getPlayer("player2");
            player.useMugic(index);
            computeMugic(player, engagedPlayer2, engagedPlayer1);
            engagedPlayer2.setHasInitiative(false);
            engagedPlayer1.setHasInitiative(true);
        }
    }

    private void computeMugic(Player player, Engaged self, Engaged enemy) {
        Card card = player.getStrikes().getStrike();
        Mugic mugic = (Mugic) card;

        mugic.getEffects()
                .stream()
                .forEach(effect -> {
                    Target target = (Target) effect.getTarget();
                    Value value = (Value) effect.getValue();
                    if ("enemy".equals(target.getSide())) { // TODO: process to yours and theis
                        processMugic(enemy, value);
                    } else if ("self".equals(target.getSide())) {
                       processMugic(self, value);
                    } else if ("both".equals(target.getSide())) {
                        processMugic(self, value);
                        processMugic(enemy, value);
                    }
                });

        if (!enemy.isAlive()) {
            player.setWinner(true);
        }
    }

    private void processMugic(Engaged engaged, Value value) {
        if ("discipline".equals(value.getAttributeType())) {
            engaged.getCreature().getStats().addStat(value.getAttribute(), (int) value.getValue());
        } else if ("elements".equals(value.getAttributeType())) {
            if ("+".equals(value.getValue().toString().substring(0, 1))) {
                engaged.getCreature().getElements().add((String) value.getValue());
            } else {
                engaged.getCreature().getElements().remove(value.getValue());
            }
        }
    }

    private void computeAttack(Player player, Engaged self, Engaged enemy) {
        Card card = player.getStrikes().getStrike();
        Attack attack = (Attack) card;

        enemy.getCreature().getStats().setEnergy(attack.getDamage().getBasic());

        attack.getRules()
                .stream() // TODO: check if rule not is comparation
                .filter(rule -> rule.getTarget().isApplicable(self.getCreature(), enemy.getCreature()))
                .forEach(rule -> {
                    Value value = (Value) rule.getValue();
                    enemy.getCreature().getStats().setEnergy((int) value.getValue());
                });

        if (!enemy.isAlive()) {
            player.setWinner(true);
        }
    }

    // TODO: computeMugic and computeBattlegear

    public void closeTurn(Player player1, Player player2) {
        if (player1.isWinner()) {
            player2.getDeck().removeCreature(engagedPlayer2.getCreature());
        } else if (player2.isWinner()) {
            player1.getDeck().removeCreature(engagedPlayer1.getCreature());
        }

        burst.clear();
        board.setLocation(null);
        player1.getDiscardPile().clear();
        player1.getStrikes().clear();
        player2.getDiscardPile().clear();
        player2.getStrikes().clear();
    }

}
