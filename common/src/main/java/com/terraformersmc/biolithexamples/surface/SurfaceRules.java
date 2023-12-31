package com.terraformersmc.biolithexamples.surface;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.noise.NoiseParametersKeys;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;

import static net.minecraft.world.gen.surfacebuilder.MaterialRules.*;

public class SurfaceRules {
    private static MaterialRule block(Block block) {
        return MaterialRules.block(block.getDefaultState());
    }

    public static MaterialRule overworld() {
        // Biome-level rules
        MaterialRule crimsonForest = condition(MaterialRules.biome(BiomeKeys.CRIMSON_FOREST), sequence(
                condition(STONE_DEPTH_FLOOR,
                        MaterialRules.sequence(
                                MaterialRules.condition(MaterialRules.noiseThreshold(NoiseParametersKeys.NETHER_WART, 1.17), block(Blocks.NETHER_WART_BLOCK)),
                                block(Blocks.CRIMSON_NYLIUM))),
                block(Blocks.NETHERRACK)));
        MaterialRule warpedForest = condition(MaterialRules.biome(BiomeKeys.WARPED_FOREST), sequence(
                condition(STONE_DEPTH_FLOOR,
                        MaterialRules.sequence(
                                MaterialRules.condition(MaterialRules.noiseThreshold(NoiseParametersKeys.NETHER_WART, 1.17), block(Blocks.WARPED_WART_BLOCK)),
                                block(Blocks.WARPED_NYLIUM))),
                block(Blocks.NETHERRACK)));

        // Return a surface-only sequence of our surface rules
        return condition(surface(), sequence(crimsonForest, warpedForest));
    }

    public static MaterialRule nether() {
        // Biome-level rules
         MaterialRule endHighlands = MaterialRules.condition(MaterialRules.biome(BiomeKeys.END_HIGHLANDS), block(Blocks.END_STONE));

        // Return a sequence of our surface rules, preserving the bedrock floor and roof
        return MaterialRules.sequence(
                MaterialRules.condition(MaterialRules.verticalGradient("bedrock_floor", YOffset.getBottom(), YOffset.aboveBottom(5)), block(Blocks.BEDROCK)),
                MaterialRules.condition(MaterialRules.not(MaterialRules.verticalGradient("bedrock_roof", YOffset.belowTop(5), YOffset.getTop())), block(Blocks.BEDROCK)),
                endHighlands);
    }

    public static MaterialRule end() {
        // Biome-level rules
        MaterialRule plains = MaterialRules.condition(MaterialRules.biome(BiomeKeys.PLAINS), sequence(
                condition(STONE_DEPTH_FLOOR, block(Blocks.GRASS_BLOCK)),
                condition(STONE_DEPTH_FLOOR_WITH_SURFACE_DEPTH, block(Blocks.DIRT))));

        // Return a sequence of our surface rules
        // If there were more than one rule here, we would wrap them with sequence() like this:
        // return sequence(a, b);
        return plains;
    }
}
