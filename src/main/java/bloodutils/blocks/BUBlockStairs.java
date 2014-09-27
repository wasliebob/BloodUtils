package bloodutils.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.util.IIcon;
import bloodutils.libs.LibMod;
import bloodutils.main.init.BUTabs;
import cpw.mods.fml.common.registry.GameRegistry;

public class BUBlockStairs extends BlockStairs{
	public BUBlockStairs(Block type, int meta){
		super(type, meta);
		setBlockName(type.getLocalizedName().toLowerCase() + " stairs");
		setCreativeTab(BUTabs.tabMain);
		
		this.type = type;
		this.meta = meta;
		
		GameRegistry.registerBlock(this, this.getUnlocalizedName());
	}
	public Block type;
	public int meta;
	
	@Override
    public IIcon getIcon(int side, int meta){
        return this.type.getIcon(side, this.meta);
    }
}