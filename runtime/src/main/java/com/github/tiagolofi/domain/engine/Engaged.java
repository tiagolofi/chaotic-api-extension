package com.github.tiagolofi.domain.engine;

import com.github.tiagolofi.adapters.Battlegear;
import com.github.tiagolofi.adapters.Creature;

public class Engaged {
    private Creature creature;
    private Battlegear battlegear;
    private boolean hasInitiative;
    private boolean isAlive;
    private boolean isBattlegearActive;

    public Engaged(Creature creature, Battlegear battlegear) {
        this.creature = creature;
        this.battlegear = battlegear;
        this.hasInitiative = false;
        this.isAlive = true;
        this.isBattlegearActive = false;
    }

    public Creature getCreature() {
        return this.creature;
    }

    public void setCreature(Creature creature) {
        this.creature = creature;
    }

    public Battlegear getBattlegear() {
        return this.battlegear;
    }

    public void setBattlegear(Battlegear battlegear) {
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
