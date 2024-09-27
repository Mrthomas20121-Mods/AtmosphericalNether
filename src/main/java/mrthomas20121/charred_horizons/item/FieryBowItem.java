package mrthomas20121.charred_horizons.item;

import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.Rarity;

public class FieryBowItem extends BowItem {
    public FieryBowItem() {
        super(new Properties().stacksTo(1).rarity(Rarity.UNCOMMON));
    }

    @Override
    public AbstractArrow customArrow(AbstractArrow arrow) {
        AbstractArrow abstractArrow = super.customArrow(arrow);
        abstractArrow.setCritArrow(true);
        abstractArrow.setSecondsOnFire(10);
        return abstractArrow;
    }

    @Override
    public int getDefaultProjectileRange() {
        return 18;
    }
}
