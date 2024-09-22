package mrthomas20121.charred_horizons.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.List;

public class GoldRingItem extends Item implements ICurioItem {

    public GoldRingItem(Properties properties) {
        super(properties);
    }

    @Override
    public List<Component> getSlotsTooltip(List<Component> tooltips, ItemStack stack) {
        tooltips.add(Component.translatable("item.charred_horizons.netherite_ring.effect").withStyle(ChatFormatting.GRAY));
        return ICurioItem.super.getSlotsTooltip(tooltips, stack);
    }

    @Override
    public boolean makesPiglinsNeutral(SlotContext slotContext, ItemStack stack) {
        return true;
    }
}
