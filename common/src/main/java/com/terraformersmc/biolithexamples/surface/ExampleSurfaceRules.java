package com.terraformersmc.biolithexamples.surface;

import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;

import static net.minecraft.world.level.levelgen.SurfaceRules.*;

public class ExampleSurfaceRules {
    private static RuleSource block(Block block) {
        return state(block.defaultBlockState());
    }

    public static RuleSource overworld() {
        // Biome-level rules
        RuleSource birchForest = ifTrue(isBiome(Biomes.BIRCH_FOREST), block(Blocks.CALCITE));
        RuleSource crimsonForest = ifTrue(isBiome(Biomes.CRIMSON_FOREST), sequence(
                ifTrue(ON_FLOOR,
                        sequence(
                                ifTrue(noiseCondition(Noises.NETHER_WART, 1.17), block(Blocks.NETHER_WART_BLOCK)),
                                block(Blocks.CRIMSON_NYLIUM))),
                block(Blocks.NETHERRACK)));
        RuleSource warpedForest = ifTrue(isBiome(Biomes.WARPED_FOREST), sequence(
                ifTrue(ON_FLOOR,
                        sequence(
                                ifTrue(noiseCondition(Noises.NETHER_WART, 1.17), block(Blocks.WARPED_WART_BLOCK)),
                                block(Blocks.WARPED_NYLIUM))),
                block(Blocks.NETHERRACK)));

        // Return a surface-only sequence of our surface rules
        return ifTrue(abovePreliminarySurface(), sequence(birchForest, crimsonForest, warpedForest));
    }

    public static RuleSource nether() {
        // Biome-level rules
        RuleSource endHighlands = SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.END_HIGHLANDS), block(Blocks.END_STONE));

        // Return a sequence of our surface rules, preserving the bedrock floor and roof
        return SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.verticalGradient("bedrock_floor", VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(5)), block(Blocks.BEDROCK)),
                SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.verticalGradient("bedrock_roof", VerticalAnchor.belowTop(5), VerticalAnchor.top())), block(Blocks.BEDROCK)),
                endHighlands);
    }

    public static RuleSource end() {
        // Biome-level rules
        RuleSource plains = SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.PLAINS), sequence(
                ifTrue(ON_FLOOR, block(Blocks.GRASS_BLOCK)),
                ifTrue(UNDER_FLOOR, block(Blocks.DIRT))));

        // Return a sequence of our surface rules
        // If there were more than one rule here, we would wrap them with sequence() like this:
        // return sequence(a, b);
        return plains;
    }
}
