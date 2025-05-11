package com.github.tiagolofi.domain.objects;

import com.github.tiagolofi.ports.Card;

public class Board {
    private Card location;

    public Card getLocation() {
        return this.location;
    }

    public void setLocation(Card location) {
        this.location = location;
    }
}
