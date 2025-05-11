package br.com.github.tiagolofi.adapters;

import java.lang.annotation.Target;

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
    
    public Target getTarget() {
        return this.target;
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
}

