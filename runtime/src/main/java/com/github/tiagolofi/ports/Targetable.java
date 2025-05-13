package com.github.tiagolofi.ports;

public interface Targetable {
    public boolean isApplicable(Card card);
    public boolean isApplicable(Card card1, Card card2);
}
