package bloodutils.proxies;

import net.minecraft.client.Minecraft;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import bloodutils.client.renders.RenderGuide;
import bloodutils.client.renders.RenderReviver;
import bloodutils.client.renders.RenderRoyal;
import bloodutils.client.renders.RenderTileReviver;
import bloodutils.entities.EntityRoyal;
import bloodutils.entities.entityFX.EntityFireFX;
import bloodutils.main.init.BUItems;
import bloodutils.tiles.TileReviver;
import cpw.mods.fml.client.registry.ClientRegistry;
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
		
		RenderingRegistry.registerBlockHandler(new RenderReviver());
		ClientRegistry.bindTileEntitySpecialRenderer(TileReviver.class, new RenderTileReviver());
		
		RenderingRegistry.registerEntityRenderingHandler(EntityRoyal.class, new RenderRoyal());
	}
	
	@Override
	public void spawnParticle(World world, String particle, int x, int y, int z, int vX, int vY, int vZ){
		if(Minecraft.getMinecraft().renderViewEntity != null)
			world.spawnParticle(particle, x, y, z, vX, vY, vZ);
	}
	
	@Override
	public void spawnFlame(World world, double x, double y, double z, int vX, int vY, int vZ, float size){
		if(Minecraft.getMinecraft().renderViewEntity != null){
			EntityFireFX fx = new EntityFireFX(world, x, y, z, 0, 0, 0);
			fx.flameScale = size;
			Minecraft.getMinecraft().effectRenderer.addEffect(fx);
//			world.spawnEntityInWorld(fx);
		}
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