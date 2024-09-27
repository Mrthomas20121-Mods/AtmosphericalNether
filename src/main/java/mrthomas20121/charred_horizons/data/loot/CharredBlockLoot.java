package mrthomas20121.charred_horizons.data.loot;

import mrthomas20121.charred_horizons.init.CharredBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.Set;
import java.util.function.Supplier;

public class CharredBlockLoot extends BlockLootSubProvider {
    public CharredBlockLoot() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.add(CharredBlocks.BLIGHT_NYLIUM.get(), (block) -> this.createSingleItemTableWithSilkTouch(block, Blocks.NETHERRACK));
        this.add(CharredBlocks.WITHERED_NYLIUM.get(), (block) -> this.createSingleItemTableWithSilkTouch(block, Blocks.NETHERRACK));
        addNetherVinesDropTable(CharredBlocks.DROOPING_VINES.get(), CharredBlocks.DROOPING_VINES_PLANT.get());
        dropSelf(CharredBlocks.EXOTIC_SHROOMLIGHT.get());
        dropSelf(CharredBlocks.BLIGHT_FUNGUS.get());
        dropSelf(CharredBlocks.WITHERED_FUNGUS.get());
        dropSelf(CharredBlocks.BLIGHT_FUNGUS.get());
        dropSelf(CharredBlocks.WITHERED_FUNGUS.get());
        dropSelf(CharredBlocks.BLIGHT_ROOT.get());
        dropSelf(CharredBlocks.BLIGHT_NETHER_WART_BLOCK.get());
        dropSelf(CharredBlocks.WITHERED_NETHER_WART_BLOCK.get());
        dropSelf(CharredBlocks.DROOPING_VINES.get());
        dropSelf(CharredBlocks.DROOPING_VINES_PLANT.get());
        dropSelf(CharredBlocks.BLIGHT_STEM.get());
        dropSelf(CharredBlocks.WITHERED_STEM.get());
        dropSelf(CharredBlocks.BLIGHT_HYPHAE.get());
        dropSelf(CharredBlocks.WITHERED_HYPHAE.get());
        dropSelf(CharredBlocks.STRIPPED_BLIGHT_STEM.get());
        dropSelf(CharredBlocks.STRIPPED_WITHERED_STEM.get());
        dropSelf(CharredBlocks.STRIPPED_BLIGHT_HYPHAE.get());
        dropSelf(CharredBlocks.STRIPPED_WITHERED_HYPHAE.get());
        dropSelf(CharredBlocks.BLIGHT_PLANKS.get());
        dropSelf(CharredBlocks.WITHERED_PLANKS.get());
        dropSelf(CharredBlocks.BLIGHT_SLAB.get());
        dropSelf(CharredBlocks.WITHERED_SLAB.get());
        dropSelf(CharredBlocks.BLIGHT_STAIRS.get());
        dropSelf(CharredBlocks.WITHERED_STAIRS.get());
        dropSelf(CharredBlocks.BLIGHT_PRESSURE_PLATE.get());
        dropSelf(CharredBlocks.WITHERED_PRESSURE_PLATE.get());
        dropSelf(CharredBlocks.BLIGHT_BUTTON.get());
        dropSelf(CharredBlocks.WITHERED_BUTTON.get());
        dropSelf(CharredBlocks.BLIGHT_FENCE.get());
        dropSelf(CharredBlocks.WITHERED_FENCE.get());
        dropSelf(CharredBlocks.BLIGHT_FENCE_GATE.get());
        dropSelf(CharredBlocks.WITHERED_FENCE_GATE.get());
        dropSelf(CharredBlocks.BLIGHT_DOOR.get());
        dropSelf(CharredBlocks.WITHERED_DOOR.get());
        dropSelf(CharredBlocks.BLIGHT_TRAPDOOR.get());
        dropSelf(CharredBlocks.WITHERED_TRAPDOOR.get());
        dropSelf(CharredBlocks.BLIGHT_SIGN.get());
        dropOther(CharredBlocks.BLIGHT_WALL_SIGN.get(), CharredBlocks.BLIGHT_SIGN.get());
        dropSelf(CharredBlocks.WITHERED_SIGN.get());
        dropOther(CharredBlocks.WITHERED_WALL_SIGN.get(), CharredBlocks.WITHERED_SIGN.get());
        dropSelf(CharredBlocks.BLIGHT_HANGING_SIGN.get());
        dropOther(CharredBlocks.BLIGHT_WALL_HANGING_SIGN.get(), CharredBlocks.BLIGHT_HANGING_SIGN.get());
        dropSelf(CharredBlocks.WITHERED_HANGING_SIGN.get());
        dropOther(CharredBlocks.WITHERED_WALL_HANGING_SIGN.get(), CharredBlocks.WITHERED_HANGING_SIGN.get());

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return CharredBlocks.BLOCKS.getEntries().stream().map(Supplier::get).toList();
    }
}
