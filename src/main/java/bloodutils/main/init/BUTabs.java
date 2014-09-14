package bloodutils.main.init;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BUTabs {
    public static CreativeTabs tabMain = new CreativeTabs("tabBloodUtilsMain"){
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem(){
			return Item.getItemFromBlock(BUBlocks.altarProgress);
		}
	};
}