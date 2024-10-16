package mrthomas20121.charred_horizons.data;

import mrthomas20121.charred_horizons.CharredHorizons;
import mrthomas20121.charred_horizons.init.CharredBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class CharredPlacedFeatures {

    public static final ResourceKey<PlacedFeature> BLIGHT_FUNGUS = createKey("blight_fungus");
    public static final ResourceKey<PlacedFeature> BLIGHT_VEGETATION = createKey("blight_vegetation");
    public static final ResourceKey<PlacedFeature> WITHERED_FUNGUS = createKey("withered_fungus");
    public static final ResourceKey<PlacedFeature> WITHERED_VEGETATION = createKey("withered_vegetation");
    public static final ResourceKey<PlacedFeature> DROOPING_VINES = createKey("drooping_vines");
    public static final ResourceKey<PlacedFeature> MYSTIC_VINES = createKey("mystic_vines");

    public static final ResourceKey<PlacedFeature> MYSTIC_MUSHROOM = createKey("mystic_mushroom");
    public static final ResourceKey<PlacedFeature> MYSTIC_VEGETATION = createKey("mystic_vegetation");
    public static final ResourceKey<PlacedFeature> SHROOMLIGHT = createKey("shroomlight");

    public static ResourceKey<PlacedFeature> createKey(String p_255643_) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(CharredHorizons.MOD_ID, p_255643_));
    }

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        Holder<ConfiguredFeature<? ,?>> BLIGHT = configuredFeatures.getOrThrow(CharredConfiguredFeatures.BLIGHT_FUNGUS);
        Holder<ConfiguredFeature<? ,?>> WITHERED = configuredFeatures.getOrThrow(CharredConfiguredFeatures.WITHERED_FUNGUS);
        Holder<ConfiguredFeature<?, ?>> VEGETATION = configuredFeatures.getOrThrow(CharredConfiguredFeatures.BLIGHT_VEGETATION);
        Holder<ConfiguredFeature<?, ?>> MYSTIC_VEG = configuredFeatures.getOrThrow(CharredConfiguredFeatures.MYSTIC_VEGETATION);
        Holder<ConfiguredFeature<?, ?>> VINE = configuredFeatures.getOrThrow(CharredConfiguredFeatures.MYSTIC_VINES);
        Holder<ConfiguredFeature<?, ?>> WITHERED_VEG = configuredFeatures.getOrThrow(CharredConfiguredFeatures.WITHERED_VEGETATION);
        Holder<ConfiguredFeature<?, ?>> DROOPING = configuredFeatures.getOrThrow(CharredConfiguredFeatures.DROOPING_VINES);
        Holder<ConfiguredFeature<?, ?>> MUSHROOM = configuredFeatures.getOrThrow(CharredConfiguredFeatures.MYSTIC_MUSHROOM);
        Holder<ConfiguredFeature<?, ?>> SHROOMLIGHT_CONFIG = configuredFeatures.getOrThrow(CharredConfiguredFeatures.SHROOMLIGHT);

        register(context, BLIGHT_FUNGUS, BLIGHT, CountOnEveryLayerPlacement.of(5), PlacementUtils.filteredByBlockSurvival(CharredBlocks.BLIGHT_NYLIUM.get()), BiomeFilter.biome());
        register(context, WITHERED_FUNGUS, WITHERED, CountOnEveryLayerPlacement.of(2), PlacementUtils.filteredByBlockSurvival(CharredBlocks.WITHERED_NYLIUM.get()), BiomeFilter.biome());
        register(context, BLIGHT_VEGETATION, VEGETATION, CountOnEveryLayerPlacement.of(6), BiomeFilter.biome());
        register(context, MYSTIC_VEGETATION, MYSTIC_VEG, CountOnEveryLayerPlacement.of(6), PlacementUtils.filteredByBlockSurvival(CharredBlocks.MYSTIC_NYLIUM.get()), BiomeFilter.biome());
        register(context, WITHERED_VEGETATION, WITHERED_VEG, CountOnEveryLayerPlacement.of(4), BiomeFilter.biome());
        register(context, MYSTIC_MUSHROOM, MUSHROOM, CountOnEveryLayerPlacement.of(5), BiomeFilter.biome());

        // place vines
        register(context, DROOPING_VINES, DROOPING, PlacementUtils.countExtra(10, 0.1f, 1), InSquarePlacement.spread(), PlacementUtils.FULL_RANGE, BiomeFilter.biome());
        register(context, SHROOMLIGHT, SHROOMLIGHT_CONFIG, PlacementUtils.countExtra(2, 0.025f, 1), InSquarePlacement.spread(), PlacementUtils.FULL_RANGE, BiomeFilter.biome());
        register(context, MYSTIC_VINES, VINE, PlacementUtils.countExtra(10, 0.1f, 1), InSquarePlacement.spread(), PlacementUtils.FULL_RANGE, BiomeFilter.biome());
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration, PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}
