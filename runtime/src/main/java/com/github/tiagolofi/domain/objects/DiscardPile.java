package com.github.tiagolofi.domain.objects;

import java.util.ArrayList;
import java.util.List;

import com.github.tiagolofi.ports.Card;

public class DiscardPile {
    List<Card> attacks = new ArrayList<>();

    public void addAttack(Card attack) {
        this.attacks.add(attack);
    }

    public void removeAttack(Card attack) {
        this.attacks.remove(attack);
    }

    public void clear() {
        this.attacks.clear();
    }
}
