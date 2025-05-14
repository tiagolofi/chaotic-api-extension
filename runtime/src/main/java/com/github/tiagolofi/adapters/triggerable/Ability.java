package com.github.tiagolofi.adapters.triggerable;

import com.github.tiagolofi.ports.Targetable;
import com.github.tiagolofi.ports.Triggerable;
import com.github.tiagolofi.ports.Valuable;

public class Ability implements Triggerable {
    private String name;
    private String type;
    private String description;
    private Targetable target;
    private Valuable value;

    public Ability(Builder builder) {
        this.name = builder.name;
        this.type = builder.type;
        this.description = builder.description;
        this.target = builder.target;
        this.value = builder.value;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public String getDescription() {
        return this.description;
    }

    @Override
    public Targetable getTarget() {
        return this.target;
    }

    @Override
    public Valuable getValue() {
        return this.value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTarget(Targetable target) {
        this.target = target;
    }

    public void setValue(Valuable value) {
        this.value = value;
    }

    @Override
    public boolean isToggleable() {
        throw new UnsupportedOperationException("Unimplemented method 'isToggleable'");
    }

    @Override
    public boolean isActive() {
        throw new UnsupportedOperationException("Unimplemented method 'isActive'");
    }

    public static class Builder {
        private String name;
        private String type;
        private String description;
        private Targetable target;
        private Valuable value;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder target(Targetable target) {
            this.target = target;
            return this;
        }

        public Builder value(Valuable value) {
            this.value = value;
            return this;
        }

        public Ability build() {
            return new Ability(this);
        }
    }

}
