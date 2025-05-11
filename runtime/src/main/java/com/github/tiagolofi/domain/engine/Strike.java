package com.github.tiagolofi.domain.engine;

import java.util.ArrayList;
import java.util.List;

import com.github.tiagolofi.ports.Computable;
import com.github.tiagolofi.ports.Effect;
import com.github.tiagolofi.ports.Target;

public class Strike {
    private Target target;
    private List<Effect> effects = new ArrayList<>();
    private Computable computable;
}
