
package net.viper.morexpitems.client.renderer;

import net.viper.morexpitems.entity.SuperexpEntity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.SlimeModel;

public class SuperexpRenderer extends MobRenderer<SuperexpEntity, SlimeModel<SuperexpEntity>> {
	public SuperexpRenderer(EntityRendererProvider.Context context) {
		super(context, new SlimeModel<SuperexpEntity>(context.bakeLayer(ModelLayers.SLIME)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(SuperexpEntity entity) {
		return ResourceLocation.parse("morexpitems:textures/entities/super_exp.png");
	}

	@Override
	protected boolean isBodyVisible(SuperexpEntity entity) {
		return false;
	}
}
