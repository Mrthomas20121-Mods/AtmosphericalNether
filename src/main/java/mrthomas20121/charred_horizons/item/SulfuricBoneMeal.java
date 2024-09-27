package mrthomas20121.charred_horizons.item;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class SulfuricBoneMeal extends BoneMealItem {

    public SulfuricBoneMeal() {
        super(new Properties().rarity(Rarity.UNCOMMON));
    }

    public InteractionResult useOn(UseOnContext p_40637_) {
        Level level = p_40637_.getLevel();
        BlockPos blockpos = p_40637_.getClickedPos();
        BlockPos blockpos1 = blockpos.relative(p_40637_.getClickedFace());
        if (applyBonemeal(p_40637_.getItemInHand(), level, blockpos, p_40637_.getPlayer())) {
            if (!level.isClientSide) {
                level.levelEvent(1505, blockpos, 0);
            }

            if(applyBonemeal(p_40637_.getItemInHand(), level, blockpos, p_40637_.getPlayer())) {
                if (!level.isClientSide) {
                    level.levelEvent(1505, blockpos, 0);
                }
            };

            return InteractionResult.sidedSuccess(level.isClientSide);
        } else {
            BlockState blockstate = level.getBlockState(blockpos);
            boolean flag = blockstate.isFaceSturdy(level, blockpos, p_40637_.getClickedFace());
            if (flag && growWaterPlant(p_40637_.getItemInHand(), level, blockpos1, p_40637_.getClickedFace())) {
                if (!level.isClientSide) {
                    level.levelEvent(1505, blockpos1, 0);
                }

                return InteractionResult.sidedSuccess(level.isClientSide);
            } else {
                return InteractionResult.PASS;
            }
        }
    }
}
