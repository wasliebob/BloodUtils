package bloodutils.main.init;

import wasliecore.interfaces.IInitalization;

public class BUInit{
	public static BUItems items = new BUItems();
	public static BUBlocks blocks = new BUBlocks();
	public static BURituals rituals = new BURituals();
	public static BUEntries entries = new BUEntries();
	public static BURecipes recipes = new BURecipes();

	public static void preInit() {
		items.preInit();
		blocks.preInit();
		rituals.preInit();
		recipes.preInit();
		entries.preInit();
	}
	
	public static void init() {
		items.init();
		blocks.init();
		rituals.init();
		recipes.init();
		entries.init();
	}

	public static void postInit() {
		items.postInit();
		blocks.postInit();
		rituals.postInit();
		recipes.postInit();
		entries.postInit();
	}
}