package bloodutils.main.init;

import wasliecore.interfaces.IInitalization;
import bloodutils.items.ItemGuide;
import bloodutils.items.sigils.SigilRitual;

public class BUItems implements IInitalization{
	@Override
	public void preInit() {
		initItems();
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postInit() {
		// TODO Auto-generated method stub
		
	}
	
	public void initItems(){
		sigil_ritual = new SigilRitual("Ritual Sigil");
		
		guide = new ItemGuide("Blood Tome");
	}
	public static SigilRitual sigil_ritual;
	public static ItemGuide guide;
}