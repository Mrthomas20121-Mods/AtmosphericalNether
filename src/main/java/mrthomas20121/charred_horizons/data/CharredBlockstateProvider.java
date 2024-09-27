package mrthomas20121.charred_horizons.data;

import mrthomas20121.charred_horizons.CharredHorizons;
import mrthomas20121.charred_horizons.init.CharredBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.WallHangingSignBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class CharredBlockstateProvider extends BlockStateProvider {

    public CharredBlockstateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, CharredHorizons.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        farmland(CharredBlocks.IMPROVED_FARMLAND_BLOCK.get(),
                new ResourceLocation(CharredHorizons.MOD_ID, "block/improved_dirt"),
                new ResourceLocation(CharredHorizons.MOD_ID, "block/improved_farmland"));
        simpleBlock(CharredBlocks.EXOTIC_SHROOMLIGHT.get());

        simpleBlock(CharredBlocks.DROOPING_VINES.get(), models().cross(CharredHorizons.MOD_ID+":drooping_vines",
                blockTexture(CharredBlocks.DROOPING_VINES.get())));

        simpleBlock(CharredBlocks.DROOPING_VINES_PLANT.get(), models().cross(CharredHorizons.MOD_ID+":drooping_vines_plant",
                blockTexture(CharredBlocks.DROOPING_VINES_PLANT.get())));

        simpleBlock(CharredBlocks.BLIGHT_ROOT.get(), models().cross(CharredHorizons.MOD_ID+":blight_root",
                blockTexture(CharredBlocks.BLIGHT_ROOT.get())));

        simpleBlock(CharredBlocks.BLIGHT_FUNGUS.get(), models().cross(CharredHorizons.MOD_ID+":blight_fungus",
                blockTexture(CharredBlocks.BLIGHT_FUNGUS.get())));

        simpleBlock(CharredBlocks.WITHERED_FUNGUS.get(), models().cross(CharredHorizons.MOD_ID+":withered_fungus",
                blockTexture(CharredBlocks.WITHERED_FUNGUS.get())));

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

        simpleBlock(CharredBlocks.BLIGHT_NETHER_WART_BLOCK.get());
        simpleBlock(CharredBlocks.WITHERED_NETHER_WART_BLOCK.get());

        simpleBlock(CharredBlocks.BLIGHT_PLANKS.get());
        simpleBlock(CharredBlocks.WITHERED_PLANKS.get());

        logBlock(CharredBlocks.BLIGHT_STEM.get());
        logBlock(CharredBlocks.WITHERED_STEM.get());

        hyphae(CharredBlocks.BLIGHT_HYPHAE.get(), new ResourceLocation("charred_horizons:block/blight_stem"));
        hyphae(CharredBlocks.WITHERED_HYPHAE.get(), new ResourceLocation("charred_horizons:block/withered_stem"));

        logBlock(CharredBlocks.STRIPPED_BLIGHT_STEM.get());
        logBlock(CharredBlocks.STRIPPED_WITHERED_STEM.get());

        hyphae(CharredBlocks.STRIPPED_BLIGHT_HYPHAE.get(), new ResourceLocation("charred_horizons:block/stripped_blight_stem"));
        hyphae(CharredBlocks.STRIPPED_WITHERED_HYPHAE.get(), new ResourceLocation("charred_horizons:block/stripped_withered_stem"));

        buttonBlock(CharredBlocks.BLIGHT_BUTTON.get(), new ResourceLocation("charred_horizons:block/blight_planks"));
        buttonBlock(CharredBlocks.WITHERED_BUTTON.get(), new ResourceLocation("charred_horizons:block/withered_planks"));

        pressurePlateBlock(CharredBlocks.BLIGHT_PRESSURE_PLATE.get(), new ResourceLocation("charred_horizons:block/blight_planks"));
        pressurePlateBlock(CharredBlocks.WITHERED_PRESSURE_PLATE.get(), new ResourceLocation("charred_horizons:block/withered_planks"));

        slabBlock(CharredBlocks.BLIGHT_SLAB.get(), new ResourceLocation("charred_horizons:block/blight_planks"),
                new ResourceLocation("charred_horizons:block/blight_planks"));
        slabBlock(CharredBlocks.WITHERED_SLAB.get(), new ResourceLocation("charred_horizons:block/withered_planks"),
                new ResourceLocation("charred_horizons:block/withered_planks"));

        stairsBlock(CharredBlocks.BLIGHT_STAIRS.get(), new ResourceLocation("charred_horizons:block/blight_planks"));
        stairsBlock(CharredBlocks.WITHERED_STAIRS.get(), new ResourceLocation("charred_horizons:block/withered_planks"));

        trapdoorBlock(CharredBlocks.BLIGHT_TRAPDOOR.get(), new ResourceLocation("charred_horizons:block/blight_trapdoor"), true);
        trapdoorBlock(CharredBlocks.WITHERED_TRAPDOOR.get(), new ResourceLocation("charred_horizons:block/withered_trapdoor"), true);

        doorBlock(CharredBlocks.BLIGHT_DOOR.get(), new ResourceLocation("charred_horizons:block/blight_door_bottom"),
                new ResourceLocation("charred_horizons:block/blight_door_top"));
        doorBlock(CharredBlocks.WITHERED_DOOR.get(), new ResourceLocation("charred_horizons:block/withered_door_bottom"),
                new ResourceLocation("charred_horizons:block/withered_door_top"));

        fenceBlock(CharredBlocks.BLIGHT_FENCE.get(), new ResourceLocation("charred_horizons:block/blight_planks"));
        fenceGateBlock(CharredBlocks.BLIGHT_FENCE_GATE.get(), new ResourceLocation("charred_horizons:block/blight_planks"));
        fenceBlock(CharredBlocks.WITHERED_FENCE.get(), new ResourceLocation("charred_horizons:block/withered_planks"));
        fenceGateBlock(CharredBlocks.WITHERED_FENCE_GATE.get(), new ResourceLocation("charred_horizons:block/withered_planks"));

        signBlock(CharredBlocks.BLIGHT_SIGN.get(), CharredBlocks.BLIGHT_WALL_SIGN.get(), new ResourceLocation("charred_horizons:block/blight_planks"));
        hangingSignBlock(CharredBlocks.BLIGHT_HANGING_SIGN.get(), CharredBlocks.BLIGHT_WALL_HANGING_SIGN.get(), new ResourceLocation("charred_horizons:block/blight_planks"));

        signBlock(CharredBlocks.WITHERED_SIGN.get(), CharredBlocks.WITHERED_WALL_SIGN.get(), new ResourceLocation("charred_horizons:block/withered_planks"));
        hangingSignBlock(CharredBlocks.WITHERED_HANGING_SIGN.get(), CharredBlocks.WITHERED_WALL_HANGING_SIGN.get(), new ResourceLocation("charred_horizons:block/withered_planks"));
    }

    private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }

    private String name(Block block) {
        return key(block).getPath();
    }

    public void farmland(Block block, ResourceLocation side, ResourceLocation top) {
        simpleBlock(block, models().withExistingParent(name(block),  "block/template_farmland")
                .texture("dirt", side)
                .texture("top", top));
    }

    private void hyphae(Block block, ResourceLocation location) {
        simpleBlock(block, models().cubeAll(name(block), location));
    }

    public void hangingSignBlock(CeilingHangingSignBlock signBlock, WallHangingSignBlock wallSignBlock, ResourceLocation texture) {
        ModelFile sign = models().sign(name(signBlock), texture);
        simpleBlock(signBlock, sign);
        simpleBlock(wallSignBlock, sign);
    }
}
