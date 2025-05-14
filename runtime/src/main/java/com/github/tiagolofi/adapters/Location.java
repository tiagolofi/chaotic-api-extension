package com.github.tiagolofi.adapters;

import java.util.ArrayList;
import java.util.List;

import com.github.tiagolofi.adapters.triggerable.Effect;
import com.github.tiagolofi.ports.Card;

public class Location implements Card {
    private String chaotidId;
    private String name;
    private String text;
    private String initiative;
    private List<Effect> effects;
    private byte[] image;

    private Location(Builder builder) {
        this.chaotidId = builder.chaotidId;
        this.name = builder.name;
        this.text = builder.text;
        this.initiative = builder.initiative;
        this.effects = builder.effects;
        this.image = builder.image;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getChaotidId() {
        return this.chaotidId;
    }

    public String getName() {
        return this.name;
    }

    public String getText() {
        return this.text;
    }

    public String getInitiative() {
        return this.initiative;
    }

    public List<Effect> getEffects() {
        return this.effects;
    }

    public byte[] getImage() {
        return this.image;
    }

    public void setChaotidId(String chaotidId) {
        this.chaotidId = chaotidId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setInitiative(String initiative) {
        this.initiative = initiative;
    }

    public void setEffects(List<Effect> effects) {
        this.effects = effects;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public static class Builder {
        private String chaotidId;
        private String name;
        private String text;
        private String initiative;
        private List<Effect> effects = new ArrayList<>();
        private byte[] image;

        public Builder chaotidId(String chaotidId) {
            this.chaotidId = chaotidId;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder text(String text) {
            this.text = text;
            return this;
        }

        public Builder initiative(String initiative) {
            this.initiative = initiative;
            return this;
        }

        public Builder effects(List<Effect> effects) {
            this.effects = effects;
            return this;
        }

        public Builder addEffect(Effect effect) {
            this.effects.add(effect);
            return this;
        }

        public Builder image(byte[] image) {
            this.image = image;
            return this;
        }

        public Location build() {
            return new Location(this);
        }
    }

}
