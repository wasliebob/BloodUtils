package bloodutils.tiles;

import java.util.Random;

import org.lwjgl.opengl.GL11;

import wasliecore.helpers.MathHelper;
import net.minecraft.tileentity.TileEntity;
import WayofTime.alchemicalWizardry.common.tileEntity.TEPedestal;
import bloodutils.api.compact.CompactItem;
import bloodutils.api.interfaces.IReviving;
import bloodutils.api.registries.RevivingRegistry;
import bloodutils.main.BU;

public class TileReviver extends BUTile{
	public TileReviver(){
		
	}
	
	@Override
	public void updateEntity(){
		if(BU.proxy.renderView()){
			double x1 = xCoord + 0.15D;
			double y = yCoord +  0.8D;
			double z1 = zCoord + 0.16D;

			BU.proxy.spawnFlame(worldObj, x1, y, z1, 0, 0, 0, 1F);
				
			double x2 = xCoord + 0.85D;
			double z2 = zCoord + 0.16D;
				
			BU.proxy.spawnFlame(worldObj, x2, y, z2, 0, 0, 0, 1F);
				
			double x3 = xCoord + 0.15D;
			double z3 = zCoord + 0.84D;
				
			BU.proxy.spawnFlame(worldObj, x3, y, z3, 0, 0, 0, 1F);
				
			double x4 = xCoord + 0.85D;
			double z4 = zCoord + 0.84D;
				
			BU.proxy.spawnFlame(worldObj, x4, y, z4, 0, 0, 0, 1F);
		}
	}
	
	public void start(){
		TileEntity t1 = worldObj.getTileEntity(xCoord + 2, yCoord, zCoord);
		TileEntity t2 = worldObj.getTileEntity(xCoord - 2, yCoord, zCoord);
		TileEntity t3 = worldObj.getTileEntity(xCoord, yCoord, zCoord + 2);
		TileEntity t4 = worldObj.getTileEntity(xCoord, yCoord, zCoord - 2);
		
		if(t1 != null && t2 != null){
			if(t1 instanceof TEPedestal && t2 instanceof TEPedestal){
				TEPedestal p1 = (TEPedestal)t1;
				TEPedestal p2 = (TEPedestal)t2;
				
				if(p1.getStackInSlot(0) != null && p2.getStackInSlot(0) != null){
					CompactItem item1 = new CompactItem(p1.getStackInSlot(0).getItem(), p2.getStackInSlot(0).getItem());
					CompactItem item2 = new CompactItem(p2.getStackInSlot(0).getItem(), p1.getStackInSlot(0).getItem());
					
					for(CompactItem items : RevivingRegistry.recipes.keySet()){
						if((items.item1 == item1.item1 && items.item2 == item1.item2) || (items.item1 == item2.item1 && items.item2 == item2.item2)){
							p1.setInventorySlotContents(0, null);
							worldObj.markBlockForUpdate(p1.xCoord, p1.yCoord, p1.zCoord);

							p2.setInventorySlotContents(0, null);
							worldObj.markBlockForUpdate(p2.xCoord, p2.yCoord, p2.zCoord);

							IReviving rev = RevivingRegistry.recipes.get(items);
							rev.spawnEntity(worldObj, xCoord, yCoord, zCoord);
							
							continue;
						}
					}
				}
			}
		}else if(t3 != null && t4 != null){
			if(t3 instanceof TEPedestal && t4 instanceof TEPedestal){
				TEPedestal p3 = (TEPedestal)t3;
				TEPedestal p4 = (TEPedestal)t4;
				
				if(p3.getStackInSlot(0) != null && p4.getStackInSlot(0) != null){
					CompactItem item1 = new CompactItem(p3.getStackInSlot(0).getItem(), p4.getStackInSlot(0).getItem());
					CompactItem item2 = new CompactItem(p4.getStackInSlot(0).getItem(), p3.getStackInSlot(0).getItem());
				
					for(CompactItem items : RevivingRegistry.recipes.keySet()){
						if((items.item1 == item1.item1 && items.item2 == item1.item2) || (items.item1 == item2.item1 && items.item2 == item2.item2)){
							p3.setInventorySlotContents(0, null);
							worldObj.markBlockForUpdate(p3.xCoord, p3.yCoord, p3.zCoord);

							p4.setInventorySlotContents(0, null);
							worldObj.markBlockForUpdate(p4.xCoord, p4.yCoord, p4.zCoord);

							IReviving rev = RevivingRegistry.recipes.get(items);
							rev.spawnEntity(worldObj, xCoord, yCoord, zCoord);

							continue;
						}
					}
				}
			}
		}
	}
}