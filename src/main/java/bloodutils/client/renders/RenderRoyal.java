package bloodutils.client.renders;

import java.util.Random;
import java.util.UUID;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.resources.SkinManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.util.ResourceLocation;
import bloodutils.entities.EntityRoyal;
import bloodutils.helpers.SkinHelper;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import com.mojang.authlib.minecraft.MinecraftProfileTexture.Type;

public class RenderRoyal extends RenderBiped{
	public RenderRoyal() {
		super(new ModelBiped(0.5F), 0F);
	}
	
	@Override
	public void doRender(Entity entity, double x, double y, double z, float par8, float par9) {
		EntityRoyal royal = (EntityRoyal) entity;
		BossStatus.setBossStatus(royal, true);
		this.doRender((EntityRoyal)entity, x, y, z, par8, par9);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity){	    
		return SkinHelper.getSkin("jeb_");
	}
}