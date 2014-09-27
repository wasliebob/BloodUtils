package bloodutils.tiles;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;

public class TileRainbowArea extends BUTile{
	@Override
	public void updateEntity(){
		if(worldObj.isRemote){
			ArrayList<Block> blocks = new ArrayList<Block>();
			blocks.add(Blocks.wool);
			blocks.add(Blocks.stained_hardened_clay);
			blocks.add(Blocks.stained_glass);
			blocks.add(Blocks.stained_glass_pane);
			for(int x = -1; x < 2; x++){
				for(int z = -1; z < 2; z++){
					if(!isAir(xCoord + x, yCoord, zCoord + z)){
						Block block = getBlock(xCoord + x, yCoord, zCoord + z);
						int meta = getMeta(xCoord + x, yCoord, zCoord + z);
						if(block != null && meta == 0){
							int max = 15;
							int min = 1;
							Random rand = new Random();
		
						    int color = rand.nextInt((max - min) + 1) + min;
						    worldObj.setBlockMetadataWithNotify(xCoord + x, yCoord, zCoord + z, color, 2);
						}
					}
				}
			}
		}
	}
}