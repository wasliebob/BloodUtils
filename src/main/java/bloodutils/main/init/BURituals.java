package bloodutils.main.init;

import wasliecore.interfaces.IInitalization;
import WayofTime.alchemicalWizardry.api.rituals.Rituals;
import bloodutils.rituals.RitualCure;

public class BURituals implements IInitalization{
	@Override
	public void preInit(){
		
	}
	
	@Override
	public void init(){
		Rituals.registerRitual("cure", 1, 500, new RitualCure(50), "Ritual of Curing");
	}

	@Override
	public void postInit(){
	}
}