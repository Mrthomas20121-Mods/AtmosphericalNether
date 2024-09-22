package mrthomas20121.charred_horizons.item;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import mrthomas20121.charred_horizons.CharredHorizons;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.UUID;

public class BlightRingItem extends Item implements ICurioItem {

    public BlightRingItem(Properties properties) {
        super(properties);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> atts = LinkedHashMultimap.create();

        atts.put(Attributes.ARMOR_TOUGHNESS,
                new AttributeModifier(uuid, CharredHorizons.MOD_ID + ":armor_toughness_ring", 2,
                        AttributeModifier.Operation.ADDITION));
        atts.put(Attributes.ARMOR,
                new AttributeModifier(uuid, CharredHorizons.MOD_ID + ":armor_ring", 3,
                        AttributeModifier.Operation.ADDITION));

        return atts;
    }
}
