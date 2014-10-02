package bloodutils.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import bloodutils.api.classes.guide.GuiCategories;
import bloodutils.api.classes.guide.GuiEntry;
import bloodutils.api.classes.guide.GuiIndex;
import bloodutils.api.compact.Category;
import bloodutils.api.registries.EntryRegistry;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {
    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z){
            TileEntity tile = world.getTileEntity(x, y, z);
            switch(id){
            case 0: return null;
            default: return null;
            }
    }

    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z){
            TileEntity tile = world.getTileEntity(x, y, z);
            ItemStack held = player.getHeldItem();
            switch(id){
            case 0:
            	if(held.hasTagCompound() && held.getTagCompound().getString("CATEGORY") != null){
            		if(held.hasTagCompound() && held.getTagCompound().getString("KEY") != null && held.getTagCompound().getString("KEY") != "0"){
            			String cate = held.getTagCompound().getString("CATEGORY");
            			String key = held.getTagCompound().getString("KEY");
            			int page = held.getTagCompound().getInteger("PAGE");
            			if(EntryRegistry.categoryMap.containsKey(cate)){
            				Category category = EntryRegistry.categoryMap.get(cate);
            				return new GuiEntry(key, player, category, page);
            			}else{
                        	return new GuiCategories(player);
            			}
            		}else if(held.hasTagCompound() && held.getTagCompound().getString("CATEGORY") != null){
            			String cate = held.getTagCompound().getString("CATEGORY");
            			int page = held.getTagCompound().getInteger("PAGE");
            			if(EntryRegistry.categoryMap.containsKey(cate)){
            				Category category = EntryRegistry.categoryMap.get(cate);
            				return new GuiIndex(category, player, page);
            			}
            		}
            	}
            	return new GuiCategories(player);
            default: return null;
            }

    }
}