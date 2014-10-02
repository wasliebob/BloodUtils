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
	public void spawnFlame(World world, double x, double y, double z, int vX, int vY, int vZ, float size){}
	public void spawnParticle(World world, String particle, int x, int y, int z, int vX, int vY, int vZ){}
	public void spawnSound(World worldObj, int xCoord, int yCoord, int zCoord, String id){}
	public void bindKeys(){}
	
	public boolean renderView(){
		return false;
	}
	
	public void registerPackets(){

	}
}