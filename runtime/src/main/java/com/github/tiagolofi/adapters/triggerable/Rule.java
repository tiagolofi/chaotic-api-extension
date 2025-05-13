package com.github.tiagolofi.adapters.triggerable;

import com.github.tiagolofi.ports.Targetable;
import com.github.tiagolofi.ports.Triggerable;
import com.github.tiagolofi.ports.Valuable;

public class Rule implements Triggerable {
    private String ruleDescription;
    private Targetable target;
    private Valuable effect;

    public Rule(String ruleDescription, Targetable target, Valuable effect) {
        this.ruleDescription = ruleDescription;
        this.target = target;
        this.effect = effect;
    }

    public String getRuleDescription() {
        return this.ruleDescription;
    }

    public void setRuleDescription(String ruleDescription) {
        this.ruleDescription = ruleDescription;
    }

    public void setTarget(Targetable target) {
        this.target = target;
    }

    public Valuable getEffect() {
        return this.effect;
    }

    public void setEffect(Valuable effect) {
        this.effect = effect;
    }

    @Override
    public boolean isToggleable() {
        throw new UnsupportedOperationException("Unimplemented method 'isToggleable'");
    }

    @Override
    public boolean isActive() {
        throw new UnsupportedOperationException("Unimplemented method 'isActive'");
    }
    
    @Override
    public Targetable getTarget() {
        return this.target;
    }

    @Override
    public Valuable getValue() {
        return this.effect;
    }

}

