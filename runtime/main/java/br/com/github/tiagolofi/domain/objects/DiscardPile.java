package br.com.github.tiagolofi.domain.objects;

public class DiscardPile {
    List<Card> attacks = new ArrayList<>();

    public void addAttack(Card attack) {
        this.attacks.add(attack);
    }

    public void removeAttack(Card attack) {
        this.attacks.remove(attack);
    }

    public void clear() {
        this.attacks.clear();
    }
}
