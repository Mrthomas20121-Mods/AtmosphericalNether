package mrthomas20121.charred_horizons.client.renderer;

import mrthomas20121.charred_horizons.CharredHorizons;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.SkeletonRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.AbstractSkeleton;

public class SulfuricSkeletonRenderer extends SkeletonRenderer {

    private static final ResourceLocation SULFURIC_SKELETON_LOCATION = new ResourceLocation(CharredHorizons.MOD_ID, "textures/entity/skeleton/sulfuric_skeleton.png");

    public SulfuricSkeletonRenderer(EntityRendererProvider.Context p_174409_) {
        super(p_174409_, CharredModelLayers.SULFURIC_SKELETON, CharredModelLayers.SULFURIC_SKELETON_INNER_ARMOR, CharredModelLayers.SULFURIC_SKELETON_OUTER_ARMOR);
        this.addLayer(new SulfuricClothingLayer<>(this, p_174409_.getModelSet()));
    }

    public ResourceLocation getTextureLocation(AbstractSkeleton p_116049_) {
        return SULFURIC_SKELETON_LOCATION;
    }
}
