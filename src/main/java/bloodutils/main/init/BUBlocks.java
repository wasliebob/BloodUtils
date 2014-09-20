package bloodutils.main.init;

import cpw.mods.fml.common.registry.GameRegistry;
import wasliecore.interfaces.IInitalization;
import bloodutils.blocks.BlockAltarBuilder;
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
		altarBuilder = new BlockAltarBuilder("Altar Builder");
		altarProgress = new BlockAltarProgress("Altar Progression Checker");
	}
	public static BlockAltarBuilder altarBuilder;
	public static BlockAltarProgress altarProgress;
	
	public void initTiles(){
		GameRegistry.registerTileEntity(bloodutils.tiles.TileAltarBuilder.class, "bu_autoBuilder");
	}
}