package bloodutils.main.init;

import java.awt.Color;

import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import wasliecore.interfaces.IInitalization;
import bloodutils.blocks.BUBlockStairs;
import bloodutils.blocks.BlockAltarBuilder;
import bloodutils.blocks.BlockAltarProgress;
import bloodutils.blocks.BlockEarth;
import bloodutils.blocks.BlockMagicArea;
import bloodutils.blocks.BlockMaterial;
import bloodutils.blocks.BlockReviver;
import bloodutils.blocks.blockEffect.BlockEffectAir;
import bloodutils.blocks.blockEffect.BlockEffectDarkness;
import bloodutils.blocks.blockEffect.BlockEffectEarth;
import bloodutils.blocks.blockEffect.BlockEffectFire;
import bloodutils.blocks.blockEffect.BlockEffectLight;
import bloodutils.blocks.blockEffect.BlockEffectRainbow;
import bloodutils.blocks.blockEffect.BlockEffectWater;
import bloodutils.blocks.fluids.BUBlockFluid;
import bloodutils.blocks.fluids.BUFluid;
import bloodutils.main.Config;
import cpw.mods.fml.common.registry.GameRegistry;

public class BUBlocks implements IInitalization{
	@Override
	public void preInit() {
		initFluids();
		initBlocks();
	}
	
	@Override
	public void init() {
		initTiles();
	}

	@Override
	public void postInit() {
		
	}
	
	public void initFluids(){
		darknessElementFluid = new BUFluid("Darkness Essence", 2000, 2000, new Color(0, 0, 0).getRGB());
        FluidRegistry.registerFluid(darknessElementFluid);

		lightElementFluid = new BUFluid("Light Essence", 2000, 2000, new Color(255, 255, 255).getRGB());
        FluidRegistry.registerFluid(lightElementFluid);
        
		rainbowElementFluid = new BUFluid("Rainbow Essence", 2000, 2000, new Color(255, 255, 255).getRGB());
        FluidRegistry.registerFluid(rainbowElementFluid);
	}
    public static Fluid darknessElementFluid;
    public static Fluid lightElementFluid;
    public static Fluid rainbowElementFluid;

	public void initBlocks(){
		earthDummy = new BlockEarth();
		
		if(Config.discoball){
			discoball = new BlockMaterial("Discoball", Material.iron, "discoball");
			discoball.setLightLevel(1F);
			
			stairs_discoball = new BUBlockStairs(BUBlocks.discoball, 0);
			discoball.setLightLevel(1F);
		}
		
		elementDarknessFluid = new BUBlockFluid("Darkness Essence", "essence_darkness", BUBlocks.darknessElementFluid);
		elementLightFluid = new BUBlockFluid("Light Essence", "essence_light", BUBlocks.lightElementFluid);
		elementRainbowFluid = new BUBlockFluid("Rainbow Essence", "essence_rainbow", BUBlocks.rainbowElementFluid);

		block_bloodDiamond = new BlockMaterial("Blood Diamond Block", Material.iron, "block_bloodDiamond");
		block_bloodIron = new BlockMaterial("Blood Iron Block", Material.iron, "block_bloodIron");

		altarBuilder = new BlockAltarBuilder("Altar Builder");
		altarProgress = new BlockAltarProgress("Altar Progression Checker");
		reviver = new BlockReviver("Reviver");
		
		earthArea = new BlockMagicArea("Area Earth", "earth", new BlockEffectEarth());
		fireArea = new BlockMagicArea("Area Fire", "fire", new BlockEffectFire());
		airArea = new BlockMagicArea("Area Air", "air", new BlockEffectAir());
		waterArea = new BlockMagicArea("Area Water", "water", new BlockEffectWater());
		darknessArea = new BlockMagicArea("Area darkness", "darkness", new BlockEffectDarkness());
		lightArea = new BlockMagicArea("Area Light", "light", new BlockEffectLight());
		rainbowArea = new BlockMagicArea("Area Rainbow", "rainbow", new BlockEffectRainbow());

	}
	public static BlockEarth earthDummy;
	public static BlockMaterial discoball;
	public static BUBlockStairs stairs_discoball;

	public static BUBlockFluid elementDarknessFluid;
	public static BUBlockFluid elementLightFluid;
	public static BUBlockFluid elementRainbowFluid;

	public static BlockMaterial block_bloodDiamond;
	public static BlockMaterial block_bloodIron;
	public static BlockAltarBuilder altarBuilder;
	public static BlockAltarProgress altarProgress;
	public static BlockReviver reviver;;

	public static BlockMagicArea earthArea;
	public static BlockMagicArea fireArea;
	public static BlockMagicArea airArea;
	public static BlockMagicArea waterArea;
	public static BlockMagicArea darknessArea;
	public static BlockMagicArea lightArea;
	public static BlockMagicArea rainbowArea;

	public void initTiles(){
		GameRegistry.registerTileEntity(bloodutils.tiles.TileAltarBuilder.class, "bu_autoBuilder");
		GameRegistry.registerTileEntity(bloodutils.tiles.TileReviver.class, "bu_reviver");

		GameRegistry.registerTileEntity(bloodutils.tiles.TileEarthArea.class, "bu_effectEarth");
		GameRegistry.registerTileEntity(bloodutils.tiles.TileAirArea.class, "bu_effectAir");
		GameRegistry.registerTileEntity(bloodutils.tiles.TileFireArea.class, "bu_effectFire");
		GameRegistry.registerTileEntity(bloodutils.tiles.TileWaterArea.class, "bu_effectWater");
		GameRegistry.registerTileEntity(bloodutils.tiles.TileDarknessArea.class, "bu_effectDarkness");
		GameRegistry.registerTileEntity(bloodutils.tiles.TileLightArea.class, "bu_effectLight");
		GameRegistry.registerTileEntity(bloodutils.tiles.TileRainbowArea.class, "bu_effectRainbow");

	}
}