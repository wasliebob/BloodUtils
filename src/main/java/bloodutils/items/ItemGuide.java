package bloodutils.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import bloodutils.libs.LibMod;
import bloodutils.main.BU;

public class ItemGuide extends BUItem{
	public ItemGuide(String name) {
		super(name);
		setMaxStackSize(1);
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
	
	@Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5){
    	super.onUpdate(stack, world, entity, par4, par5);
		if(!stack.hasTagCompound())
    		stack.setTagCompound(new NBTTagCompound());
    }

    @Override
    public void onCreated(ItemStack stack, World world, EntityPlayer player){
    	super.onCreated(stack, world, player);
    	if(!stack.hasTagCompound())
    		stack.setTagCompound(new NBTTagCompound());
    }

}