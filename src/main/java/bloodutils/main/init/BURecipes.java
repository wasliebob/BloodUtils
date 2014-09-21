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
		
		RecipeRegistry.addAltarRecipe(new ItemStack(BUItems.sigil_advancedDivination), new ItemStack(ModItems.divinationSigil), 2, 1000, 10, 10, false);
		advancedSigil = RecipeRegistry.getLatestAltarRecipe();
		
		RecipeRegistry.addAltarRecipe(new ItemStack(BUItems.guide), new ItemStack(Items.book), 1, 1000, 10, 10, false);
		guide = RecipeRegistry.getLatestAltarRecipe();
		
		GameRegistry.addShapelessRecipe(new ItemStack(BUItems.sigil_ritual), new ItemStack(ModItems.divinationSigil), new ItemStack(ModBlocks.ritualStone));
	}
	public static AltarRecipe advancedSigil;
	public static AltarRecipe guide;

	public static IRecipe altarProgress;
}