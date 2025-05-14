package com.github.tiagolofi.adapters.triggerable;

import com.github.tiagolofi.ports.Computable;
import com.github.tiagolofi.ports.Targetable;
import com.github.tiagolofi.ports.Triggerable;
import com.github.tiagolofi.ports.Valuable;

public class Rule implements Triggerable {
    private String ruleDescription;
    private Targetable target;
    private Valuable effect;

    public Rule(Builder builder) {
        this.ruleDescription = builder.ruleDescription;
        this.target = builder.target;
        this.effect = builder.effect;
    }

    public static Builder builder() {
        return new Builder();
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

    public static class Builder {
        private String ruleDescription;
        private Targetable target;
        private Valuable effect;

        public Builder ruleDescription(String ruleDescription) {
            this.ruleDescription = ruleDescription;
            return this;
        }

        public Builder target(Targetable target) {
            this.target = target;
            return this;
        }

        public Builder effect(Valuable effect) {
            this.effect = effect;
            return this;
        }

        public Rule build() {
            return new Rule(this);
        }
    }

    @Override
    public Valuable getValue() {
        return this.effect;
    }

}

