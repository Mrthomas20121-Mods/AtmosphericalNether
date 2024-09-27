package mrthomas20121.charred_horizons.data;

import mrthomas20121.charred_horizons.data.loot.CharredBlockLoot;
import mrthomas20121.charred_horizons.data.loot.CharredChestLoot;
import mrthomas20121.charred_horizons.data.loot.CharredEntityLoot;
import mrthomas20121.charred_horizons.data.loot.CharredLoot;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;

public class CharredLootTableData {

    public static LootTableProvider create(PackOutput output) {
        return new LootTableProvider(output, CharredLoot.IMMUTABLE_LOOT_TABLES, List.of(
                new LootTableProvider.SubProviderEntry(CharredChestLoot::new, LootContextParamSets.CHEST),
                new LootTableProvider.SubProviderEntry(CharredEntityLoot::new, LootContextParamSets.ENTITY),
                new LootTableProvider.SubProviderEntry(CharredBlockLoot::new, LootContextParamSets.BLOCK)
        ));
    }
}
