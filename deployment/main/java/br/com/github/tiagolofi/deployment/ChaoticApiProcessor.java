package br.com.github.tiagolofi.deployment;

public final class ChaoticApiProcessor extends MultiBuildItem {
    private static final String FEATURE = "chaotic-api-extension";

    @BuildStep
    FeatureBuildItem feature() {
        return new FeatureBuildItem(FEATURE);
    }
}