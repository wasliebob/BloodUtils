package bloodutils.client.renders;

import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import bloodutils.client.models.ModelReviver;

public class RenderTileReviver extends TileEntitySpecialRenderer{
	public RenderTileReviver(){
		
	}
	private static final ResourceLocation textureBlock = new ResourceLocation("bloodutils:textures/models/model_reviver.png");
	private static final ResourceLocation textureBall = new ResourceLocation("bloodutils:textures/models/model_ball.png");

	ModelReviver modelBlock = new ModelReviver();
	
	@Override
	public void renderTileEntityAt(TileEntity te, double x,
			double y, double z, float ticks) {
		renderBlock(x, y, z);
	}
	
	public void renderBlock(double x, double y, double z){
        OpenGlHelper.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        OpenGlHelper.setActiveTexture(OpenGlHelper.defaultTexUnit);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
		
        GL11.glPushMatrix();
		this.bindTexture(this.textureBlock);

		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
		GL11.glRotatef(180, 1, 0, 0);
		modelBlock.render();	
		
		GL11.glPopMatrix();
	}

}