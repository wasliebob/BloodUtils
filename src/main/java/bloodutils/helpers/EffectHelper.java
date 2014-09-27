package bloodutils.helpers;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class EffectHelper {
	public static ArrayList<EntityLiving> getCloseEntities(World world, double x, double y, double z, double range){
		ArrayList<EntityLiving> living = new ArrayList<EntityLiving>();
		
		AxisAlignedBB bb = AxisAlignedBB.getBoundingBox(x - range, y - range, z - range, x + range, y + range, z + range);
		
		List<Entity> entities = world.selectEntitiesWithinAABB(EntityLiving.class, bb, EffectHelper.getLivingSelector());
		
		for(Entity e : entities)
			living.add((EntityLiving)e);
		
		return living;
	}
	
	public static IEntitySelector getLivingSelector(){
		return new EntitySelectorLiving();
	}
	
	public static class EntitySelectorLiving implements IEntitySelector{
		@Override
		public boolean isEntityApplicable(Entity entity) {
			return entity != null && entity instanceof EntityLiving;
		}
	}
	
	public static ArrayList<EntityPlayer> getClosePlayers(World world, double x, double y, double z, double range){
		ArrayList<EntityPlayer> players = new ArrayList<EntityPlayer>();
		
		AxisAlignedBB bb = AxisAlignedBB.getBoundingBox(x - range, y - range, z - range, x + range, y + range, z + range);
		
		List<Entity> entities = world.selectEntitiesWithinAABB(EntityPlayer.class, bb, EffectHelper.getPlayerSelector());
		
		for(Entity e : entities)
			players.add((EntityPlayer)e);
		
		return players;
	}
	
	public static IEntitySelector getPlayerSelector(){
		return new EntitySelectorPlayer();
	}
	
	public static class EntitySelectorPlayer implements IEntitySelector{
		@Override
		public boolean isEntityApplicable(Entity entity) {
			return entity != null && entity instanceof EntityPlayer;
		}
	}
}