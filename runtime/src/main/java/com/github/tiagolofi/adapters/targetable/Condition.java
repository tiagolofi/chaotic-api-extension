package com.github.tiagolofi.adapters.targetable;

import java.util.List;

public class Condition {
    private List<String> tribe;
    private List<String> subtype;
    private List<String> elements;
    private String discipline;
    private String operator; // check = ">=", fail = "<", challenge = ">"
    private String strValue;
    private int intValue;

    public Condition(Builder builder) {
        this.tribe = builder.tribe;
        this.subtype = builder.subtype;
        this.elements = builder.elements;
        this.discipline = builder.discipline;
        this.operator = builder.operator;
        this.strValue = builder.strValue;
        this.intValue = builder.intValue;
    }

    public static Builder builder() {
        return new Builder();
    }

    public List<String> getTribe() {
        return this.tribe;
    }

    public void setTribe(List<String> tribe) {
        this.tribe = tribe;
    }

    public List<String> getSubtype() {
        return this.subtype;
    }

    public void setSubtype(List<String> subtype) {
        this.subtype = subtype;
    }

    public List<String> getElements() {
        return this.elements;
    }

    public void setElements(List<String> elements) {
        this.elements = elements;
    }

    public String getDiscipline() {
        return this.discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public String getOperator() {
        return this.operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getStrValue() {
        return this.strValue;
    }

    public void setStrValue(String strValue) {
        this.strValue = strValue;
    }

    public int getIntValue() {
        return this.intValue;
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }

    public static class Builder {
        private List<String> tribe;
        private List<String> subtype;
        private List<String> elements;
        private String discipline;
        private String operator;
        private String strValue;
        private int intValue;

        public Builder tribe(List<String> tribe) {
            this.tribe = tribe;
            return this;
        }

        public Builder subtype(List<String> subtype) {
            this.subtype = subtype;
            return this;
        }

        public Builder elements(List<String> elements) {
            this.elements = elements;
            return this;
        }

        public Builder discipline(String discipline) {
            this.discipline = discipline;
            return this;
        }

        public Builder operator(String operator) {
            this.operator = operator;
            return this;
        }

        public Builder strValue(String strValue) {
            this.strValue = strValue;
            return this;
        }

        public Builder intValue(int intValue) {
            this.intValue = intValue;
            return this;
        }

        public Condition build() {
            return new Condition(this);
        }
    }
}
