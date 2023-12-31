package com.terraformersmc.biolithexamples;

import net.neoforged.fml.common.Mod;

@Mod(BiolithExamples.MOD_ID)
@SuppressWarnings("unused")
public class BiolithExamplesInit {
    public BiolithExamplesInit() {
        BiolithExamples.LOGGER.info("Biolith Examples for NeoForge is initializing...");

        // Call loader-agnostic init.
        BiolithExamples.init();
    }
}
