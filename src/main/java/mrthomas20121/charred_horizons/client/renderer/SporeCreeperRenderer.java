package mrthomas20121.charred_horizons.client.renderer;

import mrthomas20121.charred_horizons.CharredHorizons;
import net.minecraft.client.renderer.entity.CreeperRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.Creeper;

public class SporeCreeperRenderer extends CreeperRenderer {

    private static final ResourceLocation SPORE_CREEPER_LOCATION = new ResourceLocation(CharredHorizons.MOD_ID, "textures/entity/creeper/spore_creeper.png");

    public SporeCreeperRenderer(EntityRendererProvider.Context p_173958_) {
        super(p_173958_);
    }

    @Override
    public ResourceLocation getTextureLocation(Creeper p_114041_) {
        return SPORE_CREEPER_LOCATION;
    }
}
