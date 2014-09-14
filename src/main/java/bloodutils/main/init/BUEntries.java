package bloodutils.main.init;

import net.minecraft.item.ItemStack;
import wasliecore.interfaces.IInitalization;
import WayofTime.alchemicalWizardry.ModItems;
import bloodutils.api.compact.Category;
import bloodutils.api.compact.Entry;
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
		EntryRegistry.categories.add(BUEntries.categoryBasics);
		EntryRegistry.categories.add(BUEntries.categoryRituals);
		EntryRegistry.categories.add(BUEntries.categoryBloodUtils);
	}
	
	public void initEntries(){
		theAltar = new Entry(new IEntry[]{new EntryText()}, "The Altar", 1);
		
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
		registerEntries();
	}
	public static Entry theAltar;
	
	public static Entry ritualCure;

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
	
	public void registerEntries(){
		EntryRegistry.registerEntry(BUEntries.categoryBasics, EntryRegistry.basics, BUEntries.theAltar);
		
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

	}
	
	@Override
	public void postInit(){
		
	}
}