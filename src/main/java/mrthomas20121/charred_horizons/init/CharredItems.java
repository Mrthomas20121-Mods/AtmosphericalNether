package mrthomas20121.charred_horizons.init;

import mrthomas20121.charred_horizons.CharredHorizons;
import mrthomas20121.charred_horizons.item.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SignItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CharredItems {

    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, CharredHorizons.MOD_ID);

    public static RegistryObject<SignItem> BLIGHT_SIGN = ITEMS.register("blight_sign", () -> new SignItem(new Item.Properties().stacksTo(16), CharredBlocks.BLIGHT_SIGN.get(), CharredBlocks.BLIGHT_WALL_SIGN.get()));
    public static RegistryObject<SignItem> BLIGHT_HANGING_SIGN = ITEMS.register("blight_hanging_sign", () -> new HangingSignItem(CharredBlocks.BLIGHT_HANGING_SIGN.get(), CharredBlocks.BLIGHT_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));
    public static RegistryObject<SignItem> WITHERED_SIGN = ITEMS.register("withered_sign", () -> new SignItem(new Item.Properties().stacksTo(16), CharredBlocks.WITHERED_SIGN.get(), CharredBlocks.WITHERED_WALL_SIGN.get()));
    public static RegistryObject<SignItem> WITHERED_HANGING_SIGN = ITEMS.register("withered_hanging_sign", () -> new HangingSignItem(CharredBlocks.WITHERED_HANGING_SIGN.get(), CharredBlocks.WITHERED_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));

    public static RegistryObject<GoldRingItem> GOLD_RING = ITEMS.register("gold_ring", () -> new GoldRingItem(new Item.Properties().stacksTo(1).rarity(Rarity.RARE)));
    public static RegistryObject<BlightRingItem> BLIGHT_RING = ITEMS.register("blight_ring", () -> new BlightRingItem(new Item.Properties().stacksTo(1).rarity(Rarity.RARE)));

    public static RegistryObject<MysteriousCharmItem> MYSTERIOUS_CHARM = ITEMS.register("mysterious_charm", () -> new MysteriousCharmItem(new Item.Properties().stacksTo(1).rarity(Rarity.RARE)));
    public static RegistryObject<WitheredSwordItem> WITHERED_SWORD = ITEMS.register("withered_sword", WitheredSwordItem::new);
    public static RegistryObject<BlazeSlayerItem> BLAZE_SLAYER = ITEMS.register("blaze_slayer", BlazeSlayerItem::new);
}
