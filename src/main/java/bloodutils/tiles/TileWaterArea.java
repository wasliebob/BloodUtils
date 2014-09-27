package bloodutils.tiles;

import java.util.ArrayList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class TileWaterArea extends BUTile{
	@Override
	public void updateEntity(){
		ArrayList<EntityPlayer> players = getClosestPlayers(5);
		for(EntityPlayer player : players){
			if(!player.capabilities.isCreativeMode){
				player.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 25));
			}
		}
	}
}