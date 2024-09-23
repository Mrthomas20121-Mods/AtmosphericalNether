package mrthomas20121.charred_horizons.block_entity;

import mrthomas20121.charred_horizons.init.CharredBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.HangingSignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class WitheredHangingSignBlockEntity extends HangingSignBlockEntity {

    public WitheredHangingSignBlockEntity(BlockPos pos, BlockState state) {
        super(/*this.getType(),*/ pos, state);
    }

    @Override
    public BlockEntityType<?> getType() {
        return CharredBlockEntities.WITHERED_HANGING_SIGN.get();
    }
}
