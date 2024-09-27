package mrthomas20121.charred_horizons.item;

import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;

public class FieryBowItem extends BowItem {
    public FieryBowItem() {
        super(new Properties().stacksTo(1).rarity(Rarity.UNCOMMON));
    }

    @Override
    public AbstractArrow customArrow(AbstractArrow arrow) {
        AbstractArrow abstractArrow = super.customArrow(arrow);
        abstractArrow.setSecondsOnFire(100);
        return abstractArrow;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return super.canApplyAtEnchantingTable(stack, enchantment) && !enchantment.equals(Enchantments.FLAMING_ARROWS);
    }

    @Override
    public int getDefaultProjectileRange() {
        return 18;
    }
}
