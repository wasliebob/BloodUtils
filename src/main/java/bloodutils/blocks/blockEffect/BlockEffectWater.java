package bloodutils.blocks.blockEffect;

import net.minecraft.tileentity.TileEntity;
import bloodutils.tiles.TileWaterArea;

public class BlockEffectWater extends BlockEffect{
	public TileEntity createTileEntity(){
		return new TileWaterArea();
	}
}