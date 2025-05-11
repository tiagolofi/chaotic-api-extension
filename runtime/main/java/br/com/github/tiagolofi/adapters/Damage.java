package br.com.github.tiagolofi.adapters;

public class Damage implements Computable {
    private int basic;
    private int fire;
    private int air;
    private int earth;
    private int water;

    public Damage(int basic, int fire, int air, int earth, int water) {
        this.basic = basic;
        this.fire = fire;
        this.air = air;
        this.earth = earth;
        this.water = water;
    }

    public int getBasic() {
        return this.basic;
    }

    public int getFire() {
        return this.fire;
    }

    public int getAir() {
        return this.air;
    }

    public int getEarth() {
        return this.earth;
    }

    public int getWater() {
        return this.water;
    }

}
