package mrthomas20121.charred_horizons.data;

import mrthomas20121.charred_horizons.CharredHorizons;
import mrthomas20121.charred_horizons.init.CharredEntityTypes;
import mrthomas20121.charred_horizons.init.CharredItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.EntityTypePredicate;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.KilledTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class CharredAdvancementProvider implements ForgeAdvancementProvider.AdvancementGenerator {

    @Override
    public void generate(HolderLookup.Provider registries, Consumer<Advancement> saver, ExistingFileHelper existingFileHelper) {
        Advancement gold_ring = Advancement.Builder.advancement()
                .display(CharredItems.GOLD_RING.get(),
                        Component.translatable("advancement.charred_horizons.gold_ring"),
                        Component.translatable("advancement.charred_horizons.gold_ring.desc"),
                        new ResourceLocation("textures/block/netherrack.png"),
                        FrameType.TASK, false, false, false)
                .addCriterion("gold_ring", InventoryChangeTrigger.TriggerInstance.hasItems(CharredItems.GOLD_RING.get()))
                .save(saver, new ResourceLocation(CharredHorizons.MOD_ID, "gold_ring"), existingFileHelper);

        Advancement mysterious_charm = Advancement.Builder.advancement()
                .display(CharredItems.GOLD_RING.get(),
                        Component.translatable("advancement.charred_horizons.mysterious_charm"),
                        Component.translatable("advancement.charred_horizons.mysterious_charm.desc"),
                        new ResourceLocation("textures/block/netherrack.png"),
                        FrameType.TASK, false, false, false)
                .addCriterion("gold_ring", InventoryChangeTrigger.TriggerInstance.hasItems(CharredItems.MYSTERIOUS_CHARM.get()))
                .save(saver, new ResourceLocation(CharredHorizons.MOD_ID, "mysterious_charm"), existingFileHelper);

        Advancement FIERY_BOW = Advancement.Builder.advancement()
                .display(CharredItems.GOLD_RING.get(),
                        Component.translatable("advancement.charred_horizons.fiery_bow"),
                        Component.translatable("advancement.charred_horizons.fiery_bow.desc"),
                        new ResourceLocation("textures/block/netherrack.png"),
                        FrameType.TASK, false, false, false)
                .addCriterion("gold_ring", InventoryChangeTrigger.TriggerInstance.hasItems(CharredItems.FIERY_BOW.get()))
                .save(saver, new ResourceLocation(CharredHorizons.MOD_ID, "fiery_bow"), existingFileHelper);

        Advancement FIERY_SPIDER = Advancement.Builder.advancement()
                .display(CharredItems.FIERY_STRING.get(),
                        Component.translatable("advancement.charred_horizons.fiery_spider"),
                        Component.translatable("advancement.charred_horizons.fiery_spider.desc"),
                        new ResourceLocation("textures/block/netherrack.png"),
                        FrameType.TASK, false, false, false)
                .addCriterion("gold_ring", KilledTrigger.TriggerInstance.entityKilledPlayer(
                        EntityPredicate.Builder.entity().entityType(EntityTypePredicate.of(CharredEntityTypes.FIERY_SPIDER.get()))))
                .save(saver, new ResourceLocation(CharredHorizons.MOD_ID, "fiery_spider"), existingFileHelper);

        Advancement SULFURIC_SKELETON = Advancement.Builder.advancement()
                .display(CharredItems.FIERY_STRING.get(),
                        Component.translatable("advancement.charred_horizons.sulfuric_skeleton"),
                        Component.translatable("advancement.charred_horizons.sulfuric.desc"),
                        new ResourceLocation("textures/block/netherrack.png"),
                        FrameType.TASK, false, false, false)
                .addCriterion("gold_ring", KilledTrigger.TriggerInstance.entityKilledPlayer(
                        EntityPredicate.Builder.entity().entityType(EntityTypePredicate.of(CharredEntityTypes.SULFURIC_SKELETON.get()))))
                .save(saver, new ResourceLocation(CharredHorizons.MOD_ID, "sulfuric_skeleton"), existingFileHelper);
    }
}
