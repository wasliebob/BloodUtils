package bloodutils.main.init;

import wasliecore.interfaces.IInitalization;
import bloodutils.items.ItemCreativeTool;
import bloodutils.items.ItemGem;
import bloodutils.items.ItemGuide;
import bloodutils.items.ItemMaterial;
import bloodutils.items.sigils.SigilAdvancedDivination;
import bloodutils.items.sigils.SigilRitual;

public class BUItems implements IInitalization{
	@Override
	public void preInit() {
		initItems();
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postInit() {
		// TODO Auto-generated method stub
		
	}
	
	public void initItems(){
		diamond_blood = new ItemMaterial("Blood Diamond", "diamond_blood", "diamondBlood");
		iron_blood = new ItemMaterial("Blood Iron Ingot", "iron_blood", "ironBlood");
		bloodShard_royal = new ItemMaterial("Royal Blood Shard", "bloodShard_royal", "bloodShardRoyal");
		gem_empty = new ItemGem("Empty Gem", "empty");
		gem_earth = new ItemGem("Earth Gem", "earth");
		gem_fire = new ItemGem("Fire Gem", "fire");
		gem_water = new ItemGem("Water Gem", "water");
		gem_air = new ItemGem("Air Gem", "air");
		gem_light = new ItemGem("Light Gem", "light");
		gem_darkness = new ItemGem("Darkness Gem", "darkness");
		gem_rainbow = new ItemGem("Rainbow Gem", "rainbow");

		sigil_ritual = new SigilRitual("Ritual Sigil");
		sigil_advancedDivination = new SigilAdvancedDivination("Advanced Divination Sigil");
		guide = new ItemGuide("Blood Tome");
		tool_creative = new ItemCreativeTool("Creative Tool");
	}
	public static ItemMaterial diamond_blood;
	public static ItemMaterial iron_blood;
	public static ItemMaterial bloodShard_royal;
	public static ItemGem gem_empty;
	public static ItemGem gem_earth;
	public static ItemGem gem_water;
	public static ItemGem gem_fire;
	public static ItemGem gem_air;
	public static ItemGem gem_light;
	public static ItemGem gem_darkness;
	public static ItemGem gem_rainbow;

	public static SigilRitual sigil_ritual;
	public static SigilAdvancedDivination sigil_advancedDivination;
	public static ItemGuide guide;
	public static ItemCreativeTool tool_creative;
}