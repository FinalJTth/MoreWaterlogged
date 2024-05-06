package com.zenesta.morewaterlogged.common.block.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.zenesta.morewaterlogged.common.MoreWaterlogged;
import com.zenesta.morewaterlogged.common.block.BedBlock;
import com.zenesta.morewaterlogged.common.block.entity.BedBlockEntity;
import it.unimi.dsi.fastutil.ints.Int2IntFunction;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.BrightnessCombiner;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.DoubleBlockCombiner;
// import net.minecraft.world.level.block.entity.BedBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
/*
@OnlyIn(Dist.CLIENT)
public class BedRenderer implements BlockEntityRenderer<BedBlockEntity> {
    private final ModelPart headRoot;
    private final ModelPart footRoot;

    public BedRenderer(BlockEntityRendererProvider.Context pContext) {
        this.headRoot = pContext.bakeLayer(ModelLayers.BED_HEAD);
        this.footRoot = pContext.bakeLayer(ModelLayers.BED_FOOT);
    }

    public static LayerDefinition createHeadLayer() {
        MeshDefinition $$0 = new MeshDefinition();
        PartDefinition $$1 = $$0.getRoot();
        $$1.addOrReplaceChild("main", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 16.0F, 16.0F, 6.0F), PartPose.ZERO);
        $$1.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(50, 6).addBox(0.0F, 6.0F, 0.0F, 3.0F, 3.0F, 3.0F), PartPose.rotation(1.5707964F, 0.0F, 1.5707964F));
        $$1.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(50, 18).addBox(-16.0F, 6.0F, 0.0F, 3.0F, 3.0F, 3.0F), PartPose.rotation(1.5707964F, 0.0F, 3.1415927F));
        return LayerDefinition.create($$0, 64, 64);
    }

    public static LayerDefinition createFootLayer() {
        MeshDefinition $$0 = new MeshDefinition();
        PartDefinition $$1 = $$0.getRoot();
        $$1.addOrReplaceChild("main", CubeListBuilder.create().texOffs(0, 22).addBox(0.0F, 0.0F, 0.0F, 16.0F, 16.0F, 6.0F), PartPose.ZERO);
        $$1.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(50, 0).addBox(0.0F, 6.0F, -16.0F, 3.0F, 3.0F, 3.0F), PartPose.rotation(1.5707964F, 0.0F, 0.0F));
        $$1.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(50, 12).addBox(-16.0F, 6.0F, -16.0F, 3.0F, 3.0F, 3.0F), PartPose.rotation(1.5707964F, 0.0F, 4.712389F));
        return LayerDefinition.create($$0, 64, 64);
    }

    public void render(BedBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {
        Material $$6 = Sheets.BED_TEXTURES[pBlockEntity.getColor().getId()];
        Level $$7 = pBlockEntity.getLevel();
        if ($$7 != null) {
            BlockState $$8 = pBlockEntity.getBlockState();
            DoubleBlockCombiner.NeighborCombineResult<? extends BedBlockEntity> $$9 = DoubleBlockCombiner.combineWithNeigbour(MoreWaterlogged.BED_BLOCK_ENTITY_TYPE, BedBlock::getBlockType, BedBlock::getConnectedDirection, ChestBlock.FACING, $$8, $$7, pBlockEntity.getBlockPos(), (p_112202_, p_112203_) -> {
                return false;
            });
            int $$10 = ((Int2IntFunction)$$9.apply(new BrightnessCombiner())).get(pPackedLight);
            this.renderPiece(pPoseStack, pBuffer, $$8.getValue(BedBlock.PART) == BedPart.HEAD ? this.headRoot : this.footRoot, (Direction)$$8.getValue(BedBlock.FACING), $$6, $$10, pPackedOverlay, false);
        } else {
            this.renderPiece(pPoseStack, pBuffer, this.headRoot, Direction.SOUTH, $$6, pPackedLight, pPackedOverlay, false);
            this.renderPiece(pPoseStack, pBuffer, this.footRoot, Direction.SOUTH, $$6, pPackedLight, pPackedOverlay, true);
        }

    }

    private void renderPiece(PoseStack pPoseStack, MultiBufferSource pBufferSource, ModelPart pModelPart, Direction pDirection, Material pMaterial, int pPackedLight, int pPackedOverlay, boolean pFoot) {
        pPoseStack.pushPose();
        pPoseStack.translate(0.0F, 0.5625F, pFoot ? -1.0F : 0.0F);
        pPoseStack.mulPose(Axis.XP.rotationDegrees(90.0F));
        pPoseStack.translate(0.5F, 0.5F, 0.5F);
        pPoseStack.mulPose(Axis.ZP.rotationDegrees(180.0F + pDirection.toYRot()));
        pPoseStack.translate(-0.5F, -0.5F, -0.5F);
        VertexConsumer $$8 = pMaterial.buffer(pBufferSource, RenderType::entitySolid);
        pModelPart.render(pPoseStack, $$8, pPackedLight, pPackedOverlay);
        pPoseStack.popPose();
    }
}
*/