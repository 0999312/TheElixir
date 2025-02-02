package com.nmmoc7.theelixir.model;
// Made with Blockbench 3.9.2
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * @author DustW
 */
public class Skirt extends EntityModel<Entity> {
	private final ModelRenderer bone6;
	private final ModelRenderer bone7;
	private final ModelRenderer bone8;
	private final ModelRenderer bone10;
	private final ModelRenderer bone11;
	private final ModelRenderer bone9;

	public Skirt() {
		textureWidth = 32;
		textureHeight = 32;

		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		bone7 = new ModelRenderer(this);
		bone7.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone6.addChild(bone7);
		bone7.setTextureOffset(0, 0).addBox(-4.0F, -15.0F, -2.0F, 8.0F, 2.0F, 4.0F, 0.05F, false);

		bone8 = new ModelRenderer(this);
		bone8.setRotationPoint(0.0F, -1.0F, -1.0F);
		bone6.addChild(bone8);
		setRotationAngle(bone8, -0.0873F, 0.0F, 0.0F);
		bone8.setTextureOffset(0, 15).addBox(-4.0F, -13.0F, -2.0F, 8.0F, 8.0F, 1.0F, 0.0F, false);

		bone10 = new ModelRenderer(this);
		bone10.setRotationPoint(3.0F, -1.0F, 0.0F);
		bone6.addChild(bone10);
		setRotationAngle(bone10, 0.0F, -1.5708F, -0.0873F);
		bone10.setTextureOffset(18, 6).addBox(-2.0F, -13.0F, -2.0F, 4.0F, 8.0F, 1.0F, 0.0F, false);

		bone11 = new ModelRenderer(this);
		bone11.setRotationPoint(-7.0F, -1.5F, 0.0F);
		bone6.addChild(bone11);
		setRotationAngle(bone11, 0.0F, -1.5708F, 0.0873F);
		bone11.setTextureOffset(18, 18).addBox(-2.0F, -13.0F, -3.0F, 4.0F, 8.0F, 1.0F, 0.0F, false);

		bone9 = new ModelRenderer(this);
		bone9.setRotationPoint(0.0F, -1.0F, 5.0F);
		bone6.addChild(bone9);
		setRotationAngle(bone9, 0.0873F, 0.0F, 0.0F);
		bone9.setTextureOffset(0, 6).addBox(-4.0F, -13.0F, -3.0F, 8.0F, 8.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		bone6.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}