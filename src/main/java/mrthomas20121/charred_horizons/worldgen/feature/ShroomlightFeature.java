package mrthomas20121.charred_horizons.worldgen.feature;

import com.mojang.serialization.Codec;
import mrthomas20121.charred_horizons.init.CharredBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class ShroomlightFeature extends Feature<NoneFeatureConfiguration> {

    public ShroomlightFeature(Codec<NoneFeatureConfiguration> p_67375_) {
        super(p_67375_);
    }

    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel worldgenlevel = context.level();
        BlockPos blockpos = context.origin();
        RandomSource randomsource = context.random();
        if (!worldgenlevel.isEmptyBlock(blockpos)) {
            return false;
        } else {
            BlockState blockstate = worldgenlevel.getBlockState(blockpos.above());
            if (!blockstate.is(Blocks.NETHERRACK) && !blockstate.is(Blocks.BASALT) && !blockstate.is(Blocks.BLACKSTONE)) {
                return false;
            } else {
                worldgenlevel.setBlock(blockpos, CharredBlocks.EXOTIC_SHROOMLIGHT.get().defaultBlockState(), 2);

                for(int i = 0; i < 1500; ++i) {
                    BlockPos blockpos1 = blockpos.offset(randomsource.nextInt(8) - randomsource.nextInt(8), -randomsource.nextInt(12), randomsource.nextInt(8) - randomsource.nextInt(8));
                    if (worldgenlevel.getBlockState(blockpos1).isAir()) {
                        int j = 0;

                        for(Direction direction : Direction.values()) {
                            if (worldgenlevel.getBlockState(blockpos1.relative(direction)).is(CharredBlocks.EXOTIC_SHROOMLIGHT.get())) {
                                ++j;
                            }

                            if (j > 1) {
                                break;
                            }
                        }

                        if (j == 1) {
                            worldgenlevel.setBlock(blockpos1, CharredBlocks.EXOTIC_SHROOMLIGHT.get().defaultBlockState(), 2);
                        }
                    }
                }

                return true;
            }
        }
    }
}
