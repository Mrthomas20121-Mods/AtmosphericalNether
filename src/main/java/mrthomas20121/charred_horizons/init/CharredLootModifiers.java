package mrthomas20121.charred_horizons.init;

import com.mojang.serialization.Codec;
import mrthomas20121.charred_horizons.CharredHorizons;
import mrthomas20121.charred_horizons.data.loot.modifier.AddDungeonLootModifier;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CharredLootModifiers {

    public static DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIERS = DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, CharredHorizons.MOD_ID);

    public static RegistryObject<Codec<AddDungeonLootModifier>> ADD_DUNGEON_LOOT = LOOT_MODIFIERS.register("add_dungeon_loot", () -> AddDungeonLootModifier.CODEC);
}
