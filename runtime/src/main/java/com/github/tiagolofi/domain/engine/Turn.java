package com.github.tiagolofi.domain.engine;

import java.util.Arrays;
import java.util.List;

import com.github.tiagolofi.adapters.Attack;
import com.github.tiagolofi.adapters.Creature;
import com.github.tiagolofi.adapters.Location;
import com.github.tiagolofi.adapters.Mugic;
import com.github.tiagolofi.adapters.targetable.Target;
import com.github.tiagolofi.adapters.valuable.Value;
import com.github.tiagolofi.ports.Card;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Turn {
    private Engaged engagedPlayer1;
    private Engaged engagedPlayer2;
    private Burst burst;
    private Board board;

    public void setBurst(Burst burst) {
        this.burst = burst;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

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
            computeAttack(engagedPlayer1, engagedPlayer2);
            engagedPlayer1.setHasInitiative(false);
            engagedPlayer2.setHasInitiative(true);
        } else {
            Player player = board.getPlayer("player2");
            player.attack();
            computeAttack(engagedPlayer2, engagedPlayer1);
            engagedPlayer2.setHasInitiative(false);
            engagedPlayer1.setHasInitiative(true);
        }
    }

    public void eventMugic(int index) {
        if (engagedPlayer1.hasInitiative()) {
            Player player = board.getPlayer("player1");
            player.useMugic(index);
            computeMugic(engagedPlayer1, engagedPlayer2);
            engagedPlayer1.setHasInitiative(false);
            engagedPlayer2.setHasInitiative(true);
        } else {
            Player player = board.getPlayer("player2");
            player.useMugic(index);
            computeMugic(engagedPlayer2, engagedPlayer1);
            engagedPlayer2.setHasInitiative(false);
            engagedPlayer1.setHasInitiative(true);
        }
    }

    public void eventBattlegear() {
        if (engagedPlayer1.hasInitiative()) {
            engagedPlayer1.setBattlegearActive(true);
            computeBattlegear(engagedPlayer1, engagedPlayer2);
        } else if (engagedPlayer2.hasInitiative()) {
            engagedPlayer2.setBattlegearActive(true);
        }
    }

    private void computeBattlegear(Engaged self, Engaged enemy) {
        self.getBattlegear().getEffects()
                .forEach(effect -> {
                    Target target = (Target) effect.getTarget();
                    Value value = (Value) effect.getValue();
                    if ("enemy".equals(target.getSide())) {
                        processBattlegear(enemy, value);
                    } else if ("self".equals(target.getSide())) {
                        processBattlegear(self, value);
                    } else if ("both".equals(target.getSide())) {
                        processBattlegear(self, value);
                        processBattlegear(enemy, value);
                    }
                });
    }

    private void processBattlegear(Engaged engaged, Value value) {
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

    private void computeMugic(Engaged self, Engaged enemy) {
        Card card = self.getPlayer().getStrikes().getStrike();
        Mugic mugic = (Mugic) card;

        List<Card> selfCreatures = self.getPlayer().getDeck().getCreatures();
        List<Card> enemyCreatures = enemy.getPlayer().getDeck().getCreatures();

        mugic.getEffects()
                .stream()
                .forEach(effect -> {
                    Target target = (Target) effect.getTarget();
                    Value value = (Value) effect.getValue();
                    if ("enemy".equals(target.getSide())) {
                        processMugic(enemy, value);
                    } else if ("self".equals(target.getSide())) {
                        processMugic(self, value);
                    } else if ("both".equals(target.getSide())) {
                        processMugic(self, value);
                        processMugic(enemy, value);
                    } else if ("yours".equals(target.getSide())) {
                        selfCreatures.forEach(creature -> {
                            processMugicAll((Creature) creature, value);
                        });
                    } else if ("theirs".equals(target.getSide())) {
                        enemyCreatures.forEach(creature -> {
                            processMugicAll((Creature) creature, value);
                        });
                    }
                });

        if (!enemy.isAlive()) {
            self.getPlayer().setWinner(true);
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

    private void processMugicAll(Creature creature, Value value) {
        if ("discipline".equals(value.getAttributeType())) {
            creature.getStats().addStat(value.getAttribute(), (int) value.getValue());
        } else if ("elements".equals(value.getAttributeType())) {
            if ("+".equals(value.getValue().toString().substring(0, 1))) {
                creature.getElements().add((String) value.getValue());
            } else {
                creature.getElements().remove(value.getValue());
            }
        }
    }

    private void computeAttack(Engaged self, Engaged enemy) {
        Card card = self.getPlayer().getStrikes().getStrike();
        Attack attack = (Attack) card;

        enemy.getCreature().getStats().removeEnergy(attack.getDamage().getBasic());

        attack.getRules()
                .stream()
                .forEach(rule -> {
                    Value value = (Value) rule.getValue();
                    if (rule.getTarget().isComparable() && rule.getTarget().isComparable(self.getCreature(), enemy.getCreature())) {
                        enemy.getCreature().getStats().removeEnergy((int) value.getValue());
                    } else {
                        enemy.getCreature().getStats().removeEnergy((int) value.getValue());
                        // TODO: Implement the rest of the stats
                    }
                });

        if (!enemy.isAlive()) {
            self.getPlayer().setWinner(true);
        }
    }

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
