package mrthomas20121.charred_horizons;

import mrthomas20121.charred_horizons.data.CharredDatagen;
import mrthomas20121.charred_horizons.init.CharredBlockEntities;
import mrthomas20121.charred_horizons.init.CharredBlocks;
import mrthomas20121.charred_horizons.init.CharredCreativeTabs;
import mrthomas20121.charred_horizons.init.CharredItems;
import mrthomas20121.charred_horizons.worldgen.CharredRegion;
import mrthomas20121.charred_horizons.worldgen.CharredSurfaceData;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

@Mod(CharredHorizons.MOD_ID)
public class CharredHorizons {

	public static final String MOD_ID = "charred_horizons";

	public CharredHorizons() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

		CharredItems.ITEMS.register(bus);
		CharredBlocks.BLOCKS.register(bus);
		CharredBlockEntities.BLOCK_ENTITY_TYPES.register(bus);
		CharredCreativeTabs.CREATIVE_TABS.register(bus);

		bus.addListener(CharredDatagen::init);
		bus.addListener(this::setup);
	}

	public void setup(FMLCommonSetupEvent event) {
		Regions.register(new CharredRegion(new ResourceLocation(MOD_ID, "charred_horizons"), 10));

		SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.NETHER, MOD_ID, CharredSurfaceData.rules());
	}
}
