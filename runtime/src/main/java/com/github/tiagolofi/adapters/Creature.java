package com.github.tiagolofi.adapters;

import java.util.ArrayList;
import java.util.List;

import com.github.tiagolofi.adapters.computable.Stats;
import com.github.tiagolofi.adapters.triggerable.Ability;
import com.github.tiagolofi.ports.Card;

public class Creature implements Card {
    private String chaoticId;
    private String name;
    private String tribe;
    private List<String> subtype;
    private Stats stats;
    private List<Ability> abilities;
    private List<String> elements;
    private byte[] image;

    private Creature(Builder builder) {
        this.chaoticId = builder.chaoticId;
        this.name = builder.name;
        this.tribe = builder.tribe;
        this.subtype = builder.subtype;
        this.stats = builder.stats;
        this.abilities = builder.abilities;
        this.elements = builder.elements;
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

    public List<String> getElements() {
        return this.elements;
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

    public void setElements(List<String> elements) {
        this.elements = elements;
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

    public void addElement(String element) {
        this.elements.add(element);
    }

    public void removeElement(String element) {
        this.elements.remove(element);
    }

    @Override
    public String toString() {
        return "Creature{" +
                "chaoticId='" + chaoticId + '\'' +
                ", name='" + name + '\'' +
                ", tribe='" + tribe + '\'' +
                ", subtype=" + subtype +
                ", stats=" + stats +
                ", abilities=" + abilities +
                ", elements=" + elements +
                '}';
    }

    public static class Builder {
        private String chaoticId;
        private String name;
        private String tribe;
        private List<String> subtype = new ArrayList<>();
        private Stats stats;
        private List<Ability> abilities = new ArrayList<>();
        private List<String> elements = new ArrayList<>();
        private byte[] image;

        public Builder chaoticId(String chaoticId) {
            this.chaoticId = chaoticId;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder tribe(String tribe) {
            this.tribe = tribe;
            return this;
        }

        public Builder subtype(List<String> subtype) {
            this.subtype = subtype;
            return this;
        }

        public Builder addSubtype(String subtype) {
            this.subtype.add(subtype);
            return this;
        }

        public Builder stats(Stats stats) {
            this.stats = stats;
            return this;
        }

        public Builder abilities(List<Ability> abilities) {
            this.abilities = abilities;
            return this;
        }

        public Builder addAbility(Ability ability) {
            this.abilities.add(ability);
            return this;
        }

        public Builder elements(List<String> elements) {
            this.elements = elements;
            return this;
        }

        public Builder addElement(String element) {
            this.elements.add(element);
            return this;
        }

        public Builder image(byte[] image) {
            this.image = image;
            return this;
        }

        public Creature build() {
            return new Creature(this);
        }
    }

}
