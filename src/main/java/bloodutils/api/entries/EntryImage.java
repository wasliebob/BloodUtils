package bloodutils.api.entries;

import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import bloodutils.api.classes.guide.GuiEntry;

public class EntryImage implements IEntry{
	public EntryImage(String resource, int iconWidth, int iconHeight){
		this.resource = new ResourceLocation(resource);
		this.iconWidth = iconWidth;
		this.iconHeight = iconHeight;
	}
	public ResourceLocation resource;
	public int iconWidth;
	public int iconHeight;
	
	@Override
	public void draw(GuiEntry entry, int width, int height, int left, int top, EntityPlayer player, String key, int page, int mX, int mY){
		int x = left + 32;
		int y = top + 10;
		Minecraft.getMinecraft().getTextureManager().bindTexture(this.resource);

		drawIconWithoutColor(x, y, this.iconWidth, this.iconHeight, 0);
	}
	
	public static void drawIconWithoutColor(int x, int y, int width, int height, float zLevel){
	    Tessellator t = Tessellator.instance;
	    t.startDrawingQuads();
	    t.addVertexWithUV(x + 0, y + height, zLevel, 0D, 1D);
	    t.addVertexWithUV(x + width, y + height, zLevel, 1D, 1D);
	    t.addVertexWithUV(x + width, y + 0, zLevel, 1D, 0D);
	    t.addVertexWithUV(x + 0, y + 0, zLevel, 0D, 0D);
	    t.draw();
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public void initGui(int width, int height, int left, int top,
			EntityPlayer player, List buttonList) {
		
	}

	@Override
	public void actionPerformed(GuiButton button){		
		
	}
}