package mrthomas20121.charred_horizons.data;

import mrthomas20121.charred_horizons.CharredHorizons;
import mrthomas20121.charred_horizons.init.CharredBlocks;
import mrthomas20121.charred_horizons.init.CharredEntityTypes;
import mrthomas20121.charred_horizons.init.CharredItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.advancements.packs.VanillaAdventureAdvancements;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MultiNoiseBiomeSourceParameterList;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class CharredAdvancementProvider implements ForgeAdvancementProvider.AdvancementGenerator {

    @Override
    public void generate(HolderLookup.Provider registries, Consumer<Advancement> saver, ExistingFileHelper existingFileHelper) {
        ResourceLocation rootAchievement = new ResourceLocation("nether/root");
        Advancement gold_ring = Advancement.Builder.advancement()
                .parent(rootAchievement)
                .display(CharredItems.GOLD_RING.get(),
                        Component.translatable("advancement.charred_horizons.gold_ring"),
                        Component.translatable("advancement.charred_horizons.gold_ring.desc"),
                        new ResourceLocation("textures/block/netherrack.png"),
                        FrameType.TASK, true, true, false)
                .addCriterion("gold_ring", InventoryChangeTrigger.TriggerInstance.hasItems(CharredItems.GOLD_RING.get()))
                .save(saver, new ResourceLocation(CharredHorizons.MOD_ID, "gold_ring"), existingFileHelper);

        Advancement mysterious_charm = Advancement.Builder.advancement()
                .parent(rootAchievement)
                .display(CharredItems.MYSTERIOUS_CHARM.get(),
                        Component.translatable("advancement.charred_horizons.mysterious_charm"),
                        Component.translatable("advancement.charred_horizons.mysterious_charm.desc"),
                        new ResourceLocation("textures/block/netherrack.png"),
                        FrameType.TASK, true, true, false)
                .addCriterion("mysterious_charm", InventoryChangeTrigger.TriggerInstance.hasItems(CharredItems.MYSTERIOUS_CHARM.get()))
                .save(saver, new ResourceLocation(CharredHorizons.MOD_ID, "mysterious_charm"), existingFileHelper);

        Advancement FIERY_BOW = Advancement.Builder.advancement()
                .parent(rootAchievement)
                .display(CharredItems.FIERY_BOW.get(),
                        Component.translatable("advancement.charred_horizons.fiery_bow"),
                        Component.translatable("advancement.charred_horizons.fiery_bow.desc"),
                        new ResourceLocation("textures/block/netherrack.png"),
                        FrameType.TASK, true, true, false)
                .addCriterion("fiery_bow", InventoryChangeTrigger.TriggerInstance.hasItems(CharredItems.FIERY_BOW.get()))
                .save(saver, new ResourceLocation(CharredHorizons.MOD_ID, "fiery_bow"), existingFileHelper);

        Advancement IMPROVED_FARMLAND = Advancement.Builder.advancement()
                .parent(rootAchievement)
                .display(CharredBlocks.IMPROVED_FARMLAND_BLOCK.get(),
                        Component.translatable("advancement.charred_horizons.improved_farmland"),
                        Component.translatable("advancement.charred_horizons.improved_farmland.desc"),
                        new ResourceLocation("textures/block/netherrack.png"),
                        FrameType.TASK, true, true, false)
                .addCriterion("farmland", InventoryChangeTrigger.TriggerInstance.hasItems(CharredBlocks.IMPROVED_FARMLAND_BLOCK.get()))
                .save(saver, new ResourceLocation(CharredHorizons.MOD_ID, "improved_farmland"), existingFileHelper);

        Advancement FIERY_SPIDER = Advancement.Builder.advancement()
                .parent(rootAchievement)
                .display(CharredItems.FIERY_STRING.get(),
                        Component.translatable("advancement.charred_horizons.fiery_spider"),
                        Component.translatable("advancement.charred_horizons.fiery_spider.desc"),
                        new ResourceLocation("textures/block/netherrack.png"),
                        FrameType.TASK, true, true, false)
                .addCriterion("fiery_spider", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(CharredEntityTypes.FIERY_SPIDER.get())))
                .save(saver, new ResourceLocation(CharredHorizons.MOD_ID, "fiery_spider"), existingFileHelper);

        Advancement SULFURIC_SKELETON = Advancement.Builder.advancement()
                .parent(rootAchievement)
                .display(CharredItems.SULFURIC_BONE.get(),
                        Component.translatable("advancement.charred_horizons.sulfuric_skeleton"),
                        Component.translatable("advancement.charred_horizons.sulfuric_skeleton.desc"),
                        new ResourceLocation("textures/block/netherrack.png"),
                        FrameType.TASK, true, true, false)
                .addCriterion("sulfuric_skeleton", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(CharredEntityTypes.SULFURIC_SKELETON.get())))
                .save(saver, new ResourceLocation(CharredHorizons.MOD_ID, "sulfuric_skeleton"), existingFileHelper);

        Advancement SPORE_CREEPER = Advancement.Builder.advancement()
                .parent(rootAchievement)
                .display(CharredItems.SULFUR_DUST.get(),
                        Component.translatable("advancement.charred_horizons.spore_creeper"),
                        Component.translatable("advancement.charred_horizons.spore_creeper.desc"),
                        new ResourceLocation("textures/block/netherrack.png"),
                        FrameType.TASK, true, true, false)
                .addCriterion("spore_creeper", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(CharredEntityTypes.SPORE_CREEPER.get())))
                .save(saver, new ResourceLocation(CharredHorizons.MOD_ID, "spore_creeper"), existingFileHelper);

        Advancement EXPLORE_NETHER = Advancement.Builder.advancement()
                .parent(rootAchievement)
                .display(CharredItems.GOLD_RING.get(),
                        Component.translatable("advancements.charred_horizons.explore_nether"),
                        Component.translatable("advancements.charred_horizons.explore_nether.description"),
                        null,
                        FrameType.CHALLENGE, true, true, false)
                .addCriterion(CharredBiomes.DECAYING_VALLEY.location().toString(), PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(CharredBiomes.DECAYING_VALLEY)))
                .addCriterion(CharredBiomes.DESOLATED_FOREST.location().toString(), PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(CharredBiomes.DESOLATED_FOREST)))
                .addCriterion(CharredBiomes.FUNGAL_ABYSS.location().toString(), PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(CharredBiomes.FUNGAL_ABYSS)))
                .rewards(AdvancementRewards.Builder.experience(500))
                .save(saver, new ResourceLocation(CharredHorizons.MOD_ID, "explore_nether"), existingFileHelper);
    }
}
