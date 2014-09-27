package bloodutils.main;

import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class Config {
	public static void loadConfig(FMLPreInitializationEvent e){
		Configuration config = new Configuration(e.getSuggestedConfigurationFile());
		discoball = config.get(Configuration.CATEGORY_GENERAL, "discoFever", false).getBoolean(discoball);
		
		config.save();
	}
	public static boolean discoball;
}