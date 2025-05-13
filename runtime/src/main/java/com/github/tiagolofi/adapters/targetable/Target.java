package com.github.tiagolofi.adapters.targetable;

import java.util.List;

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
    public boolean satisfies(Card card) {
        if (this.condition == null) return false;

        if (!satisfiesTribe(card)) return false;
        if (!satisfiesSubtype(card)) return false;
        if (!satisfiesElements(card)) return false;
        return satisfiesDiscipline(card);
    }

    private boolean satisfiesTribe(Card card) {
        if (condition.getTribe() == null || condition.getTribe().isEmpty()) return true;
        try {
            List<String> cardTribes = (List<String>) card.getClass().getMethod("getTribe").invoke(card);
            return cardTribes != null && cardTribes.stream().anyMatch(condition.getTribe()::contains);
        } catch (Exception e) {
            return false;
        }
    }

    private boolean satisfiesSubtype(Card card) {
        if (condition.getSubtype() == null || condition.getSubtype().isEmpty()) return true;
        try {
            List<String> cardSubtypes = (List<String>) card.getClass().getMethod("getSubtype").invoke(card);
            return cardSubtypes != null && cardSubtypes.stream().anyMatch(condition.getSubtype()::contains);
        } catch (Exception e) {
            return false;
        }
    }

    private boolean satisfiesElements(Card card) {
        if (condition.getElements() == null || condition.getElements().isEmpty()) return true;
        try {
            List<String> cardElements = (List<String>) card.getClass().getMethod("getElements").invoke(card);
            return cardElements != null && cardElements.stream().anyMatch(condition.getElements()::contains);
        } catch (Exception e) {
            return false;
        }
    }

    private boolean satisfiesDiscipline(Card card) {
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
