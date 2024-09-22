package mrthomas20121.charred_horizons.block_entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.HangingSignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class CharredHangingSignBlockEntity extends HangingSignBlockEntity {

    public CharredHangingSignBlockEntity(BlockPos pos, BlockState state) {
        super(/*this.getType(),*/ pos, state);
    }
}
