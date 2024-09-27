package mrthomas20121.charred_horizons.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
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
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        super.tick(state, level, pos, random);

        BlockPos above = pos.above();
        if(random.nextFloat() > 0.5f && level.getBlockState(above) instanceof BonemealableBlock) {
            level.getBlockState(above).randomTick(level, above, random);

            level.scheduleTick(above, this, random.nextInt(10));
        }
    }

    @Override
    public void fallOn(Level level, BlockState state, BlockPos pos, Entity entity, float fall) {
        if(!state.is(this)) {
            super.fallOn(level, state, pos, entity, fall);
        }
    }
}
