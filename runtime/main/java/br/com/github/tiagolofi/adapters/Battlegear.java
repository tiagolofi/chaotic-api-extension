package br.com.github.tiagolofi.adapters;

public class Battlegear implements Card {
    private String chaoticId;
    private String name;
    private String text;
    private List<Effect> effects;
    private bytes[] image;

    public Battlegear(String chaoticId, String name, String text, List<Effect> effects, bytes[] image) {
        this.chaoticId = chaoticId;
        this.name = name;
        this.text = text;
        this.effects = effects;
        this.image = image;
    }

    public String getChaoticId() {
        return this.chaoticId;
    }

    public String getName() {
        return this.name;
    }

    public String getText() {
        return this.text;
    }

    public List<Effect> getEffects() {
        return this.effects;
    }

    public bytes[] getImage() {
        return this.image;
    }

    public void setChaoticId(String chaoticId) {
        this.chaoticId = chaoticId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setEffects(List<Effect> effects) {
        this.effects = effects;
    }

    public void setImage(bytes[] image) {
        this.image = image;
    }

}

