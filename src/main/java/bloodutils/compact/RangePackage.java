package bloodutils.compact;

public class RangePackage {
	public RangePackage(int minX, int minY, int minZ, int maxX, int maxY, int maxZ){
		this.minX = minX;
		this.minY = minY;
		this.minZ = minZ;
		
		this.maxX = maxX;
		this.maxY = maxY;
		this.maxZ = maxZ;
	}
	public int minX, minY, minZ;
	public int maxX, maxY, maxZ;
}