package mrthomas20121.charred_horizons.init;

import mrthomas20121.charred_horizons.CharredHorizons;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class CharredTags {

    public static class Items {

        public static TagKey<Item> CURIO_RING = create("curios:ring");
        public static TagKey<Item> CURIO_CHARM = create("curios:charm");

        public static TagKey<Item> WITHERED_REPAIR_MATERIALS = mod("withered_repair_materials");
        public static TagKey<Item> BLAZE_SLAYER_REPAIR_MATERIALS = mod("blaze_slayer_repair_materials");

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

        public static TagKey<Block> NEEDS_WITHERED_TOOLS = mod("needs_withered_tools");
        public static TagKey<Block> NEEDS_BLAZE_SLAYER_TOOLS = mod("needs_blaze_slayer_tools");

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

    public static class Entities {

        public static TagKey<EntityType<?>> BLAZES = forge("blazes");

        private static TagKey<EntityType<?>> create(String name) {
            return TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation(name));
        }

        private static TagKey<EntityType<?>> mod(String name) {
            return create(CharredHorizons.MOD_ID+":"+name);
        }

        private static TagKey<EntityType<?>> forge(String name) {
            return create("forge"+":"+name);
        }
    }
}
