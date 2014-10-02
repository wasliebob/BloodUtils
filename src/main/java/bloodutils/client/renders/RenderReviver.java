package bloodutils.client.renders;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.world.IBlockAccess;

import org.lwjgl.opengl.GL11;

import bloodutils.client.models.ModelReviver;
import bloodutils.libs.LibRenders;
import bloodutils.tiles.TileReviver;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderReviver implements ISimpleBlockRenderingHandler{
	public ModelReviver model = new ModelReviver();
	
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks rb) {
		GL11.glPushMatrix();
		GL11.glScalef(1, 0.6f, 1);

		TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileReviver(), 0.0D, 0.0D, 0.0D, 0.0F);
		
		GL11.glPopMatrix();
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		return false;
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		return true;
	}

	@Override
	public int getRenderId() {
		return LibRenders.reviver_ID;
	}
}