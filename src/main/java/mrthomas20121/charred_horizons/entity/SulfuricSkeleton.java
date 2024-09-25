package mrthomas20121.charred_horizons.entity;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

public class SulfuricSkeleton extends AbstractSkeleton {

    public SulfuricSkeleton(EntityType<SulfuricSkeleton> p_33570_, Level p_33571_) {
        super(p_33570_, p_33571_);
    }

    @Override
    protected SoundEvent getStepSound() {
        return SoundEvents.SKELETON_STEP;
    }

    protected AbstractArrow getArrow(ItemStack p_33846_, float p_33847_) {
        AbstractArrow abstractarrow = super.getArrow(p_33846_, p_33847_);
        if (abstractarrow instanceof Arrow) {
            ((Arrow)abstractarrow).addEffect(new MobEffectInstance(MobEffects.POISON, 600));
        }

        return abstractarrow;
    }

    protected SoundEvent getHurtSound(DamageSource p_33579_) {
        return SoundEvents.SKELETON_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.SKELETON_DEATH;
    }
}
