package bloodutils.blocks.blockEffect;

import net.minecraft.tileentity.TileEntity;
import bloodutils.tiles.TileLightArea;

public class BlockEffectLight extends BlockEffect{
	public TileEntity createTileEntity(){
		return new TileLightArea();
	}
}