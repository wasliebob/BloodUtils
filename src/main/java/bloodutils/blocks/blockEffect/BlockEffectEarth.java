package bloodutils.blocks.blockEffect;

import net.minecraft.tileentity.TileEntity;
import bloodutils.tiles.TileEarthArea;

public class BlockEffectEarth extends BlockEffect{
	public TileEntity createTileEntity(){
		return new TileEarthArea();
	}
}