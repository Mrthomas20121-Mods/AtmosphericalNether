package mrthomas20121.charred_horizons.block;

import mrthomas20121.charred_horizons.init.CharredBlocks;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GrowingPlantBodyBlock;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.NetherVines;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;

public class DroopingVinePlantBlock extends GrowingPlantBodyBlock {

    protected static final VoxelShape SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);

    public DroopingVinePlantBlock(Properties properties) {
        super(properties, Direction.DOWN, SHAPE, false);
    }

    protected int getBlocksToGrowWhenBonemealed(RandomSource source) {
        return NetherVines.getBlocksToGrowWhenBonemealed(source);
    }

    protected GrowingPlantHeadBlock getHeadBlock() {
        return CharredBlocks.DROOPING_VINES.get();
    }

    protected boolean canGrowInto(BlockState blockState) {
        return NetherVines.isValidGrowthState(blockState);
    }
}
