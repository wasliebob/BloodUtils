package bloodutils.items.sigils;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import wasliecore.helpers.Utils;
import WayofTime.alchemicalWizardry.api.rituals.Rituals;
import WayofTime.alchemicalWizardry.common.tileEntity.TEMasterStone;
import bloodutils.items.BUItem;
import bloodutils.libs.LibMod;

public class SigilRitual extends BUItem{
	public SigilRitual(String name) {
		super(name);
		setMaxStackSize(1);
	}

	@Override
    public void registerIcons(IIconRegister ir){
        itemIcon = ir.registerIcon(LibMod.modName.toLowerCase() + ":" + "sigil_ritual");
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player){
		if(!world.isRemote){
			TileEntity te = Utils.getTargetTile(player);
			if(te != null && te instanceof TEMasterStone){
				TEMasterStone master = (TEMasterStone)te;
				String owner = master.getOwner();
				String ritualKey = Rituals.checkValidRitual(world, master.xCoord, master.yCoord, master.zCoord);
				String ritual = Rituals.getNameOfRitual(ritualKey);
				
				if(owner != null && owner != "" && ritual != null && ritual != ""){
					player.addChatComponentMessage(new ChatComponentText("Owner: " + owner));
					player.addChatComponentMessage(new ChatComponentText("Ritual: " + ritual));
				}
			}
		}
		return stack;
	}
}