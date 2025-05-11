package com.github.tiagolofi.deployment;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import io.quarkus.builder.item.MultiBuildItem;

public final class ChaoticApiBuildItem extends MultiBuildItem {
    private final String serviceName;
    private final List<String> implementations;

    public ChaoticApiBuildItem(String serviceName, String... implementations) {
        this.serviceName = serviceName;
        // Make sure it's immutable
        this.implementations = Collections.unmodifiableList(
            Arrays.asList(
                implementations.clone()
            )
        );
    }

    public String getServiceName() {
        return serviceName;
    }

    public List<String> getImplementations() {
        return implementations;
    }
}