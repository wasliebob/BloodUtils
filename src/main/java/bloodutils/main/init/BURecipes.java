package bloodutils.main.init;

import java.util.HashMap;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import wasliecore.interfaces.IInitalization;
import WayofTime.alchemicalWizardry.ModBlocks;
import WayofTime.alchemicalWizardry.ModItems;
import WayofTime.alchemicalWizardry.api.altarRecipeRegistry.AltarRecipe;
import bloodutils.api.registries.RecipeRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class BURecipes implements IInitalization{
	@Override
	public void preInit() {
		
	}
	
	@Override
	public void init() {
		
	}

	@Override
	public void postInit() {
		RecipeRegistry.addShapedRecipe(new ItemStack(BUBlocks.altarProgress), new Object[]{
			"XYX",
			"YIY",
			"XYX",
			'X', ModItems.blankSlate,
			'Y', Blocks.stone,
			'I', BUItems.sigil_advancedDivination});
		altarProgress = RecipeRegistry.getLatestCraftingRecipe();
		
		RecipeRegistry.addShapedRecipe(new ItemStack(BUItems.gem_empty), new Object[]{
			"XXX",
			"YIY",
			"XXX",
			'X', Items.gold_ingot,
			'Y', ModItems.sanctus,
			'I', Blocks.glass_pane});
		gemEmpty = RecipeRegistry.getLatestCraftingRecipe();
		
		RecipeRegistry.addShapedRecipe(new ItemStack(BUItems.gem_empty), new Object[]{
			"XXX",
			"YIY",
			"XXX",
			'X', Items.gold_ingot,
			'Y', ModItems.sanctus,
			'I', Blocks.glass_pane});
		gemEmpty = RecipeRegistry.getLatestCraftingRecipe();
		
		RecipeRegistry.addAltarRecipe(new ItemStack(BUItems.sigil_advancedDivination), new ItemStack(ModItems.divinationSigil), 1, 1000, 10, 10, false);
		advancedSigil = RecipeRegistry.getLatestAltarRecipe();
		
		RecipeRegistry.addAltarRecipe(new ItemStack(BUItems.guide), new ItemStack(Items.book), 1, 1000, 10, 10, false);
		guide = RecipeRegistry.getLatestAltarRecipe();
		
		RecipeRegistry.addAltarRecipe(new ItemStack(BUBlocks.block_bloodDiamond), new ItemStack(Blocks.diamond_block), 3, 90000, 90, 90, false);
		diamondBlood = RecipeRegistry.getLatestAltarRecipe();
		
		RecipeRegistry.addAltarRecipe(new ItemStack(BUBlocks.block_bloodIron), new ItemStack(Blocks.iron_block), 2, 20000, 25, 25, false);
		ironBlood = RecipeRegistry.getLatestAltarRecipe();
		
		RecipeRegistry.addAltarRecipe(new ItemStack(BUItems.gem_rainbow), new ItemStack(BUItems.gem_light), 4, 100000, 250, 250, false);
		gemRainbow = RecipeRegistry.getLatestAltarRecipe();
		
		GameRegistry.addShapelessRecipe(new ItemStack(BUItems.sigil_ritual), new ItemStack(ModItems.divinationSigil), new ItemStack(ModBlocks.ritualStone));
	
		GameRegistry.addShapelessRecipe(new ItemStack(BUItems.gem_air), new ItemStack(ModItems.aether), new ItemStack(BUItems.diamond_blood), new ItemStack(BUItems.gem_empty));
		
		GameRegistry.addShapelessRecipe(new ItemStack(BUItems.gem_earth), new ItemStack(ModItems.terrae), new ItemStack(BUItems.diamond_blood), new ItemStack(BUItems.gem_empty));
		GameRegistry.addShapelessRecipe(new ItemStack(BUItems.gem_fire), new ItemStack(ModItems.incendium), new ItemStack(BUItems.diamond_blood), new ItemStack(BUItems.gem_empty));
		GameRegistry.addShapelessRecipe(new ItemStack(BUItems.gem_water), new ItemStack(ModItems.aquasalus), new ItemStack(BUItems.diamond_blood), new ItemStack(BUItems.gem_empty));
	
		GameRegistry.addShapelessRecipe(new ItemStack(BUItems.gem_darkness), new ItemStack(ModItems.tennebrae), new ItemStack(BUItems.diamond_blood), new ItemStack(BUItems.gem_air));
		GameRegistry.addShapelessRecipe(new ItemStack(BUItems.gem_light), new ItemStack(ModItems.sanctus), new ItemStack(BUItems.diamond_blood), new ItemStack(BUItems.gem_air));
	
		GameRegistry.addShapedRecipe(new ItemStack(BUBlocks.block_bloodDiamond), new Object[]{
			"XXX",
			"XXX",
			"XXX",
			'X', BUItems.diamond_blood});
		
		GameRegistry.addShapelessRecipe(new ItemStack(BUItems.diamond_blood, 9, 0), new ItemStack(BUBlocks.block_bloodDiamond));
		
		GameRegistry.addShapedRecipe(new ItemStack(BUBlocks.block_bloodIron), new Object[]{
			"XXX",
			"XXX",
			"XXX",
			'X', BUItems.iron_blood});
		
		GameRegistry.addShapelessRecipe(new ItemStack(BUItems.iron_blood, 9, 0), new ItemStack(BUBlocks.block_bloodIron));
	
		this.blockRituals.put(BUItems.gem_air, BUBlocks.airArea);
		this.blockRituals.put(BUItems.gem_darkness, BUBlocks.darknessArea);
		this.blockRituals.put(BUItems.gem_earth, BUBlocks.earthArea);
		this.blockRituals.put(BUItems.gem_fire, BUBlocks.fireArea);
		this.blockRituals.put(BUItems.gem_light, BUBlocks.lightArea);
		this.blockRituals.put(BUItems.gem_rainbow, BUBlocks.rainbowArea);
		this.blockRituals.put(BUItems.gem_water, BUBlocks.waterArea);

		for(Item item : blockRituals.keySet()){
			Block output = this.blockRituals.get(item);
			GameRegistry.addShapelessRecipe(new ItemStack(output), new ItemStack(item), new ItemStack(ModBlocks.blockMasterStone));
		}
	}
	public static AltarRecipe advancedSigil;
	public static AltarRecipe guide;
	public static AltarRecipe diamondBlood;
	public static AltarRecipe ironBlood;
	public static AltarRecipe gemRainbow;
	
	public static IRecipe altarProgress;
	public static IRecipe gemEmpty;
	
	public static HashMap<Item, Block> blockRituals = new HashMap<Item, Block>();
}