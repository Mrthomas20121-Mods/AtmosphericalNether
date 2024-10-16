package mrthomas20121.charred_horizons.data;

import mrthomas20121.charred_horizons.CharredHorizons;
import mrthomas20121.charred_horizons.init.CharredBlocks;
import mrthomas20121.charred_horizons.init.CharredTags;
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

        tag(BlockTags.CLIMBABLE).add(CharredBlocks.DROOPING_VINES.get(), CharredBlocks.DROOPING_VINES_PLANT.get(),
                CharredBlocks.MYSTIC_VINES.get(), CharredBlocks.MYSTIC_VINES_PLANT.get());
        tag(BlockTags.MUSHROOM_GROW_BLOCK).add(CharredBlocks.BLIGHT_NYLIUM.get(), CharredBlocks.WITHERED_NYLIUM.get(), CharredBlocks.MYSTIC_NYLIUM.get());
        tag(BlockTags.NYLIUM)
                .add(CharredBlocks.BLIGHT_NYLIUM.get(), CharredBlocks.WITHERED_NYLIUM.get(), CharredBlocks.MYSTIC_NYLIUM.get());
        tag(BlockTags.INFINIBURN_NETHER)
                .add(CharredBlocks.BLIGHT_NYLIUM.get(), CharredBlocks.WITHERED_NYLIUM.get(), CharredBlocks.MYSTIC_NYLIUM.get());
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(CharredBlocks.BLIGHT_NYLIUM.get(), CharredBlocks.WITHERED_NYLIUM.get(), CharredBlocks.MYSTIC_NYLIUM.get());
        tag(BlockTags.MINEABLE_WITH_HOE)
                .add(
                        CharredBlocks.BLIGHT_NETHER_WART_BLOCK.get(),
                        CharredBlocks.WITHERED_NETHER_WART_BLOCK.get(),
                        CharredBlocks.EXOTIC_SHROOMLIGHT.get(),
                        CharredBlocks.MYSTIC_MUSHROOM_BLOCK.get(),
                        CharredBlocks.MYSTIC_MUSHROOM_STEM.get()
                );

        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(
                        CharredBlocks.BLIGHT_STEM.get(),
                        CharredBlocks.BLIGHT_HYPHAE.get(),
                        CharredBlocks.STRIPPED_BLIGHT_STEM.get(),
                        CharredBlocks.STRIPPED_BLIGHT_HYPHAE.get(),
                        CharredBlocks.BLIGHT_PLANKS.get(),
                        CharredBlocks.BLIGHT_SLAB.get(),
                        CharredBlocks.BLIGHT_STAIRS.get(),
                        CharredBlocks.BLIGHT_FENCE.get(),
                        CharredBlocks.BLIGHT_FENCE_GATE.get(),
                        CharredBlocks.BLIGHT_PRESSURE_PLATE.get(),
                        CharredBlocks.BLIGHT_BUTTON.get(),
                        CharredBlocks.BLIGHT_TRAPDOOR.get(),
                        CharredBlocks.BLIGHT_DOOR.get(),
                        CharredBlocks.BLIGHT_SIGN.get(),
                        CharredBlocks.BLIGHT_HANGING_SIGN.get(),
                        CharredBlocks.WITHERED_STEM.get(),
                        CharredBlocks.WITHERED_HYPHAE.get(),
                        CharredBlocks.STRIPPED_WITHERED_STEM.get(),
                        CharredBlocks.STRIPPED_WITHERED_HYPHAE.get(),
                        CharredBlocks.WITHERED_PLANKS.get(),
                        CharredBlocks.WITHERED_SLAB.get(),
                        CharredBlocks.WITHERED_STAIRS.get(),
                        CharredBlocks.WITHERED_FENCE.get(),
                        CharredBlocks.WITHERED_FENCE_GATE.get(),
                        CharredBlocks.WITHERED_PRESSURE_PLATE.get(),
                        CharredBlocks.WITHERED_BUTTON.get(),
                        CharredBlocks.WITHERED_TRAPDOOR.get(),
                        CharredBlocks.WITHERED_DOOR.get(),
                        CharredBlocks.WITHERED_SIGN.get(),
                        CharredBlocks.WITHERED_HANGING_SIGN.get()
                );

        tag(BlockTags.PLANKS)
                .add(
                        CharredBlocks.BLIGHT_PLANKS.get(),
                        CharredBlocks.WITHERED_PLANKS.get()
                );

        tag(BlockTags.PLANKS)
                .add(
                        CharredBlocks.BLIGHT_PLANKS.get(),
                        CharredBlocks.WITHERED_PLANKS.get()
                );

        tag(BlockTags.SLABS)
                .add(
                        CharredBlocks.BLIGHT_SLAB.get(),
                        CharredBlocks.WITHERED_SLAB.get()
                );

        tag(BlockTags.STAIRS)
                .add(
                        CharredBlocks.BLIGHT_STAIRS.get(),
                        CharredBlocks.WITHERED_STAIRS.get()
                );

        tag(BlockTags.WOODEN_FENCES)
                .add(
                        CharredBlocks.BLIGHT_FENCE.get(),
                        CharredBlocks.WITHERED_FENCE.get()
                );

        tag(BlockTags.FENCE_GATES)
                .add(
                        CharredBlocks.BLIGHT_FENCE_GATE.get(),
                        CharredBlocks.WITHERED_FENCE_GATE.get()
                );

        tag(BlockTags.STANDING_SIGNS)
                .add(
                        CharredBlocks.BLIGHT_SIGN.get(),
                        CharredBlocks.WITHERED_SIGN.get()
                );

        tag(BlockTags.WALL_SIGNS)
                .add(
                        CharredBlocks.BLIGHT_WALL_SIGN.get(),
                        CharredBlocks.WITHERED_WALL_SIGN.get()
                );

        tag(BlockTags.WALL_HANGING_SIGNS)
                .add(
                        CharredBlocks.BLIGHT_WALL_HANGING_SIGN.get(),
                        CharredBlocks.WITHERED_WALL_HANGING_SIGN.get()
                );

        tag(BlockTags.CEILING_HANGING_SIGNS)
                .add(
                        CharredBlocks.BLIGHT_HANGING_SIGN.get(),
                        CharredBlocks.WITHERED_HANGING_SIGN.get()
                );

        tag(CharredTags.Blocks.LOGS_BLIGHT)
                .add(
                        CharredBlocks.BLIGHT_STEM.get(),
                        CharredBlocks.BLIGHT_HYPHAE.get(),
                        CharredBlocks.STRIPPED_BLIGHT_STEM.get(),
                        CharredBlocks.STRIPPED_BLIGHT_HYPHAE.get()
                );

        tag(CharredTags.Blocks.LOGS_WITHERED)
                .add(
                        CharredBlocks.WITHERED_STEM.get(),
                        CharredBlocks.WITHERED_HYPHAE.get(),
                        CharredBlocks.STRIPPED_WITHERED_STEM.get(),
                        CharredBlocks.STRIPPED_WITHERED_HYPHAE.get()
                );
    }
}
