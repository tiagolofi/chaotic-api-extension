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

    public Condition(List<String> tribe, List<String> subtype, List<String> elements, String discipline, String operator, String strValue, int intValue) {
        this.tribe = tribe;
        this.subtype = subtype;
        this.elements = elements;
        this.discipline = discipline;
        this.operator = operator;
        this.strValue = strValue;
        this.intValue = intValue;
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
}
