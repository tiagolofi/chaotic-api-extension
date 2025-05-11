package com.github.tiagolofi.adapters.targetable;

import com.github.tiagolofi.ports.Targetable;

public class Target implements Targetable {
    
    private String type;
    private String side;
    private Condition condition;

    public Target(String type, String side) {
        this.type = type;
        this.side = side;
    }

    public String getType() {
        return this.type;
    }

    public String getSide() {
        return this.side;
    }

    public Condition getCondition() {
        return this.condition;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    @Override
    public boolean getSatisfier() {
        throw new UnsupportedOperationException("Unimplemented method 'getSatisfier'");
    }

}
