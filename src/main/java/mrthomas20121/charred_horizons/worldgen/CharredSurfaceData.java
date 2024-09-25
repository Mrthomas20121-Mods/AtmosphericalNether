package mrthomas20121.charred_horizons.worldgen;

import mrthomas20121.charred_horizons.data.CharredBiomes;
import mrthomas20121.charred_horizons.init.CharredBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;

public class CharredSurfaceData {

    public static SurfaceRules.RuleSource rules() {
        return SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.isBiome(CharredBiomes.DECAYING_VALLEY),
                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                                SurfaceRules.ifTrue(SurfaceRules.yStartCheck(VerticalAnchor.absolute(35), 0),
                                    SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.PATCH, 0.1D),
                                            SurfaceRules.state(CharredBlocks.WITHERED_NYLIUM.get().defaultBlockState()))))),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(CharredBiomes.DESOLATED_FOREST),
                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                                SurfaceRules.ifTrue(SurfaceRules.yStartCheck(VerticalAnchor.absolute(35), 0),
                                        SurfaceRules.state(CharredBlocks.BLIGHT_NYLIUM.get().defaultBlockState()))))
        );
    }
}
