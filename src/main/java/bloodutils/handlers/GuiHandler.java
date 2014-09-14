package bloodutils.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import bloodutils.api.classes.guide.GuiCategories;
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
            switch(id){
            case 0: return new GuiCategories(player);
            default: return null;
            }

    }
}