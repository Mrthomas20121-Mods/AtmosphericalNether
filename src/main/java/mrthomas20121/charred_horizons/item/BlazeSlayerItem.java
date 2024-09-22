package mrthomas20121.charred_horizons.item;

import mrthomas20121.charred_horizons.CharredHorizons;
import mrthomas20121.charred_horizons.init.CharredItems;
import mrthomas20121.charred_horizons.init.CharredTags;
import mrthomas20121.charred_horizons.init.CharredTiers;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CharredHorizons.MOD_ID)
public class BlazeSlayerItem extends SwordItem {
    public BlazeSlayerItem() {
        super(CharredTiers.BLAZE_SLAYER, 3, -2.4f, new Properties().stacksTo(1).rarity(Rarity.RARE));
    }

    /**
     * Deal 32 more damage to blazes.
     * @param event
     */
    @SubscribeEvent
    public static void onLivingDamage(LivingDamageEvent event) {
        LivingEntity target = event.getEntity();
        DamageSource damageSource = event.getSource();
        // the base damage
        float damage = event.getAmount();
        if (isCorrectTool(target, damageSource)) {
            event.setAmount(damage + 32F);
        }
    }

    private static boolean isCorrectTool(LivingEntity target, DamageSource source) {
        if (source.getDirectEntity() instanceof LivingEntity attacker) {
            if (attacker.getHealth() == attacker.getMaxHealth()) {
                if (target.getType().is(CharredTags.Entities.BLAZES)) {
                    return attacker.getMainHandItem().is(CharredItems.BLAZE_SLAYER.get());
                }
            }
        }
        return false;
    }
}
