package bloodutils.blocks.blockEffect;

import net.minecraft.tileentity.TileEntity;
import bloodutils.tiles.TileRainbowArea;

public class BlockEffectRainbow extends BlockEffect{
	public TileEntity createTileEntity(){
		return new TileRainbowArea();
	}
}