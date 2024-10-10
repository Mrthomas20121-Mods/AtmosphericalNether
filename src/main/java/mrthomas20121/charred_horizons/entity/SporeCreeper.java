package mrthomas20121.charred_horizons.entity;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SporeCreeper extends Creeper {

    public SporeCreeper(EntityType<SporeCreeper> type, Level level) {
        super(type, level);
    }

    @Override
    public @NotNull Collection<MobEffectInstance> getActiveEffects() {
        Collection<MobEffectInstance> oldEffectInstances = super.getActiveEffects();

        List<MobEffectInstance> effectInstances = new ArrayList<>(oldEffectInstances);

        if(!hasEffect(MobEffects.POISON)) {
            effectInstances.add(new MobEffectInstance(MobEffects.POISON, 300));
        }
        if(!hasEffect(MobEffects.WEAKNESS)) {
            effectInstances.add(new MobEffectInstance(MobEffects.WEAKNESS, 300));
        }
        if(!hasEffect(MobEffects.GLOWING)) {
            effectInstances.add(new MobEffectInstance(MobEffects.GLOWING, 300));
        }
        return effectInstances;
    }
}
