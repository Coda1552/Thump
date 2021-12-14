package teamdraco.bettas.client.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.AgeableListModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;

@OnlyIn(Dist.CLIENT)
public class ThumpRabbitModel<T extends Entity> extends AgeableListModel<T> {
    public ModelPart body;
    public ModelPart tail;
    public ModelPart armRight;
    public ModelPart armLeft;
    public ModelPart footLeft;
    public ModelPart footRight;
    public ModelPart earLeft;
    public ModelPart earRight;
    public ModelPart head;

    public ThumpRabbitModel(ModelPart root) {
        this.body = root.getChild("body");
        this.armRight = this.body.getChild("armRight");
        this.armLeft = this.body.getChild("armLeft");
        this.footLeft = this.body.getChild("footLeft");
        this.tail = this.body.getChild("tail");
        this.footRight = this.body.getChild("footRight");
        this.head = this.body.getChild("head");
        this.earRight = this.head.getChild("earRight");
        this.earLeft = this.head.getChild("earLeft");
    }

    //Layer Definition
    public static LayerDefinition createLayerDefinition() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition root = meshdefinition.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 22).addBox(-2.5F, -2.0F, -3.0F, 5.0F, 4.0F, 6.0F, false), PartPose.offsetAndRotation(0.0F, 20.5F, 0.0F, -0.2617994F, 0.0F, 0.0F));
        PartDefinition armRight = body.addOrReplaceChild("armRight", CubeListBuilder.create().texOffs(0, 2).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F, false), PartPose.offsetAndRotation(-1.5F, 2.0F, -2.0F, 0.0F, 0.0F, 0.0F));
        PartDefinition armLeft = body.addOrReplaceChild("armLeft", CubeListBuilder.create().texOffs(0, 2).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F, false), PartPose.offsetAndRotation(1.5F, 2.0F, -2.0F, 0.0F, 0.0F, 0.0F));
        PartDefinition footLeft = body.addOrReplaceChild("footLeft", CubeListBuilder.create().texOffs(9, 4).addBox(-1.0F, 0.0F, -2.5F, 2.0F, 1.0F, 3.0F, false), PartPose.offsetAndRotation(1.5F, 2.0F, 2.5F, 0.2617994F, 0.0F, 0.0F));
        PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 7).addBox(-1.5F, -1.0F, -1.0F, 3.0F, 3.0F, 2.0F, false), PartPose.offsetAndRotation(0.0F, -2.0F, 3.0F, 0.0F, 0.0F, 0.0F));
        PartDefinition footRight = body.addOrReplaceChild("footRight", CubeListBuilder.create().texOffs(9, 4).addBox(-1.0F, 0.0F, -2.5F, 2.0F, 1.0F, 3.0F, true), PartPose.offsetAndRotation(-1.5F, 2.0F, 2.5F, 0.2617994F, 0.0F, 0.0F));
        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 13).addBox(-2.5F, -2.0F, -3.0F, 5.0F, 4.0F, 4.0F, false), PartPose.offsetAndRotation(0.0F, -1.0F, -3.0F, 0.2617994F, 0.0F, 0.0F));
        PartDefinition earRight = head.addOrReplaceChild("earRight", CubeListBuilder.create().texOffs(17, 21).addBox(-1.0F, -5.0F, -0.5F, 2.0F, 5.0F, 1.0F, false), PartPose.offsetAndRotation(-1.5F, -2.0F, -0.5F, 0.0F, 0.0F, 0.0F));
        PartDefinition earLeft = head.addOrReplaceChild("earLeft", CubeListBuilder.create().texOffs(17, 21).addBox(-1.0F, -5.0F, -0.5F, 2.0F, 5.0F, 1.0F, true), PartPose.offsetAndRotation(1.5F, -2.0F, -0.5F, 0.0F, 0.0F, 0.0F));
        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void setupAnim(T entityIn, float f, float f1, float ageInTicks, float netHeadYaw, float headPitch) {
        float speed = 1.0f;
        float degree = 1.0f;

        f = ageInTicks;
        f1 = 0.35F;

        this.body.y = 20F;

        this.body.xRot = Mth.cos(f * speed * 0.5F) * degree * 1.0F * f1;
        this.armRight.xRot = Mth.cos(-1.0F + f * speed * 0.5F) * degree * 2.5F * f1;
        this.armLeft.xRot = Mth.cos(-1.5F + f * speed * 0.5F) * degree * 2.5F * f1;
        this.head.xRot = Mth.cos(f * speed * 0.5F) * degree * -1.0F * f1;
        this.footLeft.xRot = Mth.cos(1.0F + f * speed * 0.5F) * degree * 4.5F * f1 + 1.2F;
        this.footRight.xRot = Mth.cos(1.5F + f * speed * 0.5F) * degree * 4.5F * f1 + 1.2F;
        this.earLeft.xRot = Mth.cos(1.0F + f * speed * 0.5F) * degree * 1.5F * f1 - 1.0F;
        this.earRight.xRot = Mth.cos(1.5F + f * speed * 0.5F) * degree * 1.5F * f1 - 1.0F;
    }

    @Override
    protected Iterable<ModelPart> headParts() {
        return Collections.emptyList();
    }

    @Override
    protected Iterable<ModelPart> bodyParts() {
        return ImmutableList.of(body);
    }
}
