package mrthomas20121.charred_horizons.init;

import mrthomas20121.charred_horizons.CharredHorizons;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CharredParticleTypes {

    public static DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(Registries.PARTICLE_TYPE, CharredHorizons.MOD_ID);

    public static RegistryObject<SimpleParticleType> BLIGHT_SPORE = PARTICLE_TYPES.register("blight_spore", () -> new SimpleParticleType(false));
    public static RegistryObject<SimpleParticleType> FUNGAL_SPORE = PARTICLE_TYPES.register("fungal_spore", () -> new SimpleParticleType(false));
}
