package mrthomas20121.charred_horizons.block;

import mrthomas20121.charred_horizons.init.CharredBlocks;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.NetherVines;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;

public class DroopingVineBlock extends GrowingPlantHeadBlock {

    protected static final VoxelShape SHAPE = Block.box(4.0D, 9.0D, 4.0D, 12.0D, 16.0D, 12.0D);

    public DroopingVineBlock(BlockBehaviour.Properties properties) {
        super(properties, Direction.DOWN, SHAPE, false, 0.1D);
    }

    protected int getBlocksToGrowWhenBonemealed(RandomSource source) {
        return NetherVines.getBlocksToGrowWhenBonemealed(source);
    }

    protected Block getBodyBlock() {
        return CharredBlocks.DROOPING_VINES_PLANT.get();
    }

    protected boolean canGrowInto(BlockState blockState) {
        return NetherVines.isValidGrowthState(blockState);
    }
}
