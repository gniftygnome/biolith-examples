package com.terraformersmc.biolithexamples;

import net.fabricmc.api.ModInitializer;

public class BiolithExamplesInit  implements ModInitializer {
    @Override
    public void onInitialize() {
        BiolithExamples.LOGGER.info("Biolith Examples for Fabric is initializing...");

        // Call loader-agnostic init.
        BiolithExamples.init();
    }
}
