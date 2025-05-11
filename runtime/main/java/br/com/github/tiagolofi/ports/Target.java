package br.com.github.tiagolofi.ports;

public interface Target {
    public String getType();
    public String getSide();
    public boolean satisfiesCondition();
}
