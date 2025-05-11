package com.github.tiagolofi.domain.engine;

import java.util.ArrayList;
import java.util.List;

import com.github.tiagolofi.ports.Triggerable;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Burst {
    private List<Triggerable> triggers = new ArrayList<>();

    public void addTrigger(Triggerable trigger) {
        this.triggers.add(trigger);
    }

    public Triggerable getTrigger(int index) {
        return this.triggers.get(index);
    }

    public void removeTrigger(Triggerable trigger) {
        this.triggers.remove(trigger);
    }

    public void clear() {
        this.triggers.clear();
    }
}
