package mrthomas20121.charred_horizons.init;

import mrthomas20121.charred_horizons.CharredHorizons;
import mrthomas20121.charred_horizons.block.CharredNyliumBlock;
import mrthomas20121.charred_horizons.block.DroopingVineBlock;
import mrthomas20121.charred_horizons.block.DroopingVinePlantBlock;
import mrthomas20121.charred_horizons.block.sign.*;
import mrthomas20121.charred_horizons.data.CharredConfiguredFeatures;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;
import java.util.function.Supplier;

public class CharredBlocks {

    public static DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, CharredHorizons.MOD_ID);

    public static RegistryObject<Block> EXOTIC_SHROOMLIGHT = register("exotic_shroomlight", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_WHITE).strength(1.0F).sound(SoundType.SHROOMLIGHT).lightLevel((p_187431_) -> 15)));
    public static RegistryObject<Block> BLIGHT_NYLIUM = register("blight_nylium", () -> new CharredNyliumBlock(BlockBehaviour.Properties.of().isValidSpawn((state, getter, pos, entity) -> entity.is(EntityTypeTags.SKELETONS) || entity.equals(EntityType.PIGLIN)).mapColor(MapColor.TERRACOTTA_ORANGE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.4F).sound(SoundType.NYLIUM).randomTicks()));
    public static RegistryObject<FungusBlock> BLIGHT_FUNGUS = register("blight_fungus", () -> new FungusBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_ORANGE).noCollission().strength(0.4F).sound(SoundType.NYLIUM), CharredConfiguredFeatures.BLIGHT_FUNGUS_PLANTED, BLIGHT_NYLIUM.get()));
    public static RegistryObject<RootsBlock> BLIGHT_ROOT = register("blight_root", () -> new RootsBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_ROOTS).mapColor(MapColor.TERRACOTTA_ORANGE).noCollission().strength(0.4F).sound(SoundType.NYLIUM)));
    public static RegistryObject<Block> BLIGHT_NETHER_WART_BLOCK = register("blight_nether_wart", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_ORANGE).instrument(NoteBlockInstrument.BASEDRUM).strength(0.4F).sound(SoundType.NETHER_WART)));
    public static RegistryObject<DroopingVineBlock> DROOPING_VINES = register("drooping_vines", () -> new DroopingVineBlock(BlockBehaviour.Properties.copy(Blocks.WEEPING_VINES).mapColor(MapColor.TERRACOTTA_ORANGE).instrument(NoteBlockInstrument.BASEDRUM).strength(0.4F).sound(SoundType.NETHER_WART)));
    public static RegistryObject<DroopingVinePlantBlock> DROOPING_VINES_PLANT = registerNoItem("drooping_vines_plant", () -> new DroopingVinePlantBlock(BlockBehaviour.Properties.copy(Blocks.WEEPING_VINES_PLANT).mapColor(MapColor.TERRACOTTA_ORANGE).instrument(NoteBlockInstrument.BASEDRUM).strength(0.4F).sound(SoundType.NETHER_WART)));
    public static RegistryObject<RotatedPillarBlock> BLIGHT_STEM = register("blight_stem", () -> netherStem(MapColor.TERRACOTTA_ORANGE));
    public static RegistryObject<Block> BLIGHT_HYPHAE = register("blight_hyphae", () -> new Block(BlockBehaviour.Properties.copy(Blocks.CRIMSON_HYPHAE).mapColor(MapColor.TERRACOTTA_ORANGE)));
    public static RegistryObject<RotatedPillarBlock> STRIPPED_BLIGHT_STEM = register("stripped_blight_stem", () -> netherStem(MapColor.TERRACOTTA_ORANGE));
    public static RegistryObject<Block> STRIPPED_BLIGHT_HYPHAE = register("stripped_blight_hyphae", () -> new Block(BlockBehaviour.Properties.copy(Blocks.CRIMSON_HYPHAE).mapColor(MapColor.TERRACOTTA_ORANGE)));
    public static RegistryObject<Block> BLIGHT_PLANKS = register("blight_planks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS).mapColor(MapColor.TERRACOTTA_ORANGE)));
    public static RegistryObject<StairBlock> BLIGHT_STAIRS = register("blight_stairs", () -> new StairBlock(() -> BLIGHT_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.CRIMSON_SLAB).mapColor(MapColor.TERRACOTTA_ORANGE)));
    public static RegistryObject<SlabBlock> BLIGHT_SLAB = register("blight_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_SLAB).mapColor(MapColor.TERRACOTTA_ORANGE)));
    public static RegistryObject<PressurePlateBlock> BLIGHT_PRESSURE_PLATE = register("blight_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.CRIMSON_PRESSURE_PLATE).mapColor(MapColor.TERRACOTTA_ORANGE), CharredWoodTypes.BLIGHT_SET));
    public static RegistryObject<ButtonBlock> BLIGHT_BUTTON = register("blight_button", () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_BUTTON).mapColor(MapColor.TERRACOTTA_ORANGE), CharredWoodTypes.BLIGHT_SET, 30, true));
    public static RegistryObject<FenceBlock> BLIGHT_FENCE = register("blight_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS).mapColor(MapColor.TERRACOTTA_ORANGE)));
    public static RegistryObject<FenceGateBlock> BLIGHT_FENCE_GATE = register("blight_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS).mapColor(MapColor.TERRACOTTA_ORANGE), CharredWoodTypes.BLIGHT));
    public static RegistryObject<DoorBlock> BLIGHT_DOOR = register("blight_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS).mapColor(MapColor.TERRACOTTA_ORANGE), CharredWoodTypes.BLIGHT_SET));
    public static RegistryObject<TrapDoorBlock> BLIGHT_TRAPDOOR = register("blight_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS).mapColor(MapColor.TERRACOTTA_ORANGE), CharredWoodTypes.BLIGHT_SET));
    public static RegistryObject<BlightStandingSignBlock> BLIGHT_SIGN = registerNoItem("blight_sign", () -> new BlightStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_SIGN).mapColor(MapColor.TERRACOTTA_ORANGE), CharredWoodTypes.BLIGHT));
    public static RegistryObject<BlightWallSignBlock> BLIGHT_WALL_SIGN = registerNoItem("blight_wall_sign", () -> new BlightWallSignBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_WALL_SIGN).mapColor(MapColor.TERRACOTTA_ORANGE), CharredWoodTypes.BLIGHT));
    public static RegistryObject<BlightWallHangingSignBlock> BLIGHT_WALL_HANGING_SIGN = registerNoItem("blight_wall_hanging_sign", () -> new BlightWallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_WALL_HANGING_SIGN).mapColor(MapColor.TERRACOTTA_ORANGE), CharredWoodTypes.BLIGHT));
    public static RegistryObject<BlightCeilingHangingSignBlock> BLIGHT_HANGING_SIGN = registerNoItem("blight_hanging_sign", () -> new BlightCeilingHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_HANGING_SIGN).mapColor(MapColor.TERRACOTTA_ORANGE), CharredWoodTypes.BLIGHT));
    public static RegistryObject<Block> WITHERED_NYLIUM = register("withered_nylium", () -> new CharredNyliumBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BLACK).instrument(NoteBlockInstrument.BASEDRUM).isValidSpawn((state, getter, pos, entity) -> entity.is(EntityTypeTags.SKELETONS)).requiresCorrectToolForDrops().strength(0.4F).sound(SoundType.NYLIUM).randomTicks()));
    public static RegistryObject<FungusBlock> WITHERED_FUNGUS = register("withered_fungus", () -> new FungusBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BLACK).noCollission().strength(0.4F).sound(SoundType.NYLIUM), CharredConfiguredFeatures.WITHERED_FUNGUS_PLANTED, WITHERED_NYLIUM.get()));
    public static RegistryObject<Block> WITHERED_NETHER_WART_BLOCK = register("withered_nether_wart", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BLACK).instrument(NoteBlockInstrument.BASEDRUM).strength(0.4F).sound(SoundType.NETHER_WART)));
    public static RegistryObject<RotatedPillarBlock> WITHERED_STEM = register("withered_stem", () -> netherStem(MapColor.TERRACOTTA_BLACK));
    public static RegistryObject<Block> WITHERED_HYPHAE = register("withered_hyphae", () -> new Block(BlockBehaviour.Properties.copy(Blocks.CRIMSON_HYPHAE).mapColor(MapColor.TERRACOTTA_BLACK)));
    public static RegistryObject<RotatedPillarBlock> STRIPPED_WITHERED_STEM = register("stripped_withered_stem", () -> netherStem(MapColor.TERRACOTTA_BLACK));
    public static RegistryObject<Block> STRIPPED_WITHERED_HYPHAE = register("stripped_withered_hyphae", () -> new Block(BlockBehaviour.Properties.copy(Blocks.CRIMSON_HYPHAE).mapColor(MapColor.TERRACOTTA_BLACK)));
    public static RegistryObject<Block> WITHERED_PLANKS = register("withered_planks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS).mapColor(MapColor.TERRACOTTA_BLACK)));
    public static RegistryObject<StairBlock> WITHERED_STAIRS = register("withered_stairs", () -> new StairBlock(() -> WITHERED_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.CRIMSON_STAIRS).mapColor(MapColor.TERRACOTTA_BLACK)));
    public static RegistryObject<SlabBlock> WITHERED_SLAB = register("withered_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_SLAB).mapColor(MapColor.TERRACOTTA_BLACK)));
    public static RegistryObject<PressurePlateBlock> WITHERED_PRESSURE_PLATE = register("withered_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.CRIMSON_PRESSURE_PLATE).mapColor(MapColor.TERRACOTTA_BLACK), CharredWoodTypes.WITHERED_SET));
    public static RegistryObject<ButtonBlock> WITHERED_BUTTON = register("withered_button", () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_BUTTON).mapColor(MapColor.TERRACOTTA_BLACK), CharredWoodTypes.WITHERED_SET, 30, true));
    public static RegistryObject<FenceBlock> WITHERED_FENCE = register("withered_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS).mapColor(MapColor.TERRACOTTA_BLACK)));
    public static RegistryObject<FenceGateBlock> WITHERED_FENCE_GATE = register("withered_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS).mapColor(MapColor.TERRACOTTA_BLACK), CharredWoodTypes.WITHERED));
    public static RegistryObject<DoorBlock> WITHERED_DOOR = register("withered_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS).mapColor(MapColor.TERRACOTTA_BLACK), CharredWoodTypes.WITHERED_SET));
    public static RegistryObject<TrapDoorBlock> WITHERED_TRAPDOOR = register("withered_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS).mapColor(MapColor.TERRACOTTA_BLACK), CharredWoodTypes.WITHERED_SET));
    public static RegistryObject<WitheredStandingSignBlock> WITHERED_SIGN = registerNoItem("withered_sign", () -> new WitheredStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_SIGN).mapColor(MapColor.TERRACOTTA_BLACK), CharredWoodTypes.WITHERED));
    public static RegistryObject<WitheredWallSignBlock> WITHERED_WALL_SIGN = registerNoItem("withered_wall_sign", () -> new WitheredWallSignBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_WALL_SIGN).mapColor(MapColor.TERRACOTTA_BLACK), CharredWoodTypes.WITHERED));
    public static RegistryObject<WitheredWallHangingSignBlock> WITHERED_WALL_HANGING_SIGN = registerNoItem("withered_wall_hanging_sign", () -> new WitheredWallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_WALL_HANGING_SIGN).mapColor(MapColor.TERRACOTTA_BLACK), CharredWoodTypes.WITHERED));
    public static RegistryObject<WitheredCeilingHangingSignBlock> WITHERED_HANGING_SIGN = registerNoItem("withered_hanging_sign", () -> new WitheredCeilingHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_HANGING_SIGN).mapColor(MapColor.TERRACOTTA_BLACK), CharredWoodTypes.WITHERED));

    private static RotatedPillarBlock netherStem(MapColor mapColor) {
        return new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor((state) -> mapColor).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.STEM));
    }

    public static <T extends Block> RegistryObject<T> register(String name, Supplier<T> blockSupplier) {
        return register(name, blockSupplier, (block) -> new BlockItem(block, new Item.Properties()));
    }

    public static <A extends Block, B extends BlockItem> RegistryObject<A> register(String name, Supplier<A> blockSupplier, Function<A, B> itemSupplier) {
        RegistryObject<A> block = BLOCKS.register(name, blockSupplier);

        CharredItems.ITEMS.register(name, () -> itemSupplier.apply(block.get()));

        return block;
    }

    /**
     * method to register block
     * @param name
     * @param blockSupplier
     * @return
     */
    public static <T extends Block> RegistryObject<T> registerNoItem(String name, Supplier<T> blockSupplier) {
        return BLOCKS.register(name, blockSupplier);
    }
}
