package mrthomas20121.charred_horizons.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.SuspendedParticle;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.RandomSource;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class FungalSporeProvider implements ParticleProvider<SimpleParticleType> {
    private final SpriteSet sprite;

    public FungalSporeProvider(SpriteSet p_108042_) {
        this.sprite = p_108042_;
    }

    public Particle createParticle(SimpleParticleType p_108053_, ClientLevel p_108054_, double p_108055_, double p_108056_, double p_108057_, double p_108058_, double p_108059_, double p_108060_) {
        RandomSource randomsource = p_108054_.random;
        double d0 = randomsource.nextGaussian() * (double)1.0E-6F;
        double d1 = randomsource.nextGaussian() * (double)1.0E-4F;
        double d2 = randomsource.nextGaussian() * (double)1.0E-6F;
        SuspendedParticle suspendedparticle = new SuspendedParticle(p_108054_, this.sprite, p_108055_, p_108056_, p_108057_, d0, d1, d2);
        suspendedparticle.setColor(0.43F, 0.85F, 0.60F);
        return suspendedparticle;
    }
}
