package com.github.tiagolofi.adapters.computable;

import com.github.tiagolofi.adapters.Attack;
import com.github.tiagolofi.ports.Card;
import com.github.tiagolofi.ports.Computable;

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

    public void setBasic(int basic) {
        this.basic = basic;
    }

    public void setFire(int fire) {
        this.fire = fire;
    }

    public void setAir(int air) {
        this.air = air;
    }

    public void setEarth(int earth) {
        this.earth = earth;
    }

    public void setWater(int water) {
        this.water = water;
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compute'");
    }


}
