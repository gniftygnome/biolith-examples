package com.terraformersmc.biolithexamples;

import com.terraformersmc.biolith.api.biome.BiomePlacement;
import com.terraformersmc.biolith.api.biome.sub.CriterionBuilder;
import com.terraformersmc.biolith.api.surface.SurfaceGeneration;
import com.terraformersmc.biolithexamples.surface.ExampleSurfaceRules;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BiolithExamples {
    public static final String MOD_ID = "biolith_examples";
    public static final String MOD_NAME = "Biolith Examples";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static void init() {
        // Check the noise placement system by misregistering a Nether biome to the Overworld.
        // temperature, humidity, continentalness, erosion, depth, weirdness, offset
        BiomePlacement.addOverworld(Biomes.CRIMSON_FOREST,
                new Climate.ParameterPoint(
                        Climate.Parameter.span(-1.0f, -0.15f),
                        Climate.Parameter.span(-1.0f, -0.35f),
                        Climate.Parameter.span(0.3f, 1.0f),
                        Climate.Parameter.span(-0.375f, 0.05f),
                        Climate.Parameter.point(0.0f),
                        Climate.Parameter.span(0.0f, 1.0f),
                        0L));

        // Remove an unlucky biome from the Overworld.
        BiomePlacement.removeOverworld(Biomes.CHERRY_GROVE);

        // Misregister some cross-dimensional biomes for fun and profit!
        BiomePlacement.replaceOverworld(Biomes.PLAINS, Biomes.WARPED_FOREST);
        BiomePlacement.replaceNether(Biomes.WARPED_FOREST, Biomes.END_HIGHLANDS);
        BiomePlacement.replaceEnd(Biomes.END_HIGHLANDS, Biomes.PLAINS);

        // Surface rules to go with the misregistered biomes...
        // Compatibility NOTES:
        //      TerraBlender will only use a rule if the namespace matches that of the biome.
        //      TerraBlender will not accept rules targeting vanilla biomes (f.e. the ones below).
        SurfaceGeneration.addOverworldSurfaceRules(Identifier.fromNamespaceAndPath("minecraft", "rules/overworld"), ExampleSurfaceRules.overworld());
        SurfaceGeneration.addNetherSurfaceRules(Identifier.fromNamespaceAndPath("minecraft", "rules/nether"), ExampleSurfaceRules.nether());
        SurfaceGeneration.addEndSurfaceRules(Identifier.fromNamespaceAndPath("minecraft", "rules/end"), ExampleSurfaceRules.end());

        // Check the sub-biome system.
        BiomePlacement.addSubOverworld(Biomes.DESERT, Biomes.OLD_GROWTH_PINE_TAIGA, CriterionBuilder.NEAR_INTERIOR);
    }
}
