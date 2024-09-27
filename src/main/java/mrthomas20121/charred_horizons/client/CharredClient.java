package mrthomas20121.charred_horizons.client;

import mrthomas20121.charred_horizons.CharredHorizons;
import mrthomas20121.charred_horizons.client.particle.BlightSporeProvider;
import mrthomas20121.charred_horizons.client.renderer.CharredModelLayers;
import mrthomas20121.charred_horizons.client.renderer.FierySpiderRenderer;
import mrthomas20121.charred_horizons.client.renderer.SulfuricSkeletonRenderer;
import mrthomas20121.charred_horizons.entity.FierySpider;
import mrthomas20121.charred_horizons.init.*;
import net.minecraft.client.model.HumanoidArmorModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.SkeletonModel;
import net.minecraft.client.model.SpiderModel;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = CharredHorizons.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CharredClient {

    @SubscribeEvent
    public static void registerParticleProvider(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(CharredParticleTypes.BLIGHT_SPORE.get(), BlightSporeProvider::new);
    }

    public static void registerItemProperties() {
        ItemProperties.register(CharredItems.FIERY_BOW.get(), new ResourceLocation("pulling"),
                (stack, world, living, i) -> living != null && living.isUsingItem() && living.getUseItem() == stack ? 1.0F : 0.0F);
        ItemProperties.register(CharredItems.FIERY_BOW.get(), new ResourceLocation("pull"),
                (stack, world, living, i) -> living != null ? living.getUseItem() != stack ? 0.0F : (float) (stack.getUseDuration() - living.getUseItemRemainingTicks()) / 20.0F : 0.0F);
    }

    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(CharredBlockEntities.BLIGHT_SIGN.get(), SignRenderer::new);
        event.registerBlockEntityRenderer(CharredBlockEntities.BLIGHT_HANGING_SIGN.get(), HangingSignRenderer::new);

        event.registerBlockEntityRenderer(CharredBlockEntities.WITHERED_SIGN.get(), SignRenderer::new);
        event.registerBlockEntityRenderer(CharredBlockEntities.WITHERED_HANGING_SIGN.get(), HangingSignRenderer::new);

        event.registerEntityRenderer(CharredEntityTypes.SULFURIC_SKELETON.get(), SulfuricSkeletonRenderer::new);
        event.registerEntityRenderer(CharredEntityTypes.FIERY_SPIDER.get(), FierySpiderRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        LayerDefinition layerdefinition1 = LayerDefinition.create(HumanoidArmorModel.createBodyLayer(new CubeDeformation(1.0F)), 64, 32);
        LayerDefinition layerdefinition3 = LayerDefinition.create(HumanoidArmorModel.createBodyLayer(new CubeDeformation(0.5F)), 64, 32);

        event.registerLayerDefinition(CharredModelLayers.FIERY_SPIDER, SpiderModel::createSpiderBodyLayer);
        event.registerLayerDefinition(CharredModelLayers.SULFURIC_SKELETON, SkeletonModel::createBodyLayer);
        event.registerLayerDefinition(CharredModelLayers.SULFURIC_SKELETON_INNER_ARMOR, () -> layerdefinition3);
        event.registerLayerDefinition(CharredModelLayers.SULFURIC_SKELETON_OUTER_ARMOR, () -> layerdefinition1);

        event.registerLayerDefinition(CharredModelLayers.SULFURIC_SKELETON_OUTER_LAYER, () -> LayerDefinition.create(HumanoidModel.createMesh(new CubeDeformation(0.25F), 0.0F), 64, 32));
    }

    @SubscribeEvent
    public static void clientInit(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            registerItemProperties();

            RenderType cutout = RenderType.cutout();

            ItemBlockRenderTypes.setRenderLayer(CharredBlocks.DROOPING_VINES.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(CharredBlocks.DROOPING_VINES_PLANT.get(), cutout);

            ItemBlockRenderTypes.setRenderLayer(CharredBlocks.BLIGHT_ROOT.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(CharredBlocks.BLIGHT_FUNGUS.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(CharredBlocks.WITHERED_FUNGUS.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(CharredBlocks.BLIGHT_TRAPDOOR.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(CharredBlocks.WITHERED_TRAPDOOR.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(CharredBlocks.BLIGHT_DOOR.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(CharredBlocks.WITHERED_DOOR.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(CharredBlocks.BLIGHT_SLAB.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(CharredBlocks.WITHERED_SLAB.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(CharredBlocks.BLIGHT_STAIRS.get(), cutout);
            ItemBlockRenderTypes.setRenderLayer(CharredBlocks.WITHERED_STAIRS.get(), cutout);
        });
    }
}
