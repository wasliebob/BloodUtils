package bloodutils.tiles;

import java.util.ArrayList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class TileDarknessArea extends BUTile{
	@Override
	public void updateEntity(){
		ArrayList<EntityPlayer> players = this.getClosestPlayers(5);
		for(EntityPlayer player : players){
			if(!player.capabilities.isCreativeMode){
				player.addPotionEffect(new PotionEffect(Potion.blindness.id, 25));
			}
		}
	}
}