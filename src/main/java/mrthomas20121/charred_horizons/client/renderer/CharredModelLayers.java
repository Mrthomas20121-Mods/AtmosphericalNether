package mrthomas20121.charred_horizons.client.renderer;

import mrthomas20121.charred_horizons.CharredHorizons;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class CharredModelLayers {


    public static final ModelLayerLocation SULFURIC_SKELETON = register("sulfuric_skeleton");
    public static final ModelLayerLocation SULFURIC_SKELETON_INNER_ARMOR = registerInnerArmor("sulfuric_skeleton");
    public static final ModelLayerLocation SULFURIC_SKELETON_OUTER_ARMOR = registerOuterArmor("sulfuric_skeleton");
    public static final ModelLayerLocation SULFURIC_SKELETON_OUTER_LAYER = register("sulfuric_skeleton", "outer");

    public static final ModelLayerLocation FIERY_SPIDER = register("fiery_spider");

    private static ModelLayerLocation registerInnerArmor(String name) {
        return register(name, "inner_armor");
    }

    private static ModelLayerLocation registerOuterArmor(String name) {
        return register(name, "outer_armor");
    }

    private static ModelLayerLocation register(String name) {
        return register(name, "main");
    }

    private static ModelLayerLocation register(String name, String type) {
        return register(new ResourceLocation(CharredHorizons.MOD_ID, name), type);
    }

    private static ModelLayerLocation register(ResourceLocation identifier, String type) {
        return new ModelLayerLocation(identifier, type);
    }
}
