package com.github.tiagolofi.deployment;

import com.github.tiagolofi.domain.engine.Burst;
import com.github.tiagolofi.domain.engine.Engaged;
import com.github.tiagolofi.domain.engine.Match;
import com.github.tiagolofi.domain.engine.Turn;


import io.quarkus.builder.item.MultiBuildItem;
import io.quarkus.deployment.annotations.BuildStep;

public final class ChaoticApiProcessor extends MultiBuildItem {

    @BuildStep
    public ChaoticApiBuildItem registerOneService() {
    return new ChaoticApiBuildItem(
        Match.class.getName(),
        Burst.class.getName()
    );
}

}