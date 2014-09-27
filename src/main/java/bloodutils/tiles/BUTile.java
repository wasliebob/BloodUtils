package bloodutils.tiles;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import bloodutils.helpers.EffectHelper;

public class BUTile extends TileEntity{
	@Override
	public void updateEntity(){
		
	}
	
	public ArrayList<EntityPlayer> getClosestPlayers(int range){
		return EffectHelper.getClosePlayers(worldObj, xCoord, yCoord, zCoord, range);
	}
	
	public ArrayList<EntityLiving> getClosestEntities(int range){
		return EffectHelper.getCloseEntities(worldObj, xCoord, yCoord, zCoord, range);
	}
	
	public void markForUpdate(){
		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	}
	
	public void setBlock(int x, int y, int z, Block block){
		worldObj.setBlock(x, y, z, block);
	}
	
	public Block getBlock(int x, int y, int z){
		return worldObj.getBlock(x, y, z);
	}
	
	public int getMeta(int x, int y, int z){
		return worldObj.getBlockMetadata(x, y, z);
	}
	
	public boolean isAir(int x, int y, int z){
		Block block = getBlock(x, y, z);
		
		if(block == null)
			return false;
		
		return block.isAir(worldObj, x, y, z);
	}
}