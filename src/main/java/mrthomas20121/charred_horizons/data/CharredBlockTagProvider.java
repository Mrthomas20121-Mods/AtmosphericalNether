package mrthomas20121.charred_horizons.data;

import mrthomas20121.charred_horizons.CharredHorizons;
import mrthomas20121.charred_horizons.init.CharredBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class CharredBlockTagProvider extends BlockTagsProvider {

    public CharredBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, CharredHorizons.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.INFINIBURN_NETHER)
                .add(CharredBlocks.BLIGHT_NYLIUM.get(), CharredBlocks.WITHERED_NYLIUM.get());
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(CharredBlocks.BLIGHT_NYLIUM.get(), CharredBlocks.WITHERED_NYLIUM.get());
        tag(BlockTags.MINEABLE_WITH_HOE)
                .add(CharredBlocks.BLIGHT_NETHER_WART.get(), CharredBlocks.WITHERED_NETHER_WART.get());

        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(
                        CharredBlocks.BLIGHT_STEM.get(),
                        CharredBlocks.WITHERED_STEM.get()
                );

    }
}
