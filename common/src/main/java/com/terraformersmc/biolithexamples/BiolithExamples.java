package com.terraformersmc.biolithexamples;

import com.terraformersmc.biolith.api.biome.BiomePlacement;
import com.terraformersmc.biolith.api.biome.SubBiomeMatcher;
import com.terraformersmc.biolith.api.surface.SurfaceGeneration;
import com.terraformersmc.biolithexamples.surface.SurfaceRules;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BiolithExamples {
    public static final String MOD_ID = "biolith_examples";
    public static final String MOD_NAME = "Biolith Examples";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static void init() {
        // Check the noise placement system by misregistering a Nether biome to the Overworld.
        // temperature, humidity, continentalness, erosion, depth, weirdness, offset
        BiomePlacement.addOverworld(BiomeKeys.CRIMSON_FOREST,
                new MultiNoiseUtil.NoiseHypercube(
                        MultiNoiseUtil.ParameterRange.of(0.25f, 0.75f),
                        MultiNoiseUtil.ParameterRange.of(-0.75f, -0.25f),
                        MultiNoiseUtil.ParameterRange.of(0.5f, 1.0f),
                        MultiNoiseUtil.ParameterRange.of(-1.0f, 1.0f),
                        MultiNoiseUtil.ParameterRange.of(0.0f),
                        MultiNoiseUtil.ParameterRange.of(-1.0f, 1.0f),
                        0L));

        // Misregister some cross-dimensional biomes for fun and profit!
        BiomePlacement.replaceOverworld(BiomeKeys.PLAINS, BiomeKeys.WARPED_FOREST);
        BiomePlacement.replaceNether(BiomeKeys.WARPED_FOREST, BiomeKeys.END_HIGHLANDS);
        BiomePlacement.replaceEnd(BiomeKeys.END_HIGHLANDS, BiomeKeys.PLAINS);

        // Surface rules to go with the misregistered biomes...
        // Compatibility NOTE: TerraBlender will only use the rule if the namespace matches that of the biome.
        SurfaceGeneration.addOverworldSurfaceRules(Identifier.of("minecraft", "rules/overworld"), SurfaceRules.overworld());
        SurfaceGeneration.addNetherSurfaceRules(Identifier.of("minecraft", "rules/nether"), SurfaceRules.nether());
        SurfaceGeneration.addEndSurfaceRules(Identifier.of("minecraft", "rules/end"), SurfaceRules.end());

        // Check the sub-biome system.
        BiomePlacement.addSubOverworld(BiomeKeys.DESERT, BiomeKeys.OLD_GROWTH_PINE_TAIGA, SubBiomeMatcher.of(SubBiomeMatcher.NEAR_INTERIOR));
    }
}
