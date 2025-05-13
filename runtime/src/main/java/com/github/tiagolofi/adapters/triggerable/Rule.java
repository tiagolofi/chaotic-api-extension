package com.github.tiagolofi.adapters.triggerable;

import com.github.tiagolofi.adapters.computable.Value;
import com.github.tiagolofi.ports.Targetable;
import com.github.tiagolofi.ports.Triggerable;

public class Rule implements Triggerable {
    private String ruleDescription;
    private Targetable target;
    private Value effect;

    public Rule(String ruleDescription, Targetable target, Value effect) {
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

    public Value getEffect() {
        return this.effect;
    }

    public void setEffect(Value effect) {
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
    public Value getValue() {
        return this.effect;
    }

}

