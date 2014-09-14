package bloodutils.main.init;

import wasliecore.interfaces.IInitalization;

public class BUInit implements IInitalization{
	public static BUItems items = new BUItems();
	public static BUBlocks blocks = new BUBlocks();
	public static BURituals rituals = new BURituals();
	public static BUEntries entries = new BUEntries();
	public static BURecipes recipes = new BURecipes();

	@Override
	public void preInit() {
		items.preInit();
		blocks.preInit();
		rituals.preInit();
		recipes.preInit();
		entries.preInit();
	}
	
	@Override
	public void init() {
		items.init();
		blocks.init();
		rituals.init();
		recipes.init();
		entries.init();
	}

	@Override
	public void postInit() {
		items.postInit();
		blocks.postInit();
		rituals.postInit();
		recipes.postInit();
		entries.postInit();
	}
}