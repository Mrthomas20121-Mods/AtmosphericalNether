package mrthomas20121.charred_horizons.client;

import mrthomas20121.charred_horizons.CharredHorizons;
import mrthomas20121.charred_horizons.init.CharredBlockEntities;
import mrthomas20121.charred_horizons.init.CharredBlocks;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = CharredHorizons.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CharredClient {

    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(CharredBlockEntities.BLIGHT_SIGN.get(), SignRenderer::new);
        event.registerBlockEntityRenderer(CharredBlockEntities.BLIGHT_HANGING_SIGN.get(), HangingSignRenderer::new);

        event.registerBlockEntityRenderer(CharredBlockEntities.WITHERED_SIGN.get(), SignRenderer::new);
        event.registerBlockEntityRenderer(CharredBlockEntities.WITHERED_HANGING_SIGN.get(), HangingSignRenderer::new);
    }

    @SubscribeEvent
    public static void clientInit(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            RenderType cutout = RenderType.cutout();
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
