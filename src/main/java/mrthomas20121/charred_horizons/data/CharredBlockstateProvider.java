package mrthomas20121.charred_horizons.data;

import mrthomas20121.charred_horizons.CharredHorizons;
import mrthomas20121.charred_horizons.init.CharredBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class CharredBlockstateProvider extends BlockStateProvider {

    public CharredBlockstateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, CharredHorizons.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(CharredBlocks.BLIGHT_NYLIUM.get(), models().cubeBottomTop(
                CharredHorizons.MOD_ID+":blight_nylium",
                new ResourceLocation(CharredHorizons.MOD_ID, "block/blight_nylium_side"),
                new ResourceLocation("minecraft:block/netherrack"),
                new ResourceLocation(CharredHorizons.MOD_ID, "block/blight_nylium")));

        simpleBlock(CharredBlocks.WITHERED_NYLIUM.get(), models().cubeBottomTop(
                CharredHorizons.MOD_ID+":withered_nylium",
                new ResourceLocation(CharredHorizons.MOD_ID, "block/withered_nylium_side"),
                new ResourceLocation("minecraft:block/netherrack"),
                new ResourceLocation(CharredHorizons.MOD_ID, "block/withered_nylium")));

        simpleBlock(CharredBlocks.BLIGHT_NETHER_WART.get());
        simpleBlock(CharredBlocks.WITHERED_NETHER_WART.get());

        logBlock(CharredBlocks.BLIGHT_STEM.get());
        logBlock(CharredBlocks.WITHERED_STEM.get());
    }
}
