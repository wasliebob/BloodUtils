package bloodutils.client.renders;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import bloodutils.client.models.ModelGuide;

public class RenderGuide implements IItemRenderer{
	public ModelGuide model = new ModelGuide();
	private static final ResourceLocation texture = new ResourceLocation("bloodutils:textures/models/model_guide.png");
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return type == ItemRenderType.EQUIPPED_FIRST_PERSON;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item,
			ItemRendererHelper helper) {
		return false;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		GL11.glPushMatrix();
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		GL11.glTranslatef(1F, -1.5F, 1F);
		GL11.glScaled(2D, 2D, 2D);
		model.render();

		GL11.glPopMatrix();
	}
}