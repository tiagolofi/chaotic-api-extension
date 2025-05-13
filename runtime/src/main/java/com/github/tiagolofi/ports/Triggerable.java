package com.github.tiagolofi.ports;

import com.github.tiagolofi.adapters.computable.Value;

public interface Triggerable {
    public Targetable getTarget();
    public Value getValue();
    public boolean isToggleable();
    public boolean isActive();
}
