package bloodutils.main.init;

import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import wasliecore.interfaces.IInitalization;
import WayofTime.alchemicalWizardry.ModBlocks;
import WayofTime.alchemicalWizardry.ModItems;
import bloodutils.api.compact.Category;
import bloodutils.api.compact.Entry;
import bloodutils.api.entries.EntryAltarRecipe;
import bloodutils.api.entries.EntryCraftingRecipe;
import bloodutils.api.entries.EntryImage;
import bloodutils.api.entries.EntryItemText;
import bloodutils.api.entries.EntryRitualInfo;
import bloodutils.api.entries.EntryText;
import bloodutils.api.entries.IEntry;
import bloodutils.api.enums.EnumType;
import bloodutils.api.registries.EntryRegistry;

public class BUEntries implements IInitalization{
	
	@Override
	public void preInit(){
		
	}
	
	@Override
	public void init(){
		
	}
	
	
	@Override
	public void postInit(){
		initCategories();
		initEntries();	
	}
	
	public void initCategories(){
		categoryBasics = new Category("Basics", new ItemStack(ModItems.weakBloodOrb), EnumType.ITEM);
		categoryRituals = new Category("Rituals", new ItemStack(ModItems.itemRitualDiviner), EnumType.ITEM);
		categoryBloodUtils = new Category("Blood Utils", new ItemStack(BUItems.sigil_ritual), EnumType.ITEM);
		registerCategories();
	}
	public static Category categoryBasics;
	public static Category categoryRituals;
	public static Category categoryBloodUtils;
	
	public void registerCategories(){
		EntryRegistry.registerCategories(BUEntries.categoryBasics);
		EntryRegistry.registerCategories(BUEntries.categoryRituals);
		EntryRegistry.registerCategories(BUEntries.categoryBloodUtils);
	}
	
	public void initEntries(){
		theAltar = new Entry(new IEntry[]{new EntryItemText(new ItemStack(ModBlocks.blockAltar), "Blood Altar")}, EnumChatFormatting.BLUE + "Blood Altar", 1);
		runes = new Entry(new IEntry[]{new EntryItemText(new ItemStack(ModBlocks.runeOfSelfSacrifice)), new EntryItemText(new ItemStack(ModBlocks.runeOfSacrifice)), new EntryItemText(new ItemStack(ModBlocks.speedRune))}, "Runes", 1);
		
		/** Page 1 */
		ritualWater = new Entry(new IEntry[]{new EntryText()}, "Full Spring", 1);
		ritualLava = new Entry(new IEntry[]{new EntryText(), new EntryText()}, "Nether", 1);
		ritualGreenGrove = new Entry(new IEntry[]{new EntryText(), new EntryText()}, "Green Grove", 1);
		ritualInterdiction = new Entry(new IEntry[]{new EntryText(), new EntryText()}, "Interdiction", 1);
		ritualContainment = new Entry(new IEntry[]{new EntryText()}, "Containment", 1);
		ritualHighJump = new Entry(new IEntry[]{new EntryText()}, "High Jump", 1);
		ritualSpeed = new Entry(new IEntry[]{new EntryText()}, "Speed", 1);
		ritualMagnet = new Entry(new IEntry[]{new EntryText()}, "Magnetism", 1);
		ritualCrusher = new Entry(new IEntry[]{new EntryText()}, "Crusher", 1);
		ritualShepherd = new Entry(new IEntry[]{new EntryText()}, "Shepherd", 1);
		ritualRegeneration = new Entry(new IEntry[]{new EntryText(), new EntryText(), new EntryText()}, "Regeneration", 1);
		ritualFeatheredKnife = new Entry(new IEntry[]{new EntryText(), new EntryText(), new EntryText(), new EntryText()}, "Feathered Knife", 1);
		ritualMoon = new Entry(new IEntry[]{new EntryText()}, "Harvest Moon", 1);
		ritualSoul = new Entry(new IEntry[]{new EntryText(), new EntryText()}, "Eternal Soul", 1);
		
		ritualCure = new Entry(new IEntry[]{new EntryText(), new EntryRitualInfo(500)}, "Curing", 1);
		blockDivination = new Entry(new IEntry[]{new EntryItemText(new ItemStack(BUBlocks.altarProgress)), new EntryCraftingRecipe(BURecipes.altarProgress)}, "Divination Block", 1);
		sigilAdvancedDivination = new Entry(new IEntry[]{new EntryItemText(new ItemStack(BUItems.sigil_advancedDivination)), new EntryAltarRecipe(BURecipes.advancedSigil)}, "Advanced Divination", 1);
		
		elementRituals = new Entry(new IEntry[]{new EntryItemText(new ItemStack(BUBlocks.darknessArea)), new EntryText(), new EntryCraftingRecipe(BURecipes.gemEmpty), new EntryAltarRecipe(BURecipes.diamondBlood)}, "Elemental Rituals", 1);
		reviving = new Entry(new IEntry[]{new EntryText(), new EntryCraftingRecipe(BURecipes.reviver)}, "Reviving", 1);
		
		/** Debug */
		debug = new Entry(new IEntry[]{new EntryText("Debug"), new EntryImage("bloodutils:textures/misc/screenshots/t1.png", 854, 480, "Debug")}, EnumChatFormatting.AQUA + "De" + EnumChatFormatting.RED + "bug", 1);
		registerEntries();
	}
	public static Entry theAltar;
	public static Entry runes;
	
	public static Entry ritualCure;
	public static Entry sigilAdvancedDivination;
	public static Entry blockDivination;

	public static Entry ritualWater;
	public static Entry ritualLava;
	public static Entry ritualGreenGrove;
	public static Entry ritualInterdiction;
	public static Entry ritualContainment;
	public static Entry ritualHighJump;
	public static Entry ritualSpeed;
	public static Entry ritualMagnet;
	public static Entry ritualCrusher;
	public static Entry ritualShepherd;
	public static Entry ritualRegeneration;
	public static Entry ritualFeatheredKnife;
	public static Entry ritualMoon;
	public static Entry ritualSoul;
	
	public static Entry elementRituals;
	public static Entry reviving;

	public static Entry debug;
	
	public void registerEntries(){
		EntryRegistry.registerEntry(BUEntries.categoryBasics, EntryRegistry.basics, BUEntries.theAltar);
		EntryRegistry.registerEntry(BUEntries.categoryBasics, EntryRegistry.basics, BUEntries.runes);
		
		EntryRegistry.registerEntry(BUEntries.categoryRituals, EntryRegistry.rituals, BUEntries.ritualWater);
		EntryRegistry.registerEntry(BUEntries.categoryRituals, EntryRegistry.rituals, BUEntries.ritualLava);
		EntryRegistry.registerEntry(BUEntries.categoryRituals, EntryRegistry.rituals, BUEntries.ritualGreenGrove);
		EntryRegistry.registerEntry(BUEntries.categoryRituals, EntryRegistry.rituals, BUEntries.ritualInterdiction);
		EntryRegistry.registerEntry(BUEntries.categoryRituals, EntryRegistry.rituals, BUEntries.ritualContainment);
		EntryRegistry.registerEntry(BUEntries.categoryRituals, EntryRegistry.rituals, BUEntries.ritualHighJump);
		EntryRegistry.registerEntry(BUEntries.categoryRituals, EntryRegistry.rituals, BUEntries.ritualSpeed);
		EntryRegistry.registerEntry(BUEntries.categoryRituals, EntryRegistry.rituals, BUEntries.ritualMagnet);
		EntryRegistry.registerEntry(BUEntries.categoryRituals, EntryRegistry.rituals, BUEntries.ritualCrusher);
		EntryRegistry.registerEntry(BUEntries.categoryRituals, EntryRegistry.rituals, BUEntries.ritualShepherd);
		EntryRegistry.registerEntry(BUEntries.categoryRituals, EntryRegistry.rituals, BUEntries.ritualRegeneration);
		EntryRegistry.registerEntry(BUEntries.categoryRituals, EntryRegistry.rituals, BUEntries.ritualFeatheredKnife);
		EntryRegistry.registerEntry(BUEntries.categoryRituals, EntryRegistry.rituals, BUEntries.ritualMoon);
		EntryRegistry.registerEntry(BUEntries.categoryRituals, EntryRegistry.rituals, BUEntries.ritualSoul);
	
		EntryRegistry.registerEntry(BUEntries.categoryBloodUtils, EntryRegistry.bloodUtils, BUEntries.ritualCure);
		EntryRegistry.registerEntry(BUEntries.categoryBloodUtils, EntryRegistry.bloodUtils, BUEntries.blockDivination);
		EntryRegistry.registerEntry(BUEntries.categoryBloodUtils, EntryRegistry.bloodUtils, BUEntries.sigilAdvancedDivination);
		EntryRegistry.registerEntry(BUEntries.categoryBloodUtils, EntryRegistry.bloodUtils, BUEntries.elementRituals);
		EntryRegistry.registerEntry(BUEntries.categoryBloodUtils, EntryRegistry.bloodUtils, BUEntries.reviving);

		/** Debug */
		EntryRegistry.registerEntry(BUEntries.categoryBasics, EntryRegistry.basics, BUEntries.debug);
	}
}