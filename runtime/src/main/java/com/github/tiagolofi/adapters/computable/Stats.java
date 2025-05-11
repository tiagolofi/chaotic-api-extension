package com.github.tiagolofi.adapters.computable;

import com.github.tiagolofi.ports.Computable;

public class Stats implements Computable {
    private int courage;
    private int power;
    private int wisdom;
    private int speed;
    private int energy;

    public Stats(int courage, int power, int wisdom, int speed, int energy) {
        this.courage = courage;
        this.power = power;
        this.wisdom = wisdom;
        this.speed = speed;
        this.energy = energy;
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
    public String getAttribute() {
        throw new UnsupportedOperationException("Unimplemented method 'getAttribute'");
    }

    @Override
    public String getStringValue() {
        throw new UnsupportedOperationException("Unimplemented method 'getValue'");
    }

    @Override
    public int getIntValue() {
        throw new UnsupportedOperationException("Unimplemented method 'getIntValue'");
    }

}
