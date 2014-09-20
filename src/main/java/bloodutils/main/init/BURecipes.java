package bloodutils.main.init;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import wasliecore.interfaces.IInitalization;
import WayofTime.alchemicalWizardry.ModBlocks;
import WayofTime.alchemicalWizardry.ModItems;
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
		GameRegistry.addShapedRecipe(new ItemStack(BUBlocks.altarProgress), new Object[]{
			"XYX",
			"YIY",
			"XYX",
			'X', ModItems.blankSlate,
			'Y', Blocks.stone,
			'I', ModItems.divinationSigil});
		
		GameRegistry.addShapelessRecipe(new ItemStack(BUItems.sigil_ritual), new ItemStack(ModItems.divinationSigil), new ItemStack(ModBlocks.ritualStone));
	}
}