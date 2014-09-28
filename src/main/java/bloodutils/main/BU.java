package bloodutils.main;

import bloodutils.handlers.GuiHandler;
import bloodutils.libs.LibMod;
import bloodutils.main.init.BUInit;
import bloodutils.proxies.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

@Mod(modid = LibMod.modId, name = LibMod.modName, version = LibMod.modVersion, dependencies = LibMod.deps)
public class BU {
    @SidedProxy(clientSide = "bloodutils.proxies.ClientProxy", serverSide = "bloodutils.proxies.CommonProxy")
    public static CommonProxy proxy;
 
    @Instance("BloodUtils")
    public static BU instance;
    
	@EventHandler
    public void preInit(FMLPreInitializationEvent event){
		proxy.preInit();
		Config.loadConfig(event);
		BUInit.preInit();
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event){
    	proxy.init();
    	BUInit.init();
    	
    	NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent evt){
    	proxy.postInit();
    	BUInit.postInit();
    }
}