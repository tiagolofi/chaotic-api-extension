package com.github.tiagolofi.adapters;

import java.util.ArrayList;
import java.util.List;

import com.github.tiagolofi.adapters.triggerable.Effect;
import com.github.tiagolofi.ports.Card;

public class Battlegear implements Card {
    private String chaoticId;
    private String name;
    private String text;
    private List<Effect> effects;
    private byte[] image;

    private Battlegear(Builder builder) {
        this.chaoticId = builder.chaoticId;
        this.name = builder.name;
        this.text = builder.text;
        this.effects = builder.effects;
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

    public String getText() {
        return this.text;
    }

    public List<Effect> getEffects() {
        return this.effects;
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

    public void setText(String text) {
        this.text = text;
    }

    public void setEffects(List<Effect> effects) {
        this.effects = effects;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public static class Builder {
        private String chaoticId;
        private String name;
        private String text;
        private List<Effect> effects = new ArrayList<>();
        private byte[] image;

        public Builder chaoticId(String chaoticId) {
            this.chaoticId = chaoticId;
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

        public Battlegear build() {
            return new Battlegear(this);
        }
    }

}

