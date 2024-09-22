package mrthomas20121.charred_horizons.init;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.util.Lazy;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public enum CharredTiers implements Tier {

    WITHERED(3, 500, 3f, 3.5f, 15, () -> Ingredient.of(CharredTags.Items.WITHERED_REPAIR_MATERIALS), CharredTags.Blocks.NEEDS_WITHERED_TOOLS),
    BLAZE_SLAYER(2, 30, 2.5f, 2f, 22, () -> Ingredient.of(CharredTags.Items.BLAZE_SLAYER_REPAIR_MATERIALS), CharredTags.Blocks.NEEDS_BLAZE_SLAYER_TOOLS);

    private final int level;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final Lazy<Ingredient> repairIngredient;
    private final TagKey<Block> tag;

    CharredTiers(int level, int uses, float speed, float damage, int enchantmentValue, Supplier<Ingredient> repairIngredient, TagKey<Block> tag) {
        this.level = level;
        this.uses = uses;
        this.speed = speed;
        this.damage = damage;
        this.enchantmentValue = enchantmentValue;
        this.repairIngredient = Lazy.of(repairIngredient);
        this.tag = tag;
    }

    public int getUses() {
        return this.uses;
    }

    public float getSpeed() {
        return this.speed;
    }

    public float getAttackDamageBonus() {
        return this.damage;
    }

    public int getLevel() {
        return this.level;
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public @NotNull Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public @Nullable TagKey<Block> getTag() {
        return tag;
    }
}
