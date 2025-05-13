package com.github.tiagolofi.ports;

public interface Computable {
    public void compute(String attribute, int value);

    public void compute(String attribute, String value);
}
