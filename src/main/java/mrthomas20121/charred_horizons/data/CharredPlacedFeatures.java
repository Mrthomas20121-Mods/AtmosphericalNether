package mrthomas20121.charred_horizons.data;

import mrthomas20121.charred_horizons.CharredHorizons;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountOnEveryLayerPlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class CharredPlacedFeatures {

    public static final ResourceKey<PlacedFeature> BLIGHT_FUNGUS = createKey("blight_fungus");

    public static final ResourceKey<PlacedFeature> WITHERED_FUNGUS = createKey("withered_fungus");

    public static ResourceKey<PlacedFeature> createKey(String p_255643_) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(CharredHorizons.MOD_ID, p_255643_));
    }

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        Holder<ConfiguredFeature<? ,?>> BLIGHT = configuredFeatures.getOrThrow(CharredConfiguredFeatures.BLIGHT_FUNGUS);
        Holder<ConfiguredFeature<? ,?>> WITHERED = configuredFeatures.getOrThrow(CharredConfiguredFeatures.WITHERED_FUNGUS);

        register(context, BLIGHT_FUNGUS, BLIGHT, CountOnEveryLayerPlacement.of(8), BiomeFilter.biome());
        register(context, WITHERED_FUNGUS, WITHERED, CountOnEveryLayerPlacement.of(4), BiomeFilter.biome());
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration, PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}
