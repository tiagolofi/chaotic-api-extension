package com.github.tiagolofi.adapters.triggerable;

import com.github.tiagolofi.ports.Computable;
import com.github.tiagolofi.ports.Targetable;
import com.github.tiagolofi.ports.Triggerable;

public class Rule implements Triggerable {
    private String ruleDescription;
    private Targetable target;
    private Computable effect;

    public Rule(String ruleDescription, Targetable target, Computable effect) {
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

    public Targetable getTarget() {
        return this.target;
    }

    public void setTarget(Targetable target) {
        this.target = target;
    }

    public Computable getEffect() {
        return this.effect;
    }

    public void setEffect(Computable effect) {
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

}

