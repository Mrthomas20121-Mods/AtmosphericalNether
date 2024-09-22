package mrthomas20121.charred_horizons.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.features.NetherFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.NyliumBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class CharredNyliumBlock extends NyliumBlock {

    public CharredNyliumBlock(Properties p_55057_) {
        super(p_55057_);
    }

    /**
     * todo: add blight and withered nylium to this method
     * @param p_221825_
     * @param p_221826_
     * @param p_221827_
     * @param p_221828_
     */
    public void performBonemeal(ServerLevel p_221825_, RandomSource p_221826_, BlockPos p_221827_, BlockState p_221828_) {
        BlockState blockstate = p_221825_.getBlockState(p_221827_);
        BlockPos blockpos = p_221827_.above();
        ChunkGenerator chunkgenerator = p_221825_.getChunkSource().getGenerator();
        Registry<ConfiguredFeature<?, ?>> registry = p_221825_.registryAccess().registryOrThrow(Registries.CONFIGURED_FEATURE);
        if (blockstate.is(Blocks.CRIMSON_NYLIUM)) {
            this.place(registry, NetherFeatures.CRIMSON_FOREST_VEGETATION_BONEMEAL, p_221825_, chunkgenerator, p_221826_, blockpos);
        } else if (blockstate.is(Blocks.WARPED_NYLIUM)) {
            this.place(registry, NetherFeatures.WARPED_FOREST_VEGETATION_BONEMEAL, p_221825_, chunkgenerator, p_221826_, blockpos);
            this.place(registry, NetherFeatures.NETHER_SPROUTS_BONEMEAL, p_221825_, chunkgenerator, p_221826_, blockpos);
            if (p_221826_.nextInt(8) == 0) {
                this.place(registry, NetherFeatures.TWISTING_VINES_BONEMEAL, p_221825_, chunkgenerator, p_221826_, blockpos);
            }
        }

    }

    private void place(Registry<ConfiguredFeature<?, ?>> p_255879_, ResourceKey<ConfiguredFeature<?, ?>> p_256032_, ServerLevel p_255631_, ChunkGenerator p_256445_, RandomSource p_255709_, BlockPos p_256019_) {
        p_255879_.getHolder(p_256032_).ifPresent((p_255920_) -> {
            p_255920_.value().place(p_255631_, p_256445_, p_255709_, p_256019_);
        });
    }
}
