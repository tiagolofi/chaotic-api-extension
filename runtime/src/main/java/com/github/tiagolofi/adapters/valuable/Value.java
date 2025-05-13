package com.github.tiagolofi.adapters.valuable;

import com.github.tiagolofi.ports.Valuable;

public class Value implements Valuable {
    private boolean isValuable;
    private String attribute;
    private String attributeType;
    private String operator;
    private Object value;

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

}
