package com.github.tiagolofi.adapters.computable;

public class Value {
    private String attribute;
    private String attributeType;
    private int intValue;
    private String operator;
    private String strValue;

    public String getAttribute() {
        return this.attribute;
    }

    public String getAttributeType() {
        return this.attributeType;
    }

    public int getIntValue() {
        return this.intValue;
    }

    public String getStrValue() {
        return this.strValue;
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

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }

    public void setStrValue(String strValue) {
        this.strValue = strValue;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

}
