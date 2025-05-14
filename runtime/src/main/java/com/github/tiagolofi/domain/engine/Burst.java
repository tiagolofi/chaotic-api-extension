package com.github.tiagolofi.domain.engine;

import java.util.ArrayList;
import java.util.List;

import com.github.tiagolofi.adapters.Attack;
import com.github.tiagolofi.adapters.Creature;
import com.github.tiagolofi.adapters.targetable.Target;
import com.github.tiagolofi.adapters.valuable.Value;
import com.github.tiagolofi.ports.Card;
import com.github.tiagolofi.ports.Triggerable;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Burst {
    private List<Triggerable> triggers = new ArrayList<>();
    private Board board;

    public void setBoard(Board board) {
        this.board = board;
    }

    public void addTrigger(Triggerable trigger) {
        this.triggers.add(trigger);
    }

    public void removeTrigger(Triggerable trigger) {
        this.triggers.remove(trigger);
    }

    public void clear() {
        this.triggers.clear();
    }

    public void applyTriggers(String self, String enemy) {
        triggers
            .stream()
            .filter(trigger -> !trigger.isToggleable())
            .forEach(trigger -> {
                Target target = (Target) trigger.getTarget();
                Value value = (Value) trigger.getValue();

                processCreatures(self, enemy, target, value);
            });
    }

    private void processCreatures(String self, String enemy, Target target, Value value) {
        List<Card> creaturesSelf = this.board.getPlayer(self).getDeck().getCreatures(); 
        List<Card> creaturesEnemy = this.board.getPlayer(enemy).getDeck().getCreatures(); 

        if ("both".equals(target.getSide())) {
            creaturesSelf.forEach(creature -> {
                if (target.isApplicable(creature)) {
                    processCreature((Creature) creature, value);
                    processDamage(self, value);
                }  
            });
            creaturesEnemy.forEach(creature -> {
                if (target.isApplicable(creature)) {
                    processCreature((Creature) creature, value);
                    processDamage(self, value);
                }
            });
        } else if ("self".equals(target.getSide())) {
            creaturesSelf.forEach(creature -> {
                if (target.isApplicable(creature)) {
                    processCreature((Creature) creature, value);
                    processDamage(self, value);
                }  
            });
        } else if ("enemy".equals(target.getSide())) {
            creaturesEnemy.forEach(creature -> {
                if (target.isApplicable(creature)) {
                    processCreature((Creature) creature, value);
                    processDamage(enemy, value);
                }
            });
        }
    }

    private void processCreature(Creature creature, Value value) {
        if ("discipline".equals(value.getAttributeType())) {
                creature.getStats().compute(value.getAttribute(), (int) value.getValue());
        } else if ("elements".equals(value.getAttributeType())) {
            if ("+".equals(value.getValue().toString().substring(0, 1))) {
                    creature.getElements().add((String) value.getValue());
            } else {
                    creature.getElements().remove(value.getValue());
            }
        }
    }

    private void processDamage(String who, Value value) {
        List<Card> attacks = board.getPlayer(who).getDeck().getAttacks();

        attacks.forEach(attack -> {
            Attack a = (Attack) attack;
            a.getDamage().compute(value.getAttribute(), (int) value.getValue());
        });
    }

    @Override
    public String toString() {
        return "Burst{" +
                "triggers=" + triggers +
                ", board=" + board +
                '}';
    }

}
