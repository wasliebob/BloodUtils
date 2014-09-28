package bloodutils.helpers;

import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import com.mojang.authlib.minecraft.MinecraftProfileTexture.Type;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.SkinManager;
import net.minecraft.util.ResourceLocation;

public class SkinHelper {
	public static ResourceLocation getSkin(String username){
		MinecraftProfileTexture profile = new MinecraftProfileTexture("http://s3.amazonaws.com/MinecraftSkins/" + username + ".png");
        SkinManager sm = Minecraft.getMinecraft().func_152342_ad();
        return sm.func_152792_a(profile, Type.SKIN);
	}
}