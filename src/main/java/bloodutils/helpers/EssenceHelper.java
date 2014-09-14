package bloodutils.helpers;

import net.minecraft.world.World;
import WayofTime.alchemicalWizardry.api.soulNetwork.LifeEssenceNetwork;

public class EssenceHelper {
	public static LifeEssenceNetwork getLifeEssenceNetwork(String owner, World worldSave){
		return (LifeEssenceNetwork) worldSave.loadItemData(LifeEssenceNetwork.class, owner);
	}
}