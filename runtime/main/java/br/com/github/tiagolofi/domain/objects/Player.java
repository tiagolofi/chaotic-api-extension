package br.com.github.tiagolofi.domain.objects;

public class Player {
    private Deck deck;
    private boolean isActive;
    private boolean isWinner;

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
}
