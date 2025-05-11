package com.github.tiagolofi.adapters;

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

    public Location(String chaotidId, String name, String text, String initiative, List<Effect> effects, byte[] image) {
        this.chaotidId = chaotidId;
        this.name = name;
        this.text = text;
        this.initiative = initiative;
        this.effects = effects;
        this.image = image;
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

}
