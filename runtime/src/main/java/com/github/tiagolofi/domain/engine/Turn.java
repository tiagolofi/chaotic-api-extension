package com.github.tiagolofi.domain.engine;

public class Turn {
    private Burst burst = new Burst();
    private Engaged engagedPlayer1;
    private Engaged engagedPlayer2;

    public Burst getBurst() {
        return this.burst;
    }

    public void setBurst(Burst burst) {
        this.burst = burst;
    }

    public Engaged getEngagedPlayer1() {
        return this.engagedPlayer1;
    }

    public void setEngagedPlayer1(Engaged engagedPlayer1) {
        this.engagedPlayer1 = engagedPlayer1;
    }

    public Engaged getEngagedPlayer2() {
        return this.engagedPlayer2;
    }

    public void setEngagedPlayer2(Engaged engagedPlayer2) {
        this.engagedPlayer2 = engagedPlayer2;
    }
}
