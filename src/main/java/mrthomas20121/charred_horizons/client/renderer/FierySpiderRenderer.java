package mrthomas20121.charred_horizons.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import mrthomas20121.charred_horizons.CharredHorizons;
import mrthomas20121.charred_horizons.entity.FierySpider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.SpiderRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.CaveSpider;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class FierySpiderRenderer extends SpiderRenderer<FierySpider> {
    private static final ResourceLocation FIERY_SPIDER_LOCATION = new ResourceLocation(CharredHorizons.MOD_ID, "textures/entity/spider/fiery_spider.png");
    private static final float SCALE = 0.7F;

    public FierySpiderRenderer(EntityRendererProvider.Context context) {
        super(context, CharredModelLayers.FIERY_SPIDER);
        this.shadowRadius *= 0.7F;
    }

    protected void scale(FierySpider spider, PoseStack poseStack, float p_113976_) {
        poseStack.scale(0.7F, 0.7F, 0.7F);
    }

    public ResourceLocation getTextureLocation(FierySpider spider) {
        return FIERY_SPIDER_LOCATION;
    }

}
