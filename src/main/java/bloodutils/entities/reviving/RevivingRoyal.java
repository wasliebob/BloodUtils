package bloodutils.entities.reviving;

import net.minecraft.world.World;
import bloodutils.api.interfaces.IReviving;
import bloodutils.entities.EntityRoyal;

public class RevivingRoyal implements IReviving{
	@Override
	public void spawnEntity(World world, int x, int y, int z) {
		EntityRoyal.spawn(world, x, y, z);
	}
}