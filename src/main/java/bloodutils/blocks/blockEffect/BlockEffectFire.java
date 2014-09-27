package bloodutils.blocks.blockEffect;

import net.minecraft.tileentity.TileEntity;
import bloodutils.tiles.TileFireArea;

public class BlockEffectFire extends BlockEffect{
	public TileEntity createTileEntity(){
		return new TileFireArea();
	}
}