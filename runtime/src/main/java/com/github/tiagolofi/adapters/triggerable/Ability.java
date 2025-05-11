package com.github.tiagolofi.adapters.triggerable;

import com.github.tiagolofi.adapters.targetable.Target;
import com.github.tiagolofi.ports.Computable;
import com.github.tiagolofi.ports.Targetable;
import com.github.tiagolofi.ports.Triggerable;

public class Ability implements Triggerable {
    private String name;
    private String type;
    private String description;
    private Targetable target;
    private Computable value;

    public Ability(String name, String type, String description, Targetable target, Computable value) {
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

    public Targetable getTarget() {
        return this.target;
    }

    public Computable getValue() {
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

    public void setTarget(Target target) {
        this.target = target;
    }

    public void setValue(Computable value) {
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
