package mrthomas20121.charred_horizons.data;

import mrthomas20121.charred_horizons.CharredHorizons;
import mrthomas20121.charred_horizons.init.CharredBlocks;
import mrthomas20121.charred_horizons.init.CharredItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class CharredItemModelProvider extends ItemModelProvider {

    public CharredItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, CharredHorizons.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(CharredItems.GOLD_RING.get());
        basicItem(CharredItems.BLIGHT_RING.get());
        basicItem(CharredItems.MYSTERIOUS_CHARM.get());

        itemBlock(CharredBlocks.BLIGHT_NYLIUM.get());
        itemBlock(CharredBlocks.WITHERED_NYLIUM.get());

        itemBlock(CharredBlocks.BLIGHT_NETHER_WART.get());
        itemBlock(CharredBlocks.WITHERED_NETHER_WART.get());

        itemBlock(CharredBlocks.BLIGHT_STEM.get());
        itemBlock(CharredBlocks.WITHERED_STEM.get());
    }

    public void itemBlock(Block block) {
        this.withExistingParent(this.blockName(block), modLoc("block/"+this.blockName(block)));
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
