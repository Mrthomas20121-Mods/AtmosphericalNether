package mrthomas20121.charred_horizons.init;

import mrthomas20121.charred_horizons.CharredHorizons;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class CharredTags {

    public static class Items {

        public static TagKey<Item> CURIO_RING = create("curios:ring");
        public static TagKey<Item> CURIO_CHARM = create("curios:charm");

        public static TagKey<Item> LOGS_BLIGHT = mod("blight_logs");
        public static TagKey<Item> LOGS_WITHERED = mod("withered_logs");

        private static TagKey<Item> create(String name) {
            return ItemTags.create(new ResourceLocation(name));
        }

        private static TagKey<Item> mod(String name) {
            return ItemTags.create(new ResourceLocation(CharredHorizons.MOD_ID, name));
        }

        private static TagKey<Item> forge(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }

    public static class Blocks {

        public static TagKey<Block> LOGS_BLIGHT = mod("blight_logs");
        public static TagKey<Block> LOGS_WITHERED = mod("withered_logs");

        private static TagKey<Block> create(String name) {
            return BlockTags.create(new ResourceLocation(name));
        }

        private static TagKey<Block> mod(String name) {
            return BlockTags.create(new ResourceLocation(CharredHorizons.MOD_ID, name));
        }

        private static TagKey<Block> forge(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }
}
