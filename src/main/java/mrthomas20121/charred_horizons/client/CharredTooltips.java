package mrthomas20121.charred_horizons.client;

import mrthomas20121.charred_horizons.CharredHorizons;
import mrthomas20121.charred_horizons.init.CharredItems;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CharredHorizons.MOD_ID, value = Dist.CLIENT)
public class CharredTooltips {

    @SubscribeEvent
    public static void itemTooltipEvent(ItemTooltipEvent event) {

        if(event.getItemStack().is(CharredItems.FIERY_BOW.get())) {
            event.getToolTip().add(Component.translatable("item.charred_horizons.fiery_bow.description").withStyle(ChatFormatting.GRAY));
        }
    }
}
