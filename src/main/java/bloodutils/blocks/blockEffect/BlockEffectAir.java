package bloodutils.blocks.blockEffect;

import net.minecraft.tileentity.TileEntity;
import bloodutils.tiles.TileAirArea;

public class BlockEffectAir extends BlockEffect{
	public TileEntity createTileEntity(){
		return new TileAirArea();
	}
}