package mrthomas20121.charred_horizons.data;

import mrthomas20121.charred_horizons.CharredHorizons;
import mrthomas20121.charred_horizons.init.CharredBlocks;
import mrthomas20121.charred_horizons.init.CharredItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class CharredLangProvider extends LanguageProvider {

    public CharredLangProvider(PackOutput output) {
        super(output, CharredHorizons.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("creative_tab.charred_horizons.block", "Charred Horizons Blocks");
        add("creative_tab.charred_horizons.item", "Charred Horizons Items");
        addBlock(CharredBlocks.WITHERED_NYLIUM, "Withered Nylium");
        addBlock(CharredBlocks.BLIGHT_NYLIUM, "Blight Nylium");
        addBlock(CharredBlocks.BLIGHT_STEM, "Blight Stem");
        addBlock(CharredBlocks.WITHERED_STEM, "Withered Stem");
        addBlock(CharredBlocks.WITHERED_NETHER_WART, "Withered Nether Wart");
        addBlock(CharredBlocks.BLIGHT_NETHER_WART, "Blight Nether Wart");
        addItem(CharredItems.MYSTERIOUS_CHARM, "Mysterious Charm");
        addItem(CharredItems.BLIGHT_RING, "Blight Ring");
        addItem(CharredItems.GOLD_RING, "Gold Ring");
        add("item.charred_horizons.netherite_ring.effect", "Piglins become neutral.");
    }
}
