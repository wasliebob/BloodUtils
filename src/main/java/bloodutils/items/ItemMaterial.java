package bloodutils.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraftforge.oredict.OreDictionary;
import bloodutils.libs.LibMod;

public class ItemMaterial extends BUItem{
	public ItemMaterial(String name, String textureName, String oreDict){
		super(name);
		this.textureName = textureName;
		this.oreDict = oreDict;
	}
	public String textureName;
	public String oreDict;
	
	@Override
	public void postRegistration(){
		super.postRegistration();
		OreDictionary.registerOre(this.oreDict, this);
	}
	
	@Override
    public void registerIcons(IIconRegister ir){
        itemIcon = ir.registerIcon(LibMod.modName.toLowerCase() + ":" + this.textureName);
	}
}