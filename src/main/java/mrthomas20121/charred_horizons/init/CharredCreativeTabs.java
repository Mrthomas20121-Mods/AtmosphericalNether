package mrthomas20121.charred_horizons.init;

import mrthomas20121.charred_horizons.CharredHorizons;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class CharredCreativeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CharredHorizons.MOD_ID);

    public static final RegistryObject<CreativeModeTab> BLOCK_TAB = register("block", () -> new ItemStack(CharredBlocks.BLIGHT_NYLIUM.get()), CharredCreativeTabs::fillBlockTab);
    public static final RegistryObject<CreativeModeTab> ITEM_TAB = register("item", () -> new ItemStack(CharredItems.GOLD_RING.get()), CharredCreativeTabs::fillItemTab);

    private static RegistryObject<CreativeModeTab> register(String name, Supplier<ItemStack> icon, CreativeModeTab.DisplayItemsGenerator displayItems)
    {
        return CREATIVE_TABS.register(name, () -> CreativeModeTab.builder()
                .icon(icon)
                .title(Component.translatable("creative_tab.charred_horizons." + name))
                .displayItems(displayItems)
                .build());
    }

    public static void fillItemTab(CreativeModeTab.ItemDisplayParameters parameters, CreativeModeTab.Output out) {
        out.accept(CharredItems.SULFUR_DUST.get());
        out.accept(CharredItems.SULFURIC_BONE.get());
        out.accept(CharredItems.SULFURIC_BONE_MEAL.get());
        out.accept(CharredItems.FIERY_STRING.get());
        out.accept(CharredItems.FIERY_BOW.get());
        out.accept(CharredItems.GOLD_RING.get());
        out.accept(CharredItems.BLIGHT_RING.get());
        out.accept(CharredItems.MYSTERIOUS_CHARM.get());
        out.accept(CharredItems.WITHERED_SWORD.get());
        out.accept(CharredItems.BLAZE_SLAYER.get());
        out.accept(CharredBlocks.BLIGHT_ROOT.get());
        out.accept(CharredBlocks.BLIGHT_FUNGUS.get());
        out.accept(CharredBlocks.WITHERED_FUNGUS.get());
        out.accept(CharredItems.SULFURIC_SKELETON_EGG.get());
        out.accept(CharredItems.FIERY_SPIDER_EGG.get());
    }

    public static void fillBlockTab(CreativeModeTab.ItemDisplayParameters parameters, CreativeModeTab.Output out) {
        out.accept(CharredBlocks.BLIGHT_NYLIUM.get());
        out.accept(CharredBlocks.BLIGHT_NETHER_WART_BLOCK.get());
        out.accept(CharredBlocks.BLIGHT_STEM.get());
        out.accept(CharredBlocks.BLIGHT_HYPHAE.get());
        out.accept(CharredBlocks.STRIPPED_BLIGHT_STEM.get());
        out.accept(CharredBlocks.STRIPPED_BLIGHT_HYPHAE.get());
        out.accept(CharredBlocks.BLIGHT_PLANKS.get());
        out.accept(CharredBlocks.BLIGHT_SLAB.get());
        out.accept(CharredBlocks.BLIGHT_STAIRS.get());
        out.accept(CharredBlocks.BLIGHT_FENCE.get());
        out.accept(CharredBlocks.BLIGHT_FENCE_GATE.get());
        out.accept(CharredBlocks.BLIGHT_TRAPDOOR.get());
        out.accept(CharredBlocks.BLIGHT_DOOR.get());
        out.accept(CharredBlocks.BLIGHT_BUTTON.get());
        out.accept(CharredBlocks.BLIGHT_SIGN.get());
        out.accept(CharredBlocks.BLIGHT_HANGING_SIGN.get());

        out.accept(CharredBlocks.WITHERED_NYLIUM.get());
        out.accept(CharredBlocks.WITHERED_NETHER_WART_BLOCK.get());
        out.accept(CharredBlocks.WITHERED_STEM.get());
        out.accept(CharredBlocks.WITHERED_HYPHAE.get());
        out.accept(CharredBlocks.STRIPPED_WITHERED_STEM.get());
        out.accept(CharredBlocks.STRIPPED_WITHERED_HYPHAE.get());
        out.accept(CharredBlocks.WITHERED_PLANKS.get());
        out.accept(CharredBlocks.WITHERED_SLAB.get());
        out.accept(CharredBlocks.WITHERED_STAIRS.get());
        out.accept(CharredBlocks.WITHERED_FENCE.get());
        out.accept(CharredBlocks.WITHERED_FENCE_GATE.get());
        out.accept(CharredBlocks.WITHERED_TRAPDOOR.get());
        out.accept(CharredBlocks.WITHERED_DOOR.get());
        out.accept(CharredBlocks.WITHERED_BUTTON.get());
        out.accept(CharredBlocks.WITHERED_SIGN.get());
        out.accept(CharredBlocks.WITHERED_HANGING_SIGN.get());
        out.accept(CharredBlocks.IMPROVED_FARMLAND_BLOCK.get());
    }
}
