package bloodutils.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import bloodutils.libs.LibMod;

public class ItemGem extends BUItem{
	public ItemGem(String name, String gemType){
		super(name);
		this.gemType = gemType;
		this.isWIP = true;
	}
	public String gemType;
	
	@Override
    public void registerIcons(IIconRegister ir){
        itemIcon = ir.registerIcon(LibMod.modName.toLowerCase() + ":" + "gem_" + this.gemType);
	}
}