package bloodutils.main.init;

import wasliecore.interfaces.IInitalization;
import bloodutils.blocks.BlockAltarProgress;

public class BUBlocks implements IInitalization{
	@Override
	public void preInit() {
		initBlocks();
	}
	
	@Override
	public void init() {
		initTiles();
	}

	@Override
	public void postInit() {
		
	}
	
	public void initBlocks(){
		altarProgress = new BlockAltarProgress("Altar Progression Checker");
	}
	public static BlockAltarProgress altarProgress;
	
	public void initTiles(){
		
	}
}