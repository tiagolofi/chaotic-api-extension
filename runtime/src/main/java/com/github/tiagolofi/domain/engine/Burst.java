package com.github.tiagolofi.domain.engine;

import java.util.ArrayList;
import java.util.List;

import com.github.tiagolofi.adapters.Attack;
import com.github.tiagolofi.adapters.Creature;
import com.github.tiagolofi.adapters.computable.Value;
import com.github.tiagolofi.adapters.targetable.Target;
import com.github.tiagolofi.domain.objects.Player;
import com.github.tiagolofi.ports.Card;
import com.github.tiagolofi.ports.Targetable;
import com.github.tiagolofi.ports.Triggerable;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class Burst {
    private List<Triggerable> triggers = new ArrayList<>();

    @Inject
    Player player1;

    @Inject
    Player player2;

    public void addTrigger(Triggerable trigger) {
        this.triggers.add(trigger);
    }

    public Triggerable getTrigger(int index) {
        return this.triggers.get(index);
    }

    public void removeTrigger(Triggerable trigger) {
        this.triggers.remove(trigger);
    }

    public void clear() {
        this.triggers.clear();
    }

    public void applyTriggers() {
        triggers
            .stream()
            .filter(Triggerable::isActive)
            .forEach(trigger -> {
                Target target = (Target) trigger.getTarget();
                Value value = trigger.getValue();

                List<Card> creatures = player1.getDeck().getCreatures();

                creatures
                    .forEach(creature -> {
                        if (target.satisfies(creature)) {

                            Creature c = (Creature) creature;

                            if ("discipline".equals(value.getAttributeType())) {
                                c.getStats().compute(value.getAttribute(), value.getIntValue());
                            } else if ("elements".equals(value.getAttributeType())) {
                                if ("add".equals(value.getOperator())) {
                                    c.getElements().add(value.getStrValue());
                                } else if ("remove".equals(value.getOperator())) {
                                    c.getElements().remove(value.getStrValue());
                                }
                            }
                        }
                    });
                
                List<Card> attacks = player1.getDeck().getAttacks();

                attacks
                    .forEach(attack -> {
                        if (target.satisfies(attack)) {
                            Attack a = (Attack) attack;
                            a.getDamage().compute(value.getAttribute(), value.getIntValue());
                        }
                    });

            });
    }

}
