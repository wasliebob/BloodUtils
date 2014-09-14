package bloodutils.rituals;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import WayofTime.alchemicalWizardry.api.rituals.IMasterRitualStone;
import WayofTime.alchemicalWizardry.api.rituals.RitualComponent;
import WayofTime.alchemicalWizardry.api.rituals.RitualEffect;
import WayofTime.alchemicalWizardry.api.soulNetwork.LifeEssenceNetwork;
import WayofTime.alchemicalWizardry.common.spell.complex.effect.SpellHelper;
import WayofTime.alchemicalWizardry.common.tileEntity.TEAltar;
import bloodutils.compact.RangePackage;
import bloodutils.helpers.EssenceHelper;

public class BURitual extends RitualEffect{
	public BURitual(int cost, int delay){
		this.cost = cost;
		this.delay = delay;
	}
	public int cost;
	public int delay;
	
	@Override
	public int getCostPerRefresh() {
		return this.cost;
	}

	@Override
	public List<RitualComponent> getRitualComponentList(){
		ArrayList<RitualComponent> components = new ArrayList();
		
		return getRitualStructure(components);
	}
	
	/** Sub class function */
	public List<RitualComponent> getRitualStructure(ArrayList<RitualComponent> components){
		return components;
	}
	
	@Override
	public void performEffect(IMasterRitualStone stone) {
		String owner = stone.getOwner();
		World worldSave = MinecraftServer.getServer().worldServers[0];
		LifeEssenceNetwork data = EssenceHelper.getLifeEssenceNetwork(owner, worldSave);
		
		int essence = data.currentEssence;
		
		World world = stone.getWorld();
		int x = stone.getXCoord();
		int y = stone.getYCoord();
		int z = stone.getZCoord();
		
		EntityPlayer player = SpellHelper.getPlayerForUsername(owner);
		
		if(world.getWorldTime() % this.delay != 0){
			return;
		}
		
		perform(stone, data, essence, world, x, y, z, player);
	}
	
	/** Sub class function */
	public void perform(IMasterRitualStone stone, LifeEssenceNetwork data, int essence, World world, int x, int y, int z, EntityPlayer owner){
	
	}
	
	public TEAltar getAltar(World world, int x, int y, int z, RangePackage rp){
		for(int xx = rp.minX; xx < rp.maxX; xx++){
			for(int yy = rp.minY; yy < rp.maxY; yy++){
				for(int zz = rp.minZ; zz < rp.maxZ; zz++){
					TileEntity te = world.getTileEntity(x + xx, y + yy, z + zz);
					
					if(te != null && te instanceof TEAltar)
						return (TEAltar)te;
				}
			}
		}
		return null;
	}
	
	public boolean canDecrease(LifeEssenceNetwork data, int amount){
		return data.currentEssence >= amount;
	}
	
	public void decreaseEssence(LifeEssenceNetwork data, int amount){
		if(canDecrease(data, amount))
			data.currentEssence -= amount;
	}
}