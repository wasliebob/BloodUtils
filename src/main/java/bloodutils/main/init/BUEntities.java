package bloodutils.main.init;

import java.awt.Color;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.item.ItemStack;
import wasliecore.interfaces.IInitalization;
import WayofTime.alchemicalWizardry.api.summoningRegistry.SummoningHelper;
import WayofTime.alchemicalWizardry.api.summoningRegistry.SummoningRegistry;
import WayofTime.alchemicalWizardry.common.summoning.SummoningHelperAW;
import bloodutils.entities.EntityRoyal;
import bloodutils.main.BU;
import cpw.mods.fml.common.registry.EntityRegistry;

public class BUEntities implements IInitalization{
	
	@Override
	public void preInit(){
		EntityRegistry.registerModEntity(EntityRoyal.class, "royal", 55, BU.instance, 128, 3, true);
        registerEntityEgg(EntityRoyal.class, new Color(0, 0, 100).getRGB(), new Color(100, 0, 0).getRGB());
	}

	public static void registerEntityEgg(Class<? extends Entity> entity, int colPrim, int colSec) {
		int id = getUniqueEntityID();
		EntityList.IDtoClassMapping.put(id, entity);
		EntityList.entityEggs.put(id, new EntityList.EntityEggInfo(id, colPrim, colSec));
		return;
	}

	private static int getUniqueEntityID() {
		int startEID = 300;
		do{
			startEID++;
		}while(EntityList.getStringFromID(startEID) != null);
		return startEID;
	}
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postInit() {
	}
}