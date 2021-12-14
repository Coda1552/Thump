package teamdraco.bettas;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.animal.Rabbit;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import teamdraco.bettas.entity.ThumpGoal;

@Mod(Thump.MOD_ID)
public class Thump {
    public static final String MOD_ID = "thump";

    public Thump() {
        IEventBus forgeBus = MinecraftForge.EVENT_BUS;

        forgeBus.addListener(this::addRabbitGoals);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void addRabbitGoals(EntityJoinWorldEvent event) {
        Entity entity = event.getEntity();

        if (entity instanceof Rabbit rabbit) {
            rabbit.goalSelector.addGoal(0, new ThumpGoal(rabbit));

        }
    }
}