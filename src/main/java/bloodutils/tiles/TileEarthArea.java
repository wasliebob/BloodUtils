package bloodutils.tiles;

import bloodutils.main.init.BUBlocks;
import net.minecraft.init.Blocks;

public class TileEarthArea extends BUTile{
	@Override
	public void updateEntity(){
		for(int x = 0; x < 5; x++){
			for(int y = 0; y < 4; y++){
				if(isAir(xCoord - 2 + x, yCoord + y, zCoord + 2))
					setBlock(xCoord - 2 + x, yCoord + y, zCoord + 2, BUBlocks.earthDummy);
			
				if(isAir(xCoord - 2 + x, yCoord + y, zCoord - 2))
					setBlock(xCoord - 2 + x, yCoord + y, zCoord - 2, BUBlocks.earthDummy);
			}
		}
		
		for(int z = 0; z < 5; z++){
			for(int y = 0; y < 4; y++){
				if(isAir(xCoord + 2, yCoord + y, zCoord - 2 + z))
					setBlock(xCoord + 2, yCoord + y, zCoord - 2 + z, BUBlocks.earthDummy);
			
				if(isAir(xCoord - 2, yCoord + y, zCoord - 2 + z))
					setBlock(xCoord - 2, yCoord + y, zCoord - 2 + z, BUBlocks.earthDummy);
			}
		}
	
		for(int x = 0; x < 5; x++){
			for(int z = 0; z < 5; z++){
				if(isAir(xCoord - 2 + x, yCoord + 4, zCoord - 2 + z))
					setBlock(xCoord - 2 + x, yCoord + 4, zCoord - 2 + z, BUBlocks.earthDummy);
			}
		}
	}
}