package com.github.tiagolofi.adapters.valuable;

import com.github.tiagolofi.ports.Valuable;

public class Value implements Valuable {
    private boolean isValuable;
    private String attribute;
    private String attributeType;
    private String operator;
    private Object value;

    public Value(Builder builder) {
        this.attribute = builder.attribute;
        this.attributeType = builder.attributeType;
        this.operator = builder.operator;
        this.value = builder.value;
        this.isValuable = builder.isValuable;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getAttribute() {
        return this.attribute;
    }

    public String getAttributeType() {
        return this.attributeType;
    }

    public Object getValue() {
        return this.value;
    }

    public String getOperator() {
        return this.operator;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public void setAttributeType(String attributeType) {
        this.attributeType = attributeType;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public void setValuable(boolean isValuable) {
        this.isValuable = isValuable;
    }

    @Override
    public boolean isValuable() {
        return this.isValuable;
    }

    public static class Builder {
        private String attribute;
        private String attributeType;
        private String operator;
        private Object value;
        private boolean isValuable;

        public Builder attribute(String attribute) {
            this.attribute = attribute;
            return this;
        }

        public Builder attributeType(String attributeType) {
            this.attributeType = attributeType;
            return this;
        }

        public Builder operator(String operator) {
            this.operator = operator;
            return this;
        }

        public Builder value(Object value) {
            this.value = value;
            return this;
        }

        public Builder isValuable(boolean isValuable) {
            this.isValuable = isValuable;
            return this;
        }

        public Value build() {
            return new Value(this);
        }
    }

}
