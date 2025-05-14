package com.github.tiagolofi.adapters.targetable;

import com.github.tiagolofi.adapters.Creature;
import com.github.tiagolofi.ports.Card;
import com.github.tiagolofi.ports.Targetable;

public class Target implements Targetable {
    
    private String type;
    private String side;
    private Condition condition;

    public Target(Builder builder) {
        this.type = builder.type;
        this.side = builder.side;
        this.condition = builder.condition;
    }

    public static Builder builder() {
        return new Builder();
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

        if ("creature".equals(getType())) {
            Creature creature = (Creature) card;

            if (tribe(creature)) return true;
            if (subtype(creature)) return true;
            return elements(creature);
        }

        return false;
    }

    @Override
    public boolean isComparable(Card card1, Card card2) {
        Creature creature1 = (Creature) card1;
        Creature creature2 = (Creature) card2;
        return compare(creature1, creature2);
    }

    @Override 
    public boolean isComparable() {
        return this.condition.getOperator() == null;
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

    private boolean compare(Creature creature1, Creature creature2) {
        if (condition.getOperator() == null) return false;
        String discipline = condition.getDiscipline();
        switch (condition.getOperator()) {
            case ">=":
                return creature1.getStats().get(discipline) >= creature2.getStats().get(discipline);
            case "<":  
                return creature1.getStats().get(discipline) < creature2.getStats().get(discipline);
            case ">":  
                return creature1.getStats().get(discipline) < creature2.getStats().get(discipline);
            default: return false;
        }
    }

    public static class Builder {
        private String type;
        private String side;
        private Condition condition;

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder side(String side) {
            this.side = side;
            return this;
        }

        public Builder condition(Condition condition) {
            this.condition = condition;
            return this;
        }

        public Target build() {
            return new Target(this);
        }
    }

}
