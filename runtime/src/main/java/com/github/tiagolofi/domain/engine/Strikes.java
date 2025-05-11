package com.github.tiagolofi.domain.engine;

import java.util.ArrayList;
import java.util.List;

import com.github.tiagolofi.ports.Card;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Strikes {
    private List<Card> strikes = new ArrayList<>();

    public void addStrike(Card strike) {
        this.strikes.add(strike);
    }

    public void removeStrike(Card strike) {
        this.strikes.remove(strike);
    }

    public List<Card> getStrikes() {
        return this.strikes;
    }

    public void clear() {
        this.strikes.clear();
    }
}
