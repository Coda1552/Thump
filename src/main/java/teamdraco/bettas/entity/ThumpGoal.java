package teamdraco.bettas.entity;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.animal.*;

import java.util.EnumSet;
import java.util.List;
import java.util.function.Predicate;

public class ThumpGoal extends Goal {
    private final Rabbit rabbit;
    private static final Predicate<LivingEntity> PREDICATE = livingEntity -> livingEntity instanceof Wolf || livingEntity instanceof Fox || livingEntity instanceof Ocelot || livingEntity instanceof Cat;

    public ThumpGoal(Rabbit p_25919_) {
        this.rabbit = p_25919_;
        this.setFlags(EnumSet.of(Flag.JUMP));
    }

    public boolean canUse() {
        List<LivingEntity> predators = this.rabbit.level.getEntitiesOfClass(LivingEntity.class, rabbit.getBoundingBox().inflate(10.0D), PREDICATE);
        return !predators.isEmpty() && rabbit.tickCount % 20 == 0;
    }

    public void start() {
        this.rabbit.getNavigation().stop();
    }

    public void tick() {
        this.rabbit.playSound(SoundEvents.GHAST_SCREAM, 1.0F, 1.0F);
        stop();
    }
}