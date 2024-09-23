package mrthomas20121.charred_horizons.block_entity;

import mrthomas20121.charred_horizons.init.CharredBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class BlightSignBlockEntity extends SignBlockEntity {

    public BlightSignBlockEntity(BlockPos p_155700_, BlockState p_155701_) {
        super(/*this.getType(),*/ p_155700_, p_155701_);
    }

    @Override
    public BlockEntityType<?> getType() {
        return CharredBlockEntities.BLIGHT_SIGN.get();
    }
}
