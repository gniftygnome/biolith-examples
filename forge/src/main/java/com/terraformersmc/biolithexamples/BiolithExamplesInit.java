package com.terraformersmc.biolithexamples;

import net.minecraftforge.fml.common.Mod;

@Mod(BiolithExamples.MOD_ID)
@SuppressWarnings("unused")
public class BiolithExamplesInit {
    public BiolithExamplesInit() {
        BiolithExamples.LOGGER.info("Biolith Examples for Forge is initializing...");

        // Call loader-agnostic init.
        BiolithExamples.init();
    }
}
