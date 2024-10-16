package mrthomas20121.charred_horizons.worldgen;

import com.mojang.datafixers.util.Pair;
import mrthomas20121.charred_horizons.data.CharredBiomes;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.ParameterUtils;
import terrablender.api.Region;
import terrablender.api.RegionType;

import java.util.function.Consumer;

public class CharredRegion extends Region {


    public CharredRegion(ResourceLocation name, int weight) {
        super(name, RegionType.NETHER, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {

        this.addBiome(mapper, ParameterUtils.Temperature.HOT, ParameterUtils.Humidity.NEUTRAL, ParameterUtils.Continentalness.FULL_RANGE, ParameterUtils.Erosion.FULL_RANGE, ParameterUtils.Weirdness.FULL_RANGE, ParameterUtils.Depth.FULL_RANGE, 0f, CharredBiomes.DECAYING_VALLEY);
        this.addBiome(mapper, ParameterUtils.Temperature.COOL, ParameterUtils.Humidity.HUMID, ParameterUtils.Continentalness.FULL_RANGE, ParameterUtils.Erosion.FULL_RANGE, ParameterUtils.Weirdness.FULL_RANGE, ParameterUtils.Depth.FULL_RANGE, 0f, CharredBiomes.DESOLATED_FOREST);
        this.addBiome(mapper, ParameterUtils.Temperature.FULL_RANGE, ParameterUtils.Humidity.WET, ParameterUtils.Continentalness.FULL_RANGE, ParameterUtils.Erosion.FULL_RANGE, ParameterUtils.Weirdness.FULL_RANGE, ParameterUtils.Depth.FULL_RANGE, 0f, CharredBiomes.FUNGAL_ABYSS);
    }
}
