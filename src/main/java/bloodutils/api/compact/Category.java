package bloodutils.api.compact;

import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import bloodutils.api.enums.EnumType;

public class Category {
	public Category(String name, ItemStack iconStack, EnumType type){
		this.name = name;
		this.icon = iconStack.getIconIndex();
		this.type = type;
	}
	public String name;
	public IIcon icon;
	public EnumType type;
}