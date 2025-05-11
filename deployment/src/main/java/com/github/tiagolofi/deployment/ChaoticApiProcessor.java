package com.github.tiagolofi.deployment;

import com.github.tiagolofi.domain.engine.Burst;
import com.github.tiagolofi.domain.engine.Engaged;
import com.github.tiagolofi.domain.engine.Turn;


import io.quarkus.builder.item.MultiBuildItem;
import io.quarkus.deployment.annotations.BuildStep;

public final class ChaoticApiProcessor extends MultiBuildItem {

    public static final String SERVICE_NAME = "chaotic-api-extension";

    @BuildStep
    public ChaoticApiBuildItem registerOneService() {
        return new ChaoticApiBuildItem(
            SERVICE_NAME,
            Burst.class.getName(),
            Engaged.class.getName(),
            Turn.class.getName()
        );
    }

}