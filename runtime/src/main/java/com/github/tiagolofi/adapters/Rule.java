package com.github.tiagolofi.adapters;

import com.github.tiagolofi.ports.Computable;
import com.github.tiagolofi.ports.Effect;
import com.github.tiagolofi.ports.Target;

public class Rule implements Effect {
    private String ruleDescription;
    private Target target;
    private Computable effect;

    public Rule(String ruleDescription, Target target, Computable effect) {
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

    public void setTarget(Target target) {
        this.target = target;
    }

    public Computable getEffect() {
        return this.effect;
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

    @Override
    public Target getTarget() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTarget'");
    }
}

