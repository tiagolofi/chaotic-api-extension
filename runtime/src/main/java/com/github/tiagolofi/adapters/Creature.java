package com.github.tiagolofi.adapters;

import java.util.List;

import com.github.tiagolofi.ports.Card;

public class Creature implements Card {
    private String chaoticId;
    private String name;
    private String tribe;
    private List<String> subtype;
    private Stats stats;
    private List<Ability> abilities;
    private byte[] image;

    public Creature(String chaoticId, String name, String tribe, List<String> subtype, Stats stats, List<Ability> abilities, byte[] image) {
        this.chaoticId = chaoticId;
        this.name = name;
        this.tribe = tribe;
        this.subtype = subtype;
        this.stats = stats;
        this.abilities = abilities;
        this.image = image;
    }

    public String getChaoticId() {
        return this.chaoticId;
    }

    public String getName() {
        return this.name;
    }

    public String getTribe() {
        return this.tribe;
    }

    public List<String> getSubtype() {
        return this.subtype;
    }

    public Stats getStats() {
        return this.stats;
    }

    public List<Ability> getAbilities() {
        return this.abilities;
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

    public void setTribe(String tribe) {
        this.tribe = tribe;
    }

    public void setSubtype(List<String> subtype) {
        this.subtype = subtype;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public void addAbility(Ability ability) {
        this.abilities.add(ability);
    }

    public void removeAbility(Ability ability) {
        this.abilities.remove(ability);
    }

    public void addSubtype(String subtype) {
        this.subtype.add(subtype);
    }

    public void removeSubtype(String subtype) {
        this.subtype.remove(subtype);
    }

}
