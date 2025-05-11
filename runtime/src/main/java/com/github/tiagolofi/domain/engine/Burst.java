package com.github.tiagolofi.domain.engine;

import java.util.ArrayList;
import java.util.List;

import com.github.tiagolofi.ports.Effect;

public class Burst {
    private List<Effect> effects = new ArrayList<>();

    public void addEffect(Effect effect) {
        this.effects.add(effect);
    }
}
