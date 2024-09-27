package mrthomas20121.charred_horizons.data;

import mrthomas20121.charred_horizons.init.CharredBlocks;
import mrthomas20121.charred_horizons.init.CharredItems;
import mrthomas20121.charred_horizons.init.CharredTags;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;

import java.util.function.Consumer;

public class CharredRecipeProvider extends RecipeProvider {

    public CharredRecipeProvider(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        Block B = CharredBlocks.BLIGHT_PLANKS.get();
        Block W = CharredBlocks.WITHERED_PLANKS.get();

        // normal log
        planksFromLogs(consumer, CharredBlocks.BLIGHT_PLANKS.get(), CharredTags.Items.LOGS_BLIGHT, 4);
        planksFromLogs(consumer, CharredBlocks.WITHERED_PLANKS.get(), CharredTags.Items.LOGS_WITHERED, 4);
        woodFromLogs(consumer, CharredBlocks.BLIGHT_HYPHAE.get(), CharredBlocks.BLIGHT_STEM.get());
        woodFromLogs(consumer, CharredBlocks.WITHERED_HYPHAE.get(), CharredBlocks.WITHERED_STEM.get());
        // stripped log
        woodFromLogs(consumer, CharredBlocks.STRIPPED_BLIGHT_HYPHAE.get(), CharredBlocks.STRIPPED_BLIGHT_STEM.get());
        woodFromLogs(consumer, CharredBlocks.STRIPPED_WITHERED_HYPHAE.get(), CharredBlocks.STRIPPED_WITHERED_STEM.get());

        // door, trapdoor, button and pressure plate
        doorBuilder(CharredBlocks.BLIGHT_DOOR.get(), i(B)).unlockedBy(getHasName(B), has(B)).save(consumer);
        doorBuilder(CharredBlocks.WITHERED_DOOR.get(), i(W)).unlockedBy(getHasName(W), has(W)).save(consumer);
        trapdoorBuilder(CharredBlocks.BLIGHT_TRAPDOOR.get(), i(B)).unlockedBy(getHasName(B), has(B)).save(consumer);
        trapdoorBuilder(CharredBlocks.WITHERED_TRAPDOOR.get(), i(W)).unlockedBy(getHasName(W), has(W)).save(consumer);
        buttonBuilder(CharredBlocks.BLIGHT_BUTTON.get(), i(B)).unlockedBy(getHasName(B), has(B)).save(consumer);
        buttonBuilder(CharredBlocks.WITHERED_BUTTON.get(), i(W)).unlockedBy(getHasName(W), has(W)).save(consumer);
        pressurePlateBuilder(RecipeCategory.BUILDING_BLOCKS, CharredBlocks.BLIGHT_PRESSURE_PLATE.get(), i(B)).unlockedBy(getHasName(B), has(B)).save(consumer);
        pressurePlateBuilder(RecipeCategory.BUILDING_BLOCKS, CharredBlocks.WITHERED_PRESSURE_PLATE.get(), i(W)).unlockedBy(getHasName(W), has(W)).save(consumer);

        // slab and stairs
        slabBuilder(RecipeCategory.BUILDING_BLOCKS, CharredBlocks.BLIGHT_SLAB.get(), i(B))
                .unlockedBy(getHasName(B), has(B)).save(consumer);
        slabBuilder(RecipeCategory.BUILDING_BLOCKS, CharredBlocks.WITHERED_SLAB.get(), i(W))
                .unlockedBy(getHasName(W), has(W)).save(consumer);
        stairBuilder(CharredBlocks.BLIGHT_STAIRS.get(), i(B))
                .unlockedBy(getHasName(B), has(B)).save(consumer);
        stairBuilder(CharredBlocks.WITHERED_STAIRS.get(), i(W))
                .unlockedBy(getHasName(W), has(W)).save(consumer);
        // fences
        fenceBuilder(CharredBlocks.BLIGHT_FENCE.get(), i(B))
                .unlockedBy(getHasName(B), has(B)).save(consumer);
        fenceBuilder(CharredBlocks.WITHERED_FENCE.get(), i(W))
                .unlockedBy(getHasName(W), has(W)).save(consumer);
        fenceGateBuilder(CharredBlocks.BLIGHT_FENCE_GATE.get(), i(B))
                .unlockedBy(getHasName(B), has(B)).save(consumer);
        fenceGateBuilder(CharredBlocks.WITHERED_FENCE_GATE.get(), i(W))
                .unlockedBy(getHasName(W), has(W)).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, Items.BOW)
                .define('#', Items.GOLD_INGOT).define('X', CharredItems.FIERY_STRING.get())
                .pattern(" #X").pattern("# X").pattern(" #X")
                .unlockedBy("has_fiery_string", has(CharredItems.FIERY_STRING.get())).save(consumer);
    }

    private Ingredient i(ItemLike itemLike) {
        return Ingredient.of(itemLike);
    }

    private Ingredient i(TagKey<Item> tag) {
        return Ingredient.of(tag);
    }
}
