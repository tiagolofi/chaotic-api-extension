package com.github.tiagolofi.adapters.computable;

import com.github.tiagolofi.ports.Computable;

public class Damage implements Computable {
    private int basic;
    private int fire;
    private int air;
    private int earth;
    private int water;

    public Damage(Builder builder) {
        this.basic = builder.basic;
        this.fire = builder.fire;
        this.air = builder.air;
        this.earth = builder.earth;
        this.water = builder.water;
    }

    public static Builder builder() {
        return new Builder();
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

    public void addBasic(int basic) {
        this.basic += basic;
    }

    public void addFire(int fire) {
        this.fire += fire;
    }

    public void addAir(int air) {
        this.air += air;
    }

    public void addEarth(int earth) {
        this.earth += earth;
    }

    public void addWater(int water) {
        this.water += water;
    }

    public void addDamage(String name, int value) {
        switch (name) {
            case "basic": addBasic(value); break;
            case "fire": addFire(value); break;
            case "air": addAir(value); break;
            case "earth": addEarth(value); break;
            case "water": addWater(value); break;
            default:
                throw new IllegalArgumentException("Invalid damage type: " + name);
        }
    }

    public void removeBasic(int basic) {
        this.basic -= basic;
    }

    public void removeFire(int fire) {
        this.fire -= fire;
    }

    public void removeAir(int air) {
        this.air -= air;
    }

    public void removeEarth(int earth) {
        this.earth -= earth;
    }

    public void removeWater(int water) {
        this.water -= water;
    }

    @Override
    public void compute(String attribute, int value) {
        addDamage(attribute, value);
    }

    @Override
    public void compute(String attribute, String value) {
        throw new UnsupportedOperationException("Unimplemented method 'compute'");
    }

    @Override
    public int apply() {
        return this.fire + this.air + this.earth + this.water;
    }

    public static class Builder {
        private int basic;
        private int fire;
        private int air;
        private int earth;
        private int water;

        public Builder basic(int basic) {
            this.basic = basic;
            return this;
        }

        public Builder fire(int fire) {
            this.fire = fire;
            return this;
        }

        public Builder air(int air) {
            this.air = air;
            return this;
        }

        public Builder earth(int earth) {
            this.earth = earth;
            return this;
        }

        public Builder water(int water) {
            this.water = water;
            return this;
        }

        public Damage build() {
            return new Damage(this);
        }
    }

}
