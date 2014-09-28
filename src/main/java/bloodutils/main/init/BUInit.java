package bloodutils.main.init;


public class BUInit{
	public static BUItems items = new BUItems();
	public static BUBlocks blocks = new BUBlocks();
	public static BURituals rituals = new BURituals();
	public static BURecipes recipes = new BURecipes();
	public static BUEntries entries = new BUEntries();
	public static BUEntities entities = new BUEntities();

	public static void preInit() {
		items.preInit();
		blocks.preInit();
		rituals.preInit();
		recipes.preInit();
		entries.preInit();
		entities.preInit();
	}
	
	public static void init() {
		items.init();
		blocks.init();
		rituals.init();
		recipes.init();
		entries.init();
		entities.init();
	}

	public static void postInit() {
		items.postInit();
		blocks.postInit();
		rituals.postInit();
		recipes.postInit();
		entries.postInit();
		entities.postInit();
	}
}