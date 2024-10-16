package mrthomas20121.charred_horizons;

import mrthomas20121.charred_horizons.data.CharredBiomes;
import mrthomas20121.charred_horizons.entity.FierySpider;
import mrthomas20121.charred_horizons.entity.SporeCreeper;
import mrthomas20121.charred_horizons.entity.SulfuricSkeleton;
import mrthomas20121.charred_horizons.init.CharredBlocks;
import mrthomas20121.charred_horizons.init.CharredEntityTypes;
import mrthomas20121.charred_horizons.init.CharredItems;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.monster.WitherSkeleton;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.EntityMobGriefingEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.event.level.ExplosionEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class CharredEvents {

    @Mod.EventBusSubscriber(modid = CharredHorizons.MOD_ID)
    public static class ForgeEvents {

        @SubscribeEvent
        public static void boneMeal(BonemealEvent event) {

            if(event.isCanceled()) {
                return;
            }

            Level level = event.getLevel();
            BlockPos pos = event.getPos();

            boolean flag = false;
            boolean flag1 = false;
            boolean flag2 = false;

            if(event.getBlock().is(Tags.Blocks.NETHERRACK)) {
                for(BlockPos blockpos : BlockPos.betweenClosed(pos.offset(-1, -1, -1), pos.offset(1, 1, 1))) {

                    if(level.getBlockState(blockpos).is(CharredBlocks.BLIGHT_NYLIUM.get())) {
                        flag = true;
                    }
                    else if(level.getBlockState(blockpos).is(CharredBlocks.WITHERED_NYLIUM.get())) {
                        flag1 = true;
                    }
                    else if(level.getBlockState(blockpos).is(CharredBlocks.MYSTIC_NYLIUM.get())) {
                        flag2 = true;
                    }

                    if(!level.getBlockState(pos).is(BlockTags.NYLIUM)) {
                        if(flag && flag1 && flag2) {
                            int n = level.getRandom().nextInt(1, 3);
                            if(n == 1) {
                                level.setBlock(pos, CharredBlocks.BLIGHT_NYLIUM.get().defaultBlockState(), 3);
                            }
                            else if(n == 2) {
                                level.setBlock(pos, CharredBlocks.WITHERED_NYLIUM.get().defaultBlockState(), 3);
                            }
                            else if(n == 3) {
                                level.setBlock(pos, CharredBlocks.MYSTIC_NYLIUM.get().defaultBlockState(), 3);
                            }
                        }
                        else if(flag && flag1) {
                            BlockState state = level.getRandom().nextBoolean() ? CharredBlocks.BLIGHT_NYLIUM.get().defaultBlockState(): CharredBlocks.WITHERED_NYLIUM.get().defaultBlockState();
                            level.setBlock(pos, state, 3);
                        }
                        else if(flag && flag2) {
                            BlockState state = level.getRandom().nextBoolean() ? CharredBlocks.BLIGHT_NYLIUM.get().defaultBlockState(): CharredBlocks.MYSTIC_NYLIUM.get().defaultBlockState();
                            level.setBlock(pos, state, 3);
                        }
                        else if(flag1 && flag2) {
                            BlockState state = level.getRandom().nextBoolean() ? CharredBlocks.WITHERED_NYLIUM.get().defaultBlockState(): CharredBlocks.MYSTIC_NYLIUM.get().defaultBlockState();
                            level.setBlock(pos, state, 3);
                        }
                        else if(flag) {
                            level.setBlock(pos, CharredBlocks.BLIGHT_NYLIUM.get().defaultBlockState(), 3);
                        }
                        else if(flag1) {
                            level.setBlock(pos, CharredBlocks.WITHERED_NYLIUM.get().defaultBlockState(), 3);
                        }
                        else if(flag2) {
                            level.setBlock(pos, CharredBlocks.MYSTIC_NYLIUM.get().defaultBlockState(), 3);
                        }
                    }
                }
            }

        }

        @SubscribeEvent
        public static void mobSpawn(EntityJoinLevelEvent event) {
            if (event.loadedFromDisk())
            {
                return;
            }

            Level level = event.getLevel();
            if (!level.isClientSide()) {
                if (!event.isCanceled()) {
                    if(event.getEntity().getType().equals(EntityType.WITHER_SKELETON)) {
                        event.getEntity().setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(CharredItems.WITHERED_SWORD.get()));
                    }
                    if(event.getEntity().getType().equals(CharredEntityTypes.SULFURIC_SKELETON.get())) {
                        ItemStack bow = new ItemStack(CharredItems.FIERY_BOW.get());

                        bow.setDamageValue(event.getLevel().getRandom().nextInt(10, bow.getMaxDamage()-10));

                        event.getEntity().setItemSlot(EquipmentSlot.MAINHAND, bow);
                    }

                    if (level.getBiome(event.getEntity().getOnPos()).is(CharredBiomes.DESOLATED_FOREST)) {
                        if(event.getEntity().getType().equals(EntityType.PIGLIN)) {
                            event.getEntity().setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.GOLDEN_AXE));
                        }
                    }
                }
            }
        }

        @SubscribeEvent
        public static void mobGriefing(EntityMobGriefingEvent event) {
            if(event.getEntity().getType().equals(CharredEntityTypes.SPORE_CREEPER.get())) {
                event.setResult(Event.Result.DENY);
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

        @SubscribeEvent
        public static void onGrowth(BlockEvent.CropGrowEvent.Pre event) {
            if(event.getLevel().getBlockState(event.getPos().below()).is(CharredBlocks.IMPROVED_FARMLAND_BLOCK.get())) {
                event.setResult(Event.Result.ALLOW);
            }
        }

        @SubscribeEvent
        public static void explosionEvent(ExplosionEvent.Detonate event) {
            if(event.getExplosion().getIndirectSourceEntity() != null && event.getExplosion().getIndirectSourceEntity().getType().equals(CharredEntityTypes.SPORE_CREEPER.get())) {
                LivingEntity entity = event.getExplosion().getIndirectSourceEntity();
                Level level = event.getLevel();

                if(!level.isClientSide) {
                    BlockPos pos = entity.getOnPos();
                    if(level.getBlockState(pos.below()).is(BlockTags.NYLIUM)) {
                        level.setBlock(pos, level.getRandom().nextBoolean() ? CharredBlocks.MYSTIC_MUSHROOM.get().defaultBlockState(): CharredBlocks.MYSTIC_ROOT.get().defaultBlockState(), 2);
                    }
                }
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
            event.register(CharredEntityTypes.SPORE_CREEPER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SporeCreeper::checkAnyLightMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);        }

        @SubscribeEvent
        public static void registerEntityAttributes(EntityAttributeCreationEvent event) {
            event.put(CharredEntityTypes.SULFURIC_SKELETON.get(), SulfuricSkeleton.createAttributes().build());
            event.put(CharredEntityTypes.FIERY_SPIDER.get(), FierySpider.createAttributes().build());
            event.put(CharredEntityTypes.SPORE_CREEPER.get(), SporeCreeper.createAttributes().build());
        }
    }
}
