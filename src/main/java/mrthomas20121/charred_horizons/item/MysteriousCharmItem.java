package mrthomas20121.charred_horizons.item;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import mrthomas20121.charred_horizons.CharredHorizons;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.ForgeMod;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.UUID;

public class MysteriousCharmItem extends Item implements ICurioItem {

    public MysteriousCharmItem(Properties properties) {
        super(properties);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> atts = LinkedHashMultimap.create();

        atts.put(ForgeMod.STEP_HEIGHT_ADDITION.get(),
                new AttributeModifier(uuid, CharredHorizons.MOD_ID + ":step_height", 1,
                        AttributeModifier.Operation.ADDITION));

        return atts;
    }
}
