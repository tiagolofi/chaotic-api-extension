package com.github.tiagolofi.adapters;

import java.util.ArrayList;
import java.util.List;

import com.github.tiagolofi.adapters.computable.Damage;
import com.github.tiagolofi.adapters.triggerable.Rule;
import com.github.tiagolofi.ports.Card;

public class Attack implements Card {
    private String chaoticId;
    private String name;
    private int buildCost;
    private Damage damage;
    private List<Rule> rules;
    private byte[] image;

    private Attack(Builder builder) {
        this.chaoticId = builder.chaoticId;
        this.name = builder.name;
        this.buildCost = builder.buildCost;
        this.damage = builder.damage;
        this.rules = builder.rules;
        this.image = builder.image;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getChaoticId() {
        return this.chaoticId;
    }

    public String getName() {
        return this.name;
    }

    public int getBuildCost() {
        return this.buildCost;
    }

    public Damage getDamage() {
        return this.damage;
    }

    public List<Rule> getRules() {
        return this.rules;
    }

    public byte[] getImage() {
        return this.image;
    }

    public void setChaoticId(String chaoticId) {
        this.chaoticId = chaoticId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBuildCost(int buildCost) {
        this.buildCost = buildCost;
    }

    public void setDamage(Damage damage) {
        this.damage = damage;
    }

    public void setRules(List<Rule> rules) {
        this.rules = rules;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public static class Builder {
        private String chaoticId;
        private String name;
        private int buildCost;
        private Damage damage;
        private List<Rule> rules = new ArrayList<>();
        private byte[] image;

        public Builder chaoticId(String chaoticId) {
            this.chaoticId = chaoticId;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder buildCost(int buildCost) {
            this.buildCost = buildCost;
            return this;
        }

        public Builder damage(Damage damage) {
            this.damage = damage;
            return this;
        }

        public Builder rules(List<Rule> rules) {
            this.rules = rules;
            return this;
        }

        public Builder addRule(Rule rule) {
            this.rules.add(rule);
            return this;
        }

        public Builder image(byte[] image) {
            this.image = image;
            return this;
        }

        public Attack build() {
            return new Attack(this);
        }
    }
}
