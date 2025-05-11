package com.github.tiagolofi.adapters;

import com.github.tiagolofi.ports.Computable;
import com.github.tiagolofi.ports.Effect;
import com.github.tiagolofi.ports.Target;

public class Ability implements Effect {
    private String name;
    private String type;
    private String description;
    private Target target;
    private Computable effect;

    public Ability(String name, String type, String description, Target target, Computable effect) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.target = target;
        this.effect = effect;
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

    public Target getTarget() {
        return this.target;
    }

    public Computable getEffect() {
        return this.effect;
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

    public void setEffect(Computable effect) {
        this.effect = effect;
    }

    @Override
    public Computable getComputable() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getComputable'");
    }

    @Override
    public boolean isToggleable() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isToggleable'");
    }

    @Override
    public boolean isActive() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isActive'");
    }

}
