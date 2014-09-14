package bloodutils.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import bloodutils.libs.LibMod;
import bloodutils.main.BU;

public class ItemGuide extends BUItem{
	public ItemGuide(String name) {
		super(name);
	}

	@Override
	public void registerIcons(IIconRegister ir){
		itemIcon = ir.registerIcon(LibMod.modName.toLowerCase() + ":" + "guide");
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player){
		player.openGui(BU.instance, 0, world, (int)player.posX, (int)player.posY, (int)player.posZ);
		return stack;
	}
}