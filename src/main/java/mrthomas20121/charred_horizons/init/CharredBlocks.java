package mrthomas20121.charred_horizons.init;

import mrthomas20121.charred_horizons.CharredHorizons;
import mrthomas20121.charred_horizons.block.CharredNyliumBlock;
import net.minecraft.core.registries.Registries;
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

    public static RegistryObject<Block> BLIGHT_NYLIUM = register("blight_nylium", () -> new CharredNyliumBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_ORANGE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.4F).sound(SoundType.NYLIUM).randomTicks()));
    public static RegistryObject<Block> BLIGHT_NETHER_WART = register("blight_nether_wart", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_ORANGE).instrument(NoteBlockInstrument.BASEDRUM).strength(0.4F).sound(SoundType.NETHER_WART)));
    public static RegistryObject<RotatedPillarBlock> BLIGHT_STEM = register("blight_stem", () -> netherStem(MapColor.TERRACOTTA_ORANGE));
    public static RegistryObject<Block> WITHERED_NYLIUM = register("withered_nylium", () -> new CharredNyliumBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BLACK).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.4F).sound(SoundType.NYLIUM).randomTicks()));
    public static RegistryObject<Block> WITHERED_NETHER_WART = register("withered_nether_wart", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BLACK).instrument(NoteBlockInstrument.BASEDRUM).strength(0.4F).sound(SoundType.NETHER_WART)));
    public static RegistryObject<RotatedPillarBlock> WITHERED_STEM = register("withered_stem", () -> netherStem(MapColor.TERRACOTTA_BLACK));

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
    public static RegistryObject<Block> registerNoItem(String name, Supplier<Block> blockSupplier) {
        return BLOCKS.register(name, blockSupplier);
    }
}
