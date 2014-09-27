package bloodutils.blocks.blockEffect;

import net.minecraft.tileentity.TileEntity;
import bloodutils.tiles.TileDarknessArea;

public class BlockEffectDarkness extends BlockEffect{
	public TileEntity createTileEntity(){
		return new TileDarknessArea();
	}
}