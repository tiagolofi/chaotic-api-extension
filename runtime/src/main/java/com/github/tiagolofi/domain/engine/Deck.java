package com.github.tiagolofi.domain.engine;

import java.util.ArrayList;
import java.util.List;

import com.github.tiagolofi.ports.Card;

public class Deck {
    private List<Card> creatures = new ArrayList<>();
    private List<Card> battlegears = new ArrayList<>();
    private List<Card> attacks = new ArrayList<>();
    private List<Card> mugic = new ArrayList<>();
    private List<Card> locations = new ArrayList<>();

    public List<Card> getCreatures() {
        return this.creatures;
    }

    public List<Card> getBattlegears() {
        return this.battlegears;
    }

    public List<Card> getAttacks() {
        return this.attacks;
    }

    public List<Card> getMugic() {
        return this.mugic;
    }

    public List<Card> getLocations() {
        return this.locations;
    }

    public Card getCreature(int index) {
        return this.creatures.get(index);
    }

    public Card getBattlegear(int index) {
        return this.battlegears.get(index);
    }

    public Card getAttack(int index) {
        return this.attacks.get(index);
    }

    public Card getMugic(int index) {
        return this.mugic.get(index);
    }

    public Card getLocation(int index) {
        return this.locations.get(index);
    }

    public void addCreature(Card creature) {
        this.creatures.add(creature);
    }

    public void addBattlegear(Card battlegear) {
        this.battlegears.add(battlegear);
    }

    public void addAttack(Card attack) {
        this.attacks.add(attack);
    }

    public void addMugic(Card mugic) {
        this.mugic.add(mugic);
    }

    public void addLocation(Card location) {
        this.locations.add(location);
    }

    public void removeCreature(Card creature) {
        this.creatures.remove(creature);
    }

    public void removeBattlegear(Card battlegear) {
        this.battlegears.remove(battlegear);
    }

    public void removeAttack(Card attack) {
        this.attacks.remove(attack);
    }

    public void removeMugic(Card mugic) {
        this.mugic.remove(mugic);
    }

    public void removeLocation(Card location) {
        this.locations.remove(location);
    }

    public void clearDeck() {
        this.creatures.clear();
        this.battlegears.clear();
        this.attacks.clear();
        this.mugic.clear();
        this.locations.clear();
    }

    @Override
    public String toString() {
        return "Deck{" +
                "creatures=" + creatures +
                ", battlegears=" + battlegears +
                ", attacks=" + attacks +
                ", mugic=" + mugic +
                ", locations=" + locations +
                '}';
    }
}
