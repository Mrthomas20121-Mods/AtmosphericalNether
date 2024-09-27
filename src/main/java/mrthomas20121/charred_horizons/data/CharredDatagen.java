package mrthomas20121.charred_horizons.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;
import net.minecraftforge.data.event.GatherDataEvent;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CharredDatagen {

    public static void init(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        PackOutput packOutput = generator.getPackOutput();

        CharredBlockTagProvider tags = new CharredBlockTagProvider(packOutput, lookupProvider, fileHelper);
        generator.addProvider(event.includeServer(), tags);
        generator.addProvider(event.includeServer(), new CharredItemTagProvider(packOutput, lookupProvider, tags.contentsGetter(), fileHelper));
        generator.addProvider(event.includeServer(), new CharredEntityTagsProvider(packOutput, lookupProvider, fileHelper));
        generator.addProvider(event.includeServer(), new CharredCurioDataProvider(packOutput, fileHelper, lookupProvider));
        generator.addProvider(event.includeServer(), new CharredRecipeProvider(packOutput));
        // can't get biome tags to work so i'm adding them manually
        //generator.addProvider(event.includeServer(), new CharredBiomeTagsProvider(packOutput, lookupProvider, fileHelper));
        generator.addProvider(event.includeServer(), new CharredRegistrySets(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(), CharredLootTableData.create(packOutput));
        generator.addProvider(event.includeServer(), new CharredLootModifierProvider(packOutput));
        generator.addProvider(event.includeServer(), new ForgeAdvancementProvider(packOutput, lookupProvider, fileHelper, List.of(new CharredAdvancementProvider())));

        generator.addProvider(event.includeClient(), new CharredBlockstateProvider(packOutput, fileHelper));
        generator.addProvider(event.includeClient(), new CharredLangProvider(packOutput));
        generator.addProvider(event.includeClient(), new CharredItemModelProvider(packOutput, fileHelper));

    }
}
