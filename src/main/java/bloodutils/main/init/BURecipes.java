package bloodutils.main.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import wasliecore.interfaces.IInitalization;
import WayofTime.alchemicalWizardry.ModBlocks;
import WayofTime.alchemicalWizardry.ModItems;
import WayofTime.alchemicalWizardry.api.altarRecipeRegistry.AltarRecipe;
import WayofTime.alchemicalWizardry.api.altarRecipeRegistry.AltarRecipeRegistry;
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
		
		RecipeRegistry.addAltarRecipe(new ItemStack(BUItems.sigil_advancedDivination), new ItemStack(ModItems.divinationSigil), 2, 1000, 10, 10, false);
		advancedSigil = RecipeRegistry.getLatestAltarRecipe();
		
		RecipeRegistry.addAltarRecipe(new ItemStack(BUItems.guide), new ItemStack(Items.book), 1, 1000, 10, 10, false);
		guide = RecipeRegistry.getLatestAltarRecipe();
		
		RecipeRegistry.addAltarRecipe(new ItemStack(BUBlocks.block_bloodDiamond), new ItemStack(Blocks.diamond_block), 4, 90000, 90, 90, false);
		diamondBlood = RecipeRegistry.getLatestAltarRecipe();
		
		GameRegistry.addShapelessRecipe(new ItemStack(BUItems.sigil_ritual), new ItemStack(ModItems.divinationSigil), new ItemStack(ModBlocks.ritualStone));
	
		GameRegistry.addShapelessRecipe(new ItemStack(BUItems.gem_air), new ItemStack(ModItems.aether), new ItemStack(BUItems.diamond_blood), new ItemStack(BUItems.gem_empty));
		GameRegistry.addShapelessRecipe(new ItemStack(BUItems.gem_earth), new ItemStack(ModItems.terrae), new ItemStack(BUItems.diamond_blood), new ItemStack(BUItems.gem_empty));
		GameRegistry.addShapelessRecipe(new ItemStack(BUItems.gem_fire), new ItemStack(ModItems.incendium), new ItemStack(BUItems.diamond_blood), new ItemStack(BUItems.gem_empty));
		GameRegistry.addShapelessRecipe(new ItemStack(BUItems.gem_water), new ItemStack(ModItems.aquasalus), new ItemStack(BUItems.diamond_blood), new ItemStack(BUItems.gem_empty));
	}
	public static AltarRecipe advancedSigil;
	public static AltarRecipe guide;
	public static AltarRecipe diamondBlood;
	
	public static IRecipe altarProgress;
	public static IRecipe gemEmpty;
}