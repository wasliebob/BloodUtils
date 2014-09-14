package bloodutils.rituals;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import WayofTime.alchemicalWizardry.api.rituals.IMasterRitualStone;
import WayofTime.alchemicalWizardry.api.rituals.RitualComponent;
import WayofTime.alchemicalWizardry.api.soulNetwork.LifeEssenceNetwork;
import bloodutils.helpers.EffectHelper;

public class RitualCure extends BURitual{
	public RitualCure(int cost){
		super(cost, 200);
	}

	@Override
	public List<RitualComponent> getRitualStructure(ArrayList<RitualComponent> components){		
		/** Core Structure */
		components.add(new RitualComponent(1, 0, 0, RitualComponent.EARTH));
		components.add(new RitualComponent(-1, 0, 0, RitualComponent.EARTH));
		components.add(new RitualComponent(0, 0, 1, RitualComponent.FIRE));
		components.add(new RitualComponent(0, 0, -1, RitualComponent.FIRE));

		components.add(new RitualComponent(1, 0, 1, RitualComponent.DUSK));
		components.add(new RitualComponent(-1, 0, 1, RitualComponent.DUSK));
		components.add(new RitualComponent(1, 0, -1, RitualComponent.DUSK));
		components.add(new RitualComponent(-1, 0, -1, RitualComponent.DUSK));

		/** Side Structure */
		/** Layer 1*/
		components.add(new RitualComponent(-2, 1, -2, RitualComponent.FIRE));
		components.add(new RitualComponent(-2, 1, 2, RitualComponent.FIRE));
		
		components.add(new RitualComponent(2, 1, -2, RitualComponent.FIRE));
		components.add(new RitualComponent(2, 1, 2, RitualComponent.FIRE));

		/** Layer 2*/
		components.add(new RitualComponent(-2, 2, -2, RitualComponent.AIR));
		components.add(new RitualComponent(-2, 2, 2, RitualComponent.AIR));
		
		components.add(new RitualComponent(2, 2, -2, RitualComponent.AIR));
		components.add(new RitualComponent(2, 2, 2, RitualComponent.AIR));
		
		/** Layer 3*/
		components.add(new RitualComponent(-2, 3, -2, RitualComponent.WATER));
		components.add(new RitualComponent(-2, 3, 2, RitualComponent.WATER));
		
		components.add(new RitualComponent(2, 3, -2, RitualComponent.WATER));
		components.add(new RitualComponent(2, 3, 2, RitualComponent.WATER));
		
		/** Layer 4*/
		components.add(new RitualComponent(-2, 4, -2, RitualComponent.EARTH));
		components.add(new RitualComponent(-2, 4, 2, RitualComponent.EARTH));
		
		components.add(new RitualComponent(2, 4, -2, RitualComponent.EARTH));
		components.add(new RitualComponent(2, 4, 2, RitualComponent.EARTH));
		
		/** Ring */
		/** Part 1 */
		components.add(new RitualComponent(-3, 4, -2, RitualComponent.DUSK));
		components.add(new RitualComponent(-3, 4, -1, RitualComponent.DUSK));
		components.add(new RitualComponent(-3, 4, 0, RitualComponent.DUSK));
		components.add(new RitualComponent(-3, 4, 1, RitualComponent.DUSK));
		components.add(new RitualComponent(-3, 4, 2, RitualComponent.DUSK));

		components.add(new RitualComponent(-2, 4, -3, RitualComponent.DUSK));
		components.add(new RitualComponent(-1, 4, -3, RitualComponent.DUSK));
		components.add(new RitualComponent(0, 4, -3, RitualComponent.DUSK));
		components.add(new RitualComponent(1, 4, -3, RitualComponent.DUSK));
		components.add(new RitualComponent(2, 4, -3, RitualComponent.DUSK));

		/** Part 2 */
		components.add(new RitualComponent(3, 4, -2, RitualComponent.DUSK));
		components.add(new RitualComponent(3, 4, -1, RitualComponent.DUSK));
		components.add(new RitualComponent(3, 4, 0, RitualComponent.DUSK));
		components.add(new RitualComponent(3, 4, 1, RitualComponent.DUSK));
		components.add(new RitualComponent(3, 4, 2, RitualComponent.DUSK));

		//TODO TEST
		components.add(new RitualComponent(-2, 4, 3, RitualComponent.DUSK));
		components.add(new RitualComponent(-1, 4, 3, RitualComponent.DUSK));
		components.add(new RitualComponent(0, 4, 3, RitualComponent.DUSK));
		components.add(new RitualComponent(1, 4, 3, RitualComponent.DUSK));
		components.add(new RitualComponent(2, 4, 3, RitualComponent.DUSK));
		
		return components;
	}

	@Override
	public void perform(IMasterRitualStone stone, LifeEssenceNetwork data, int essence, World world, int x, int y, int z, EntityPlayer owner){
		ArrayList<EntityPlayer> players = EffectHelper.getClosePlayers(world, x, y, z, 2D);
		for(EntityPlayer player : players){
			player.curePotionEffects(new ItemStack(Items.milk_bucket));
			this.decreaseEssence(data, this.cost);
		}
	}
}