package mrthomas20121.charred_horizons.data.loot;

import mrthomas20121.charred_horizons.CharredHorizons;
import net.minecraft.resources.ResourceLocation;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CharredLoot {

    private static final Set<ResourceLocation> LOOT_TABLES = new HashSet<>();
    public static final Set<ResourceLocation> IMMUTABLE_LOOT_TABLES = Collections.unmodifiableSet(LOOT_TABLES);

    //public static ResourceLocation PIGLIN_TEMPLE = register("chests/dungeons/piglin");

    public static ResourceLocation SULFURIC_SKELETON = register("entities/sulfuric_skeleton");
    public static ResourceLocation FIERY_SPIDER = register("entities/fiery_spider");

    public static ResourceLocation register(String name) {
        ResourceLocation resourceLocation = new ResourceLocation(CharredHorizons.MOD_ID, name);
        LOOT_TABLES.add(resourceLocation);
        return resourceLocation;
    }
}
