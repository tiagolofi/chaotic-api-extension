package com.github.tiagolofi.domain.objects;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Player {
    private Deck deck;
    private DiscardPile discardPile;
    private boolean isActive;
    private boolean isWinner;

    public Player() {}

    public Player(Deck deck) {
        this.deck = deck;
        this.isActive = false;
        this.isWinner = false;
    }

    public Deck getDeck() {
        return this.deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public boolean isWinner() {
        return this.isWinner;
    }

    public void setWinner(boolean isWinner) {
        this.isWinner = isWinner;
    }

    public DiscardPile getDiscardPile() {
        return this.discardPile;
    }

    public void setDiscardPile(DiscardPile discardPile) {
        this.discardPile = discardPile;
    }
}
