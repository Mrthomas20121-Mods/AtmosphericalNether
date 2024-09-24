package mrthomas20121.charred_horizons.data;

import mrthomas20121.charred_horizons.CharredHorizons;
import mrthomas20121.charred_horizons.init.CharredBlocks;
import mrthomas20121.charred_horizons.init.CharredItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

public class CharredItemModelProvider extends ItemModelProvider {

    public CharredItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, CharredHorizons.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(CharredItems.GOLD_RING.get());
        basicItem(CharredItems.BLIGHT_RING.get());
        basicItem(CharredItems.MYSTERIOUS_CHARM.get());

        handheld(CharredItems.BLAZE_SLAYER.get());
        handheld(CharredItems.WITHERED_SWORD.get());

        basicItemBlock(CharredBlocks.BLIGHT_ROOT.get());
        basicItemBlock(CharredBlocks.BLIGHT_FUNGUS.get());
        basicItemBlock(CharredBlocks.WITHERED_FUNGUS.get());

        itemBlock(CharredBlocks.EXOTIC_SHROOMLIGHT.get());
        basicItem(CharredItems.BLIGHT_SIGN.get());
        basicItem(CharredItems.BLIGHT_HANGING_SIGN.get());
        basicItem(CharredItems.WITHERED_SIGN.get());
        basicItem(CharredItems.WITHERED_HANGING_SIGN.get());

        itemBlock(CharredBlocks.BLIGHT_NYLIUM.get());
        itemBlock(CharredBlocks.WITHERED_NYLIUM.get());

        itemBlock(CharredBlocks.BLIGHT_PLANKS.get());
        itemBlock(CharredBlocks.WITHERED_PLANKS.get());

        itemBlock(CharredBlocks.BLIGHT_SLAB.get());
        itemBlock(CharredBlocks.BLIGHT_STAIRS.get());
        itemBlock(CharredBlocks.WITHERED_SLAB.get());
        itemBlock(CharredBlocks.WITHERED_STAIRS.get());
        trapdoorItem(CharredBlocks.BLIGHT_TRAPDOOR.get());
        trapdoorItem(CharredBlocks.WITHERED_TRAPDOOR.get());

        buttonInventory(blockName(CharredBlocks.BLIGHT_BUTTON.get()), new ResourceLocation("charred_horizons:block/blight_planks"));
        buttonInventory(blockName(CharredBlocks.WITHERED_BUTTON.get()), new ResourceLocation("charred_horizons:block/withered_planks"));
        itemBlock(CharredBlocks.BLIGHT_PRESSURE_PLATE.get());
        itemBlock(CharredBlocks.WITHERED_PRESSURE_PLATE.get());

        basicItem(CharredBlocks.BLIGHT_DOOR.get().asItem());
        basicItem(CharredBlocks.WITHERED_DOOR.get().asItem());

        fenceInventory(blockName(CharredBlocks.BLIGHT_FENCE.get()), new ResourceLocation("charred_horizons:block/blight_planks"));
        fenceInventory(blockName(CharredBlocks.WITHERED_FENCE.get()), new ResourceLocation("charred_horizons:block/withered_planks"));

        itemBlock(CharredBlocks.BLIGHT_FENCE_GATE.get());
        itemBlock(CharredBlocks.WITHERED_FENCE_GATE.get());

        itemBlock(CharredBlocks.BLIGHT_NETHER_WART.get());
        itemBlock(CharredBlocks.WITHERED_NETHER_WART.get());

        itemBlock(CharredBlocks.BLIGHT_STEM.get());
        itemBlock(CharredBlocks.WITHERED_STEM.get());
    }

    public void itemBlock(Block block) {
        this.withExistingParent(this.blockName(block), modLoc("block/"+this.blockName(block)));
    }

    public void trapdoorItem(Block block) {
        this.withExistingParent(this.blockName(block), modLoc("block/"+this.blockName(block)+"_bottom"));
    }

    public ItemModelBuilder handheld(Item item)
    {
        ResourceLocation loc = ForgeRegistries.ITEMS.getKey(item);
        return getBuilder(loc.toString())
                .parent(new ModelFile.UncheckedModelFile("item/handheld"))
                .texture("layer0", new ResourceLocation(loc.getNamespace(), "item/" + loc.getPath()));
    }

    public ItemModelBuilder basicItemBlock(Block item)
    {
        return basicItemBlock(Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(item)));
    }

    public ItemModelBuilder basicItemBlock(ResourceLocation item)
    {
        return getBuilder(item.toString())
                .parent(new ModelFile.UncheckedModelFile("item/generated"))
                .texture("layer0", new ResourceLocation(item.getNamespace(), "block/" + item.getPath()));
    }

    public String blockName(Block block) {
        ResourceLocation location = ForgeRegistries.BLOCKS.getKey(block);
        if (location != null) {
            return location.getPath();
        } else {
            throw new IllegalStateException("Unknown block: " + block.toString());
        }
    }
}
