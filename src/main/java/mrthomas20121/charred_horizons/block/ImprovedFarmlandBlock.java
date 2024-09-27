package mrthomas20121.charred_horizons.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.FarmBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.IPlantable;

public class ImprovedFarmlandBlock extends FarmBlock {

    public ImprovedFarmlandBlock(Properties p_53247_) {
        super(p_53247_);
    }

    @Override
    public boolean canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, Direction facing, IPlantable plantable) {
        return true;
    }

    @Override
    public boolean canSurvive(BlockState p_53272_, LevelReader p_53273_, BlockPos p_53274_) {
        return true;
    }

    @Override
    public boolean isFertile(BlockState state, BlockGetter level, BlockPos pos) {
        return true;
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {

        BlockPos above = pos.above();
        BlockState aboveState = level.getBlockState(above);
        if(aboveState.getBlock() instanceof IPlantable && aboveState.isRandomlyTicking()) {
            for(int i = 0; i<5; i++) {
                aboveState.randomTick(level, above, random);
            }
        }
    }

    @Override
    public void fallOn(Level level, BlockState state, BlockPos pos, Entity entity, float fall) {
        if(!state.is(this)) {
            super.fallOn(level, state, pos, entity, fall);
        }
    }
}
