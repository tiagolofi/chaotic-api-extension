package com.github.tiagolofi.domain.engine;

import java.util.ArrayList;
import java.util.List;

import com.github.tiagolofi.ports.Card;

public class DiscardPile {
    List<Card> attacks = new ArrayList<>();

    public void addAttack(Card attack) {
        this.attacks.add(attack);
    }

    public List<Card> getAttacks() {
        return this.attacks;
    }

    public Card getAttack(int index) {
        return this.attacks.get(index);
    }

    public void removeAttack(Card attack) {
        this.attacks.remove(attack);
    }

    public void clear() {
        this.attacks.clear();
    }
}
