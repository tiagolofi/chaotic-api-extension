package com.github.tiagolofi.domain.engine;

import com.github.tiagolofi.ports.Card;

public class Engaged {
    private Card creature;
    private Card battlegear;
    private boolean hasInitiative;
    private boolean isAlive;
    private boolean isBattlegearActive;

    public Engaged(Card creature, Card battlegear) {
        this.creature = creature;
        this.battlegear = battlegear;
        this.hasInitiative = false;
        this.isAlive = true;
        this.isBattlegearActive = false;
    }

    public Card getCreature() {
        return this.creature;
    }

    public void setCreature(Card creature) {
        this.creature = creature;
    }

    public Card getBattlegear() {
        return this.battlegear;
    }

    public void setBattlegear(Card battlegear) {
        this.battlegear = battlegear;
    }

    public boolean hasInitiative() {
        return this.hasInitiative;
    }

    public void setHasInitiative(boolean hasInitiative) {
        this.hasInitiative = hasInitiative;
    }

    public boolean isAlive() {
        return this.isAlive;
    }

    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public boolean isBattlegearActive() {
        return this.isBattlegearActive;
    }

    public void setBattlegearActive(boolean isBattlegearActive) {
        this.isBattlegearActive = isBattlegearActive;
    }
}
