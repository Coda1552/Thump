package teamdraco.bettas.client;

import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import teamdraco.bettas.Thump;
import teamdraco.bettas.client.model.ThumpRabbitModel;
import teamdraco.bettas.client.renderer.ThumpRabbitRenderer;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = Thump.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        EntityRenderers.register(EntityType.RABBIT, ThumpRabbitRenderer::new);
        ForgeHooksClient.registerLayerDefinition(ThumpRabbitRenderer.MODEL_LAYER, ThumpRabbitModel::createLayerDefinition);

    }
}
