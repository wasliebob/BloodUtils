package bloodutils.proxies;

import net.minecraft.world.World;

public class CommonProxy {
	public void preInit(){
		
	}
	
	public void init(){
		registerPackets();
        registerParticles();
        render();
        bindKeys();
	}
	
	public void postInit(){
		
	}
	
    public void registerParticles(){}
	public void render(){}
	public void spawnParticle(World world, String particle, int minX, int minY, int minZ, int maxX, int maxY, int maxZ){}
	public void spawnSound(World worldObj, int xCoord, int yCoord, int zCoord, String id){}
	public void bindKeys(){}
	
	public boolean renderView(){
		return false;
	}
	
	public void registerPackets(){

	}
}