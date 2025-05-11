package br.com.github.tiagolofi.deployment;

import io.quarkus.arc.deployment.AdditionalBeanBuildItem;
import io.quarkus.arc.deployment.InterceptorBindingRegistrarBuildItem;
import io.quarkus.arc.deployment.UnremovableBeanBuildItem;
import io.quarkus.builder.item.MultiBuildItem;
import io.quarkus.deployment.annotations.BuildProducer;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.builditem.CombinedIndexBuildItem;
import io.quarkus.deployment.builditem.FeatureBuildItem;
import io.quarkus.deployment.builditem.nativeimage.ReflectiveClassBuildItem;
import io.quarkus.deployment.builditem.nativeimage.ReflectiveMethodBuildItem;

public final class ChaoticApiProcessor extends MultiBuildItem {
    private static final String FEATURE = "CHAOTIC_API_EXTENSION";

    @BuildStep
    FeatureBuildItem feature() {
        return new FeatureBuildItem(FEATURE);
    }

    @BuildStep
    UnremovableBeanBuildItem registerAdditionalBeans(
        CombinedIndexBuildItem indexBuildItem,
        BuildProducer<ReflectiveClassBuildItem> reflectiveClasses,
        BuildProducer<AdditionalBeanBuildItem> additionalBeans,
        BuildProducer<InterceptorBindingRegistrarBuildItem> interceptorBindings,
        BuildProducer<ReflectiveMethodBuildItem> reflectiveMethods
    ) {

        additionalBeans.produce(
            AdditionalBeanBuildItem.builder()
                .setUnremovable()
                .addBeanClass(Match.class)
                .addBeanClass(Burst.class)
                .addBeanClass(Engaged.class)
                .addBeanClass(Strike.class)
                .addBeanClass(Turn.class)
                .build()
            );

    }

}