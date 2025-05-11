package com.github.tiagolofi.adapters;

import java.util.List;

import com.github.tiagolofi.adapters.triggerable.Effect;
import com.github.tiagolofi.ports.Card;

public class Battlegear implements Card {
    private String chaoticId;
    private String name;
    private String text;
    private List<Effect> effects;
    private byte[] image;

    public Battlegear(String chaoticId, String name, String text, List<Effect> effects, byte[] image) {
        this.chaoticId = chaoticId;
        this.name = name;
        this.text = text;
        this.effects = effects;
        this.image = image;
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

}

