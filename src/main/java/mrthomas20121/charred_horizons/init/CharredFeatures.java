package mrthomas20121.charred_horizons.init;

import mrthomas20121.charred_horizons.CharredHorizons;
import mrthomas20121.charred_horizons.worldgen.feature.CharredHugeFungusFeature;
import mrthomas20121.charred_horizons.worldgen.feature.DroopingVinesFeature;
import mrthomas20121.charred_horizons.worldgen.feature.MysticVinesFeature;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.HugeFungusConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TwistingVinesConfig;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CharredFeatures {

    public static DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(Registries.FEATURE, CharredHorizons.MOD_ID);

    public static RegistryObject<DroopingVinesFeature> DROOPING_VINES = FEATURES.register("drooping_vines", () -> new DroopingVinesFeature(NoneFeatureConfiguration.CODEC));
    public static RegistryObject<MysticVinesFeature> MYSTIC_VINES = FEATURES.register("mystic_vines", () -> new MysticVinesFeature(TwistingVinesConfig.CODEC));
    public static RegistryObject<CharredHugeFungusFeature> HUGE_FUNGUS = FEATURES.register("huge_fungus", () -> new CharredHugeFungusFeature(HugeFungusConfiguration.CODEC));
}
