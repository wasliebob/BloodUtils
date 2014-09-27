package bloodutils.tiles;

import java.util.ArrayList;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;

public class TileAirArea extends BUTile{
	@Override
	public void updateEntity(){
		int range = 3;
		ArrayList<EntityLiving> entities = getClosestEntities(range);
		for(EntityLiving living : entities){
			living.motionY += 1F;
		}
		
		ArrayList<EntityPlayer> players = getClosestPlayers(range);
		for(EntityPlayer player : players){
			if(!player.capabilities.isCreativeMode)
				player.motionY += 1F;
		}
	}
}