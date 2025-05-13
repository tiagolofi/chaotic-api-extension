package com.github.tiagolofi.adapters.triggerable;

import com.github.tiagolofi.ports.Targetable;
import com.github.tiagolofi.ports.Triggerable;
import com.github.tiagolofi.ports.Valuable;

public class Ability implements Triggerable {
    private String name;
    private String type;
    private String description;
    private Targetable target;
    private Valuable value;

    public Ability(String name, String type, String description, Targetable target, Valuable value) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.target = target;
        this.value = value;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public String getDescription() {
        return this.description;
    }

    @Override
    public Targetable getTarget() {
        return this.target;
    }

    @Override
    public Valuable getValue() {
        return this.value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTarget(Targetable target) {
        this.target = target;
    }

    public void setValue(Valuable value) {
        this.value = value;
    }

    @Override
    public boolean isToggleable() {
        throw new UnsupportedOperationException("Unimplemented method 'isToggleable'");
    }

    @Override
    public boolean isActive() {
        throw new UnsupportedOperationException("Unimplemented method 'isActive'");
    }

}
