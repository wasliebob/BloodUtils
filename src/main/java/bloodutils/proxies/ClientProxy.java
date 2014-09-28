package bloodutils.proxies;

import net.minecraft.client.Minecraft;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import bloodutils.client.renders.RenderGuide;
import bloodutils.client.renders.RenderRoyal;
import bloodutils.entities.EntityRoyal;
import bloodutils.main.init.BUItems;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy{
	@Override
	public void registerPackets(){
		super.registerPackets();
	}
	
	@Override
	public void registerParticles(){}
	
	@Override
	public void render(){
		MinecraftForgeClient.registerItemRenderer(BUItems.guide, new RenderGuide());
		
		RenderingRegistry.registerEntityRenderingHandler(EntityRoyal.class, new RenderRoyal());
	}
	
	@Override
	public void spawnParticle(World world, String particle, int minX, int minY, int minZ, int maxX, int maxY, int maxZ){
		if(Minecraft.getMinecraft().renderViewEntity != null)
			world.spawnParticle(particle, minX, minY, minZ, maxX, maxY, maxZ);
	}
	
	@Override
	public void spawnSound(World worldObj, int xCoord, int yCoord, int zCoord, String id){}

	@Override
	public boolean renderView(){
		return Minecraft.getMinecraft().renderViewEntity != null;
	}
	
	@Override
	public void bindKeys(){ 
	}
}