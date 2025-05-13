package com.github.tiagolofi.ports;

public interface Triggerable {
    public Targetable getTarget();
    public Valuable getValue();
    public boolean isToggleable();
    public boolean isActive();
}
