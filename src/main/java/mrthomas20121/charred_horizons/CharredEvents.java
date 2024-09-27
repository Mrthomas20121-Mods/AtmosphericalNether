package mrthomas20121.charred_horizons;

import mrthomas20121.charred_horizons.data.CharredBiomes;
import mrthomas20121.charred_horizons.entity.FierySpider;
import mrthomas20121.charred_horizons.entity.SulfuricSkeleton;
import mrthomas20121.charred_horizons.init.CharredEntityTypes;
import mrthomas20121.charred_horizons.init.CharredItems;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.entity.monster.WitherSkeleton;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class CharredEvents {

    @Mod.EventBusSubscriber(modid = CharredHorizons.MOD_ID)
    public static class ForgeEvents {

        @SubscribeEvent
        public static void mobSpawm(EntityJoinLevelEvent event) {
            Level level = event.getLevel();
            if (!level.isClientSide()) {
                if (!event.isCanceled() && level.getBiome(event.getEntity().getOnPos()).is(CharredBiomes.DECAYING_VALLEY)) {
                    if(event.getEntity().getType().is(EntityTypeTags.SKELETONS)) {
                        event.getEntity().setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(CharredItems.WITHERED_SWORD.get()));
                    }
                    if(event.getEntity().getType().equals(EntityType.HUSK)) {
                        RandomSource source = level.getRandom();

                        if(source.nextFloat() > 0.3f) {
                            event.getEntity().setItemSlot(EquipmentSlot.HEAD, new ItemStack(Items.GOLDEN_HELMET));
                            event.getEntity().setItemSlot(EquipmentSlot.LEGS, new ItemStack(Items.GOLDEN_BOOTS));
                        }
                    }
                }
                if (!event.isCanceled() && level.getBiome(event.getEntity().getOnPos()).is(CharredBiomes.DESOLATED_FOREST)) {
                    if(event.getEntity().getType().equals(EntityType.PIGLIN)) {
                        event.getEntity().setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.GOLDEN_AXE));
                    }
                }
            }
        }

        @SubscribeEvent
        public static void itemUseTickEvent(LivingEntityUseItemEvent.Tick event) {
            if (event.getItem().is(CharredItems.FIERY_BOW.get()) && event.getDuration() > event.getItem().getUseDuration() - 20) {
                event.setDuration(event.getDuration() - 2);
            }
        }

        @SubscribeEvent
        public static void entityAttackedEvent(LivingHurtEvent event) {
            if (event.getSource().getDirectEntity() != null)
                if (event.getSource().getDirectEntity().getType().equals(CharredEntityTypes.FIERY_SPIDER.get())) {
                    event.getEntity().setSecondsOnFire(100);
                }
        }
    }

    @Mod.EventBusSubscriber(modid = CharredHorizons.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEvents {

        @SubscribeEvent
        public static void registerEntityPlacement(SpawnPlacementRegisterEvent event) {
            event.register(EntityType.WITHER_SKELETON, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    WitherSkeleton::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
            event.register(EntityType.PIGLIN, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Piglin::checkAnyLightMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
            event.register(CharredEntityTypes.SULFURIC_SKELETON.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SulfuricSkeleton::checkAnyLightMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
            event.register(CharredEntityTypes.FIERY_SPIDER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, FierySpider::checkAnyLightMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
            event.register(EntityType.GHAST, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Ghast::checkGhastSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
        }

        @SubscribeEvent
        public static void registerEntityAttributes(EntityAttributeCreationEvent event) {
            event.put(CharredEntityTypes.SULFURIC_SKELETON.get(), SulfuricSkeleton.createAttributes().build());
            event.put(CharredEntityTypes.FIERY_SPIDER.get(), FierySpider.createAttributes().build());
        }
    }
}
