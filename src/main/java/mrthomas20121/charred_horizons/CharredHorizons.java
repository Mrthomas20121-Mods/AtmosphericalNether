package mrthomas20121.charred_horizons;

import mrthomas20121.charred_horizons.data.CharredDatagen;
import mrthomas20121.charred_horizons.init.CharredBlocks;
import mrthomas20121.charred_horizons.init.CharredCreativeTabs;
import mrthomas20121.charred_horizons.init.CharredItems;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(CharredHorizons.MOD_ID)
public class CharredHorizons {

	public static final String MOD_ID = "charred_horizons";

	public CharredHorizons() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

		CharredItems.ITEMS.register(bus);
		CharredBlocks.BLOCKS.register(bus);
		CharredCreativeTabs.CREATIVE_TABS.register(bus);

		bus.addListener(CharredDatagen::init);
	}
}
