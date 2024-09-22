package mrthomas20121.charred_horizons.block.sign;

import mrthomas20121.charred_horizons.block_entity.CharredHangingSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class CharredCeilingHangingSignBlock extends CeilingHangingSignBlock {

    public CharredCeilingHangingSignBlock(Properties p_56990_, WoodType p_56991_) {
        super(p_56990_, p_56991_);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new CharredHangingSignBlockEntity(pos, state);
    }
}
