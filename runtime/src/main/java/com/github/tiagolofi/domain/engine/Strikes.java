package com.github.tiagolofi.domain.engine;

import java.util.ArrayList;
import java.util.List;

import com.github.tiagolofi.ports.Card;

public class Strikes {
    private List<Card> strikes = new ArrayList<>();

    public void addStrike(Card strike) {
        this.strikes.add(strike);
    }

    public void removeStrike(Card strike) {
        this.strikes.remove(strike);
    }

    public Card getStrike() {
        if (strikes.isEmpty()) {
            return null;
        }
        return strikes.get(strikes.size() - 1);
    }

    public List<Card> getStrikes() {
        return this.strikes;
    }

    public void clear() {
        this.strikes.clear();
    }
}
