package com.github.tiagolofi.adapters.computable;

import com.github.tiagolofi.ports.Computable;

public class Stats implements Computable {
    private int courage;
    private int power;
    private int wisdom;
    private int speed;
    private int energy;

    public Stats(Builder builder) {
        this.courage = builder.courage;
        this.power = builder.power;
        this.wisdom = builder.wisdom;
        this.speed = builder.speed;
        this.energy = builder.energy;
    }

    public static Builder builder() {
        return new Builder();
    }

    public int getCourage() {
        return this.courage;
    }

    public int getPower() {
        return this.power;
    }

    public int getWisdom() {
        return this.wisdom;
    }

    public int getSpeed() {
        return this.speed;
    }

    public int getEnergy() {
        return this.energy;
    }

    public void setCourage(int courage) {
        this.courage = courage;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public void addCourage(int courage) {
        this.courage += courage;
    }

    public void addPower(int power) {
        this.power += power;
    }

    public void addWisdom(int wisdom) {
        this.wisdom += wisdom;
    }

    public void addSpeed(int speed) {
        this.speed += speed;
    }

    public void addEnergy(int energy) {
        this.energy += energy;
    }

    public void addStat(String statName, int value) {
        switch (statName.toLowerCase()) {
            case "courage": addCourage(value); break;
            case "power": addPower(value); break;
            case "wisdom": addWisdom(value); break;
            case "speed": addSpeed(value); break;
            case "energy": addEnergy(value); break;
            default: throw new IllegalArgumentException("Stat desconhecida: " + statName);
        }
    }

    public void removeCourage(int courage) {
        this.courage -= courage;
    }

    public void removePower(int power) {
        this.power -= power;
    }

    public void removeWisdom(int wisdom) {
        this.wisdom -= wisdom;
    }

    public void removeSpeed(int speed) {
        this.speed -= speed;
    }

    public void removeEnergy(int energy) {
        this.energy -= energy;
    }

    public int get(String stat) {
        switch (stat.toLowerCase()) {
            case "courage":
                return this.courage;
            case "power":
                return this.power;
            case "wisdom":
                return this.wisdom;
            case "speed":
                return this.speed;
            case "energy":
                return this.energy;
            default:
                throw new IllegalArgumentException("Stat desconhecida: " + stat);
        }
    }

    @Override
    public void compute(String attribute, int value) {
       addStat(attribute, value);
    }

    @Override
    public void compute(String attribute, String value) {
        throw new UnsupportedOperationException("Unimplemented method 'compute'");
    }

    @Override
    public int apply() {
        throw new UnsupportedOperationException("Unimplemented method 'apply'");
    }

    @Override
    public String toString() {
        return "Stats{" +
                "courage=" + courage +
                ", power=" + power +
                ", wisdom=" + wisdom +
                ", speed=" + speed +
                ", energy=" + energy +
                '}';
    }

    public static class Builder {
        private int courage;
        private int power;
        private int wisdom;
        private int speed;
        private int energy;

        public Builder courage(int courage) {
            this.courage = courage;
            return this;
        }

        public Builder power(int power) {
            this.power = power;
            return this;
        }

        public Builder wisdom(int wisdom) {
            this.wisdom = wisdom;
            return this;
        }

        public Builder speed(int speed) {
            this.speed = speed;
            return this;
        }

        public Builder energy(int energy) {
            this.energy = energy;
            return this;
        }

        public Stats build() {
            return new Stats(this);
        }
    }

}
