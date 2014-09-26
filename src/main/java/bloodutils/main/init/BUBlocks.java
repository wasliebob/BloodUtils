package bloodutils.main.init;

import net.minecraft.block.material.Material;
import wasliecore.interfaces.IInitalization;
import bloodutils.blocks.BlockAltarBuilder;
import bloodutils.blocks.BlockAltarProgress;
import bloodutils.blocks.BlockMaterial;
import cpw.mods.fml.common.registry.GameRegistry;

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
		block_bloodDiamond = new BlockMaterial("Blood Diamond Block", Material.iron, "block_bloodDiamond");
		altarBuilder = new BlockAltarBuilder("Altar Builder");
		altarProgress = new BlockAltarProgress("Altar Progression Checker");
	}
	public static BlockMaterial block_bloodDiamond;
	public static BlockAltarBuilder altarBuilder;
	public static BlockAltarProgress altarProgress;
	
	public void initTiles(){
		GameRegistry.registerTileEntity(bloodutils.tiles.TileAltarBuilder.class, "bu_autoBuilder");
	}
}