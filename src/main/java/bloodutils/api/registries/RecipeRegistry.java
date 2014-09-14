package bloodutils.api.registries;

import java.util.ArrayList;

import bloodutils.api.helpers.OreDictionaryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class RecipeRegistry {
public static ArrayList<IRecipe> recipes = new ArrayList<IRecipe>();
	
	/** Used to register items to the guide */
	public static IRecipe getLatest(){
		IRecipe rec = (IRecipe)CraftingManager.getInstance().getRecipeList().get(CraftingManager.getInstance().getRecipeList().size() -1);
		recipes.add(rec);
		return recipes.get(recipes.size() - 1);
	}
	
	public static void addShapedRecipe(ItemStack output, Object[] obj){
		GameRegistry.addShapedRecipe(output, obj);
	}
	
	public static void addShapedOreRecipe(ItemStack output, Object[] obj){
		GameRegistry.addRecipe(new ShapedOreRecipe(output, obj));
	}
	
	public static void addDustSmeltingRecipe(String name){
		if(OreDictionaryHelper.entryExists("dust" + name) && OreDictionaryHelper.entryExists("ingot" + name))
			GameRegistry.addSmelting(OreDictionary.getOres("dust" + name).get(0), OreDictionary.getOres("ingot" + name).get(0), 0);
	}
}