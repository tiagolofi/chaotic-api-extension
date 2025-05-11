package com.github.tiagolofi.adapters;

import java.util.List;

import com.github.tiagolofi.adapters.triggerable.Rule;
import com.github.tiagolofi.ports.Card;

public class Attack implements Card {
    private String chaoticId;
    private String name;
    private int buildCost;
    private Damage damage;
    private List<Rule> rules;
    private byte[] image;

    public Attack(String chaoticId, String name, int buildCost, Damage damage, List<Rule> rules, byte[] image) {
        this.chaoticId = chaoticId;
        this.name = name;
        this.buildCost = buildCost;
        this.damage = damage;
        this.rules = rules;
        this.image = image;
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
}
