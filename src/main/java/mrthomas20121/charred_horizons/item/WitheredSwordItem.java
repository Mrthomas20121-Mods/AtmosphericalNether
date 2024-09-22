package mrthomas20121.charred_horizons.item;

import mrthomas20121.charred_horizons.init.CharredTiers;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SwordItem;

public class WitheredSwordItem extends SwordItem {
    public WitheredSwordItem() {
        super(CharredTiers.WITHERED, 3, -2.4f, new Properties().stacksTo(1).rarity(Rarity.RARE));
    }
}
