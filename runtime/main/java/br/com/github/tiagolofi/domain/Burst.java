package br.com.github.tiagolofi.domain;

public class Burst {
    private List<Effect> effects = new ArrayList<>();

    public void addEffect(Effect effect) {
        this.effects.add(effect);
    }
}
