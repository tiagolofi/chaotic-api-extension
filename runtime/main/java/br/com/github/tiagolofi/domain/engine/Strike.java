package br.com.github.tiagolofi.domain.engine;

import java.util.List;

public class Strike {
    private Target target;
    private List<Effect> effects = new ArrayList<>();
    private Computable computable;
}
