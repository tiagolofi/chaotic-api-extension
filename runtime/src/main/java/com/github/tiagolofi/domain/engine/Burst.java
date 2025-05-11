package com.github.tiagolofi.domain.engine;

import java.util.ArrayList;
import java.util.List;

import com.github.tiagolofi.ports.Triggerable;

public class Burst {
    private List<Triggerable> triggers = new ArrayList<>();

    public void addTrigger(Triggerable trigger) {
        this.triggers.add(trigger);
    }

    public Triggerable getTrigger(int index) {
        return this.triggers.get(index);
    }
}
