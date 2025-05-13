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
import jakarta.inject.Inject;

@ApplicationScoped
public class Burst {
    private List<Triggerable> triggers = new ArrayList<>();

    @Inject
    Board board;

    public void addTrigger(Triggerable trigger) {
        this.triggers.add(trigger);
    }

    public void removeTrigger(Triggerable trigger) {
        this.triggers.remove(trigger);
    }

    public void clear() {
        this.triggers.clear();
    }

    public void applyTriggersCreatures(String who) {
        triggers
            .stream()
            .filter(Triggerable::isActive)
            .forEach(trigger -> {
                Target target = (Target) trigger.getTarget();
                Value value = (Value) trigger.getValue();

                processCreatures(who, target, value);
            });
    }

    private void processCreatures(String who, Target target, Value value) {
        List<Card> creatures = board.getPlayer(who).getDeck().getCreatures();

        creatures.forEach(creature -> {
            if (target.isApplicable(creature)) {
                Creature c = (Creature) creature;

                if ("discipline".equals(value.getAttributeType())) {
                    c.getStats().compute(value.getAttribute(), (int) value.getValue());
                } else if ("elements".equals(value.getAttributeType())) {
                    if ("+".equals(value.getValue().toString().substring(0, 1))) {
                        c.getElements().add((String) value.getValue());
                    } else {
                        c.getElements().remove(value.getValue());
                    }
                }

                processDamage(who, value);
            }
        });
    }

    private void processDamage(String who, Value value) {
        List<Card> attacks = board.getPlayer(who).getDeck().getAttacks();

        attacks.forEach(attack -> {
            Attack a = (Attack) attack;
            a.getDamage().compute(value.getAttribute(), (int) value.getValue());
        });
    }

}
