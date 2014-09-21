package bloodutils.main.init;

import wasliecore.interfaces.IInitalization;
import bloodutils.items.ItemCreativeTool;
import bloodutils.items.ItemGuide;
import bloodutils.items.sigils.SigilAdvancedDivination;
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
		sigil_advancedDivination = new SigilAdvancedDivination("Advanced Divination Sigil");
		guide = new ItemGuide("Blood Tome");
		tool_creative = new ItemCreativeTool("Creative Tool");
	}
	public static SigilRitual sigil_ritual;
	public static SigilAdvancedDivination sigil_advancedDivination;
	public static ItemGuide guide;
	public static ItemCreativeTool tool_creative;
}