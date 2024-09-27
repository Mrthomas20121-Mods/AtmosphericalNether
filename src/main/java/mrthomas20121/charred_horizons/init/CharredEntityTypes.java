package mrthomas20121.charred_horizons.init;

import mrthomas20121.charred_horizons.CharredHorizons;
import mrthomas20121.charred_horizons.entity.FierySpider;
import mrthomas20121.charred_horizons.entity.SulfuricSkeleton;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CharredEntityTypes {

    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(Registries.ENTITY_TYPE, CharredHorizons.MOD_ID);

    public static RegistryObject<EntityType<SulfuricSkeleton>> SULFURIC_SKELETON = ENTITY_TYPES.register("sulfuric_skeleton", () -> EntityType.Builder.of(SulfuricSkeleton::new, MobCategory.MONSTER).fireImmune().sized(0.6F, 1.99F).clientTrackingRange(8).build("sulfuric_skeleton"));
    public static RegistryObject<EntityType<FierySpider>> FIERY_SPIDER = ENTITY_TYPES.register("fiery_spider", () -> EntityType.Builder.of(FierySpider::new, MobCategory.MONSTER).fireImmune().sized(0.7F, 0.5F).clientTrackingRange(8).build("fiery_spider"));
}
