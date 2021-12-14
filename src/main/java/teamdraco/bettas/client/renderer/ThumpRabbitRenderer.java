package teamdraco.bettas.client.renderer;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Rabbit;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import teamdraco.bettas.Thump;
import teamdraco.bettas.client.model.ThumpRabbitModel;

@OnlyIn(Dist.CLIENT)
public class ThumpRabbitRenderer extends MobRenderer<Rabbit, ThumpRabbitModel<Rabbit>> {
    public static final ModelLayerLocation MODEL_LAYER = new ModelLayerLocation(new ResourceLocation(Thump.MOD_ID, "rabbit"), "main");
    private static final ResourceLocation TEXTURE = new ResourceLocation(Thump.MOD_ID, "textures/entity/rabbit/brown.png");

    public ThumpRabbitRenderer(EntityRendererProvider.Context manager) {
        super(manager, new ThumpRabbitModel<>(manager.bakeLayer(MODEL_LAYER)), 0.3F);
    }

    @Override
    public ResourceLocation getTextureLocation(Rabbit entity) {
        return TEXTURE;
    }
}