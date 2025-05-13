package com.github.tiagolofi.adapters.targetable;

import com.github.tiagolofi.adapters.Creature;
import com.github.tiagolofi.ports.Card;
import com.github.tiagolofi.ports.Targetable;

public class Target implements Targetable {
    
    private String type;
    private String side;
    private Condition condition;

    public Target(String type, String side) {
        this.type = type;
        this.side = side;
    }

    public String getType() {
        return this.type;
    }

    public String getSide() {
        return this.side;
    }

    public Condition getCondition() {
        return this.condition;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }


    @Override
    public boolean isApplicable(Card card) {
        if (this.condition == null) return false;

        Creature creature = (Creature) card;

        if (tribe(creature)) return true;
        if (subtype(creature)) return true;
        return elements(creature);

    }

    private boolean tribe(Creature card) {
        if (condition.getTribe() == null || condition.getTribe().isEmpty()) return false;
        return condition.getTribe().contains(card.getTribe());
    }

    private boolean subtype(Creature card) {
        if (condition.getSubtype() == null || condition.getSubtype().isEmpty()) return false;
        return card.getSubtype()
            .stream()
            .map(subtype -> condition.getSubtype().contains(subtype))
            .findFirst()
            .orElse(false);
    }

    private boolean elements(Creature card) {
        if (condition.getElements() == null || condition.getElements().isEmpty()) return false;
        return card.getElements()
            .stream()
            .map(element -> condition.getElements().contains(element))
            .findFirst()
            .orElse(false);
    }

    private boolean compare(Creature card) {
        if (condition.getDiscipline() == null || condition.getOperator() == null) return true;
        try {
            Object stats = card.getClass().getMethod("getStats").invoke(card);
            int statValue = (int) stats.getClass().getMethod("get", String.class).invoke(stats, condition.getDiscipline());
            int condValue = condition.getIntValue();
            switch (condition.getOperator()) {
                case ">=": return statValue >= condValue;
                case "<":  return statValue < condValue;
                case ">":  return statValue > condValue;
                default: return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

}
