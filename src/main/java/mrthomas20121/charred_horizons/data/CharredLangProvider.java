package mrthomas20121.charred_horizons.data;

import mrthomas20121.charred_horizons.CharredHorizons;
import mrthomas20121.charred_horizons.init.CharredBlocks;
import mrthomas20121.charred_horizons.init.CharredEntityTypes;
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

        addEntityType(CharredEntityTypes.SULFURIC_SKELETON, "Sulfuric Skeleton");
        addEntityType(CharredEntityTypes.FIERY_SPIDER, "Fiery Spider");
        addBlock(CharredBlocks.EXOTIC_SHROOMLIGHT, "Exotic Shroomlight");
        addBlock(CharredBlocks.DROOPING_VINES, "Drooping Vines");
        addBlock(CharredBlocks.DROOPING_VINES_PLANT, "Drooping Vines Plant");
        addBlock(CharredBlocks.BLIGHT_ROOT, "Blight Root");
        addBlock(CharredBlocks.BLIGHT_NYLIUM, "Blight Nylium");
        addBlock(CharredBlocks.BLIGHT_FUNGUS, "Blight Fungus");
        addBlock(CharredBlocks.BLIGHT_STEM, "Blight Stem");
        addBlock(CharredBlocks.BLIGHT_PLANKS, "Blight Planks");
        addBlock(CharredBlocks.BLIGHT_SLAB, "Blight Slab");
        addBlock(CharredBlocks.BLIGHT_STAIRS, "Blight Stairs");
        addBlock(CharredBlocks.BLIGHT_TRAPDOOR, "Blight Trapdoor");
        addBlock(CharredBlocks.BLIGHT_DOOR, "Blight Door");
        addBlock(CharredBlocks.BLIGHT_FENCE, "Blight Fence");
        addBlock(CharredBlocks.BLIGHT_PRESSURE_PLATE, "Blight Pressure Plate");
        addBlock(CharredBlocks.BLIGHT_BUTTON, "Blight Button");
        addBlock(CharredBlocks.BLIGHT_FENCE_GATE, "Blight Fence Gate");

        addBlock(CharredBlocks.WITHERED_NYLIUM, "Withered Nylium");
        addBlock(CharredBlocks.WITHERED_FUNGUS, "Withered Fungus");
        addBlock(CharredBlocks.WITHERED_STEM, "Withered Stem");
        addBlock(CharredBlocks.WITHERED_PLANKS, "Withered Planks");
        addBlock(CharredBlocks.WITHERED_SLAB, "Withered Slab");
        addBlock(CharredBlocks.WITHERED_STAIRS, "Withered Stairs");
        addBlock(CharredBlocks.WITHERED_TRAPDOOR, "Withered Trapdoor");
        addBlock(CharredBlocks.WITHERED_DOOR, "Withered Door");
        addBlock(CharredBlocks.WITHERED_FENCE, "Withered Fence");
        addBlock(CharredBlocks.WITHERED_FENCE_GATE, "Withered Fence Gate");
        addBlock(CharredBlocks.WITHERED_PRESSURE_PLATE, "Withered Pressure Plate");
        addBlock(CharredBlocks.WITHERED_BUTTON, "Withered Button");
        addBlock(CharredBlocks.WITHERED_NETHER_WART_BLOCK, "Withered Nether Wart");
        addBlock(CharredBlocks.BLIGHT_NETHER_WART_BLOCK, "Blight Nether Wart");

        addBlock(CharredBlocks.BLIGHT_SIGN, "Blight Sign");
        addBlock(CharredBlocks.BLIGHT_HANGING_SIGN, "Blight Hanging Sign");
        addBlock(CharredBlocks.WITHERED_SIGN, "Withered Sign");
        addBlock(CharredBlocks.WITHERED_HANGING_SIGN, "Withered Hanging Sign");

        addBlock(CharredBlocks.IMPROVED_FARMLAND_BLOCK, "Improved Farmland");

        addItem(CharredItems.MYSTERIOUS_CHARM, "Mysterious Charm");
        addItem(CharredItems.BLIGHT_RING, "Blight Ring");
        addItem(CharredItems.GOLD_RING, "Gold Ring");
        addItem(CharredItems.BLAZE_SLAYER, "Blaze Slayer");
        addItem(CharredItems.WITHERED_SWORD, "Wither Skeleton Sword");
        addItem(CharredItems.FIERY_STRING, "Fiery String");
        addItem(CharredItems.FIERY_BOW, "Fiery Bow");
        addItem(CharredItems.SULFUR_DUST, "Sulfur Dust");
        addItem(CharredItems.SULFURIC_BONE, "Sulfuric Bone");
        addItem(CharredItems.SULFURIC_BONE_MEAL, "Sulfuric Bone Meal");
        addItem(CharredItems.SULFURIC_SKELETON_EGG, "Sulfuric Skeleton Spawn Egg");
        addItem(CharredItems.FIERY_SPIDER_EGG, "Fiery Spider Spawn Egg");

        add("item.charred_horizons.fiery_bow.description", "Fast draw bow that shoot fire arrow");
        add("item.charred_horizons.netherite_ring.effect", "Piglins become neutral.");

        // advancements
        add("advancement.charred_horizons.gold_ring", "One ring to rule them all...");
        add("advancement.charred_horizons.gold_ring.desc", "Obtain a Gold Ring from a Fortress or Bastion.");
        add("advancement.charred_horizons.mysterious_charm", "One Step at a time");
        add("advancement.charred_horizons.mysterious_charm.desc", "Obtain a Mysterious charm from a Nether Fortress.");
        add("advancement.charred_horizons.fiery_bow", "Harder Faster Better Stronger.");
        add("advancement.charred_horizons.fiery_bow.desc", "Craft a Fiery Bow.");
        add("advancement.charred_horizons.fiery_spider", "Oh Crap a spider.");
        add("advancement.charred_horizons.fiery_spider.desc", "Kill a Fiery Spider.");
        add("advancement.charred_horizons.sulfuric_skeleton", "Oh Crap a spider.");
        add("advancement.charred_horizons.sulfuric_skeleton.desc", "Kill a Fiery Spider.");
        add("advancement.charred_horizons.improved_farmland", "Work Smart, Not Harder.");
        add("advancement.charred_horizons.improved_farmland.desc", "Craft an Improved Farmland Block.");
    }
}
