package bloodutils.entities;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import wasliecore.helpers.MathHelper;
import bloodutils.helpers.EffectHelper;
import bloodutils.main.init.BUItems;

public class EntityRoyal extends EntityCreature implements IBossDisplayData{
	public EntityRoyal(World world){
		super(world);
        setSize(0.6F, 1.8F);
		getNavigator().setCanSwim(true);
		tasks.addTask(0, new EntityAISwimming(this));
		tasks.addTask(1, new EntityAIWatchClosest(this, EntityPlayer.class, Float.MAX_VALUE));
	}
	public int tpCooldown;
	public float attackDamage = 1F;
	public float MAX_HEALTH = 500F;
	
	public static void spawn(World world, int x, int y, int z){
		if(world.difficultySetting == EnumDifficulty.PEACEFUL)
			return;
		
		EntityRoyal e = new EntityRoyal(world);
		e.setPosition(x, y + 1, z);

		world.spawnEntityInWorld(e);
	}

	@Override
    protected void applyEntityAttributes(){
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(200.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.50000000298023224D);
	}
	
	@Override
	public boolean canDespawn(){
		return false;
	}
	
	@Override
	public boolean isAIEnabled(){
		return true;
	}
	
	@Override
	public void onLivingUpdate(){
		super.onLivingUpdate();

		int l = 12;
		for(int i = 0; i < l; ++i)  {
			double d6 = i / (l - 1.0D);
			float f = (rand.nextFloat() - 0.5F) * 0.2F;
			float f1 = (rand.nextFloat() - 0.5F) * 0.2F;
			float f2 = (rand.nextFloat() - 0.5F) * 0.2F;
			double d7 = posX + (posX - posX) * d6 + (rand.nextDouble() - 0.5D) * width * 2.0D;
			double d8 = posY + (posY - posY) * d6 + rand.nextDouble() * height;
			double d9 = posZ + (posZ - posZ) * d6 + (rand.nextDouble() - 0.5D) * width * 2.0D;
			if(this.tpCooldown == 0)
				worldObj.spawnParticle("portal", d7, d8, d9, f, f1, f2);
			
			worldObj.spawnParticle("flame", d7, d8, d9, f, f1, f2);
			worldObj.spawnParticle("enchantmenttable", d7, d8, d9, f, f1, f2);
		}

		if(this.tpCooldown <= 0){
			ArrayList<EntityPlayer> players = EffectHelper.getClosePlayers(worldObj, posX, posY, posZ, 4);
			if(!players.isEmpty()){
				EntityPlayer player = players.get(0);
				if(player != null && !player.isSneaking()){
					int max = 8;
					int min = 1;
					Random rand = new Random();

				    int x = rand.nextInt((max - min) + 1) + min;
				    int z = rand.nextInt((max - min) + 1) + min;

					double nX = this.posX + x;
					double nY = this.posY + 4;
					double nZ = this.posZ + z;
					
					float yaw = player.prevRotationYaw;
					float pitch = player.prevRotationPitch;
	
					setLocationAndAngles(player.posX, player.posY + 2, player.posZ, player.cameraYaw, player.cameraPitch);
					
					player.addPotionEffect(new PotionEffect(Potion.blindness.id, MathHelper.secondToTick(6)));
					attackPlayer(player);
					setLocationAndAngles(nX, nY, nZ, yaw, pitch);
					
					this.tpCooldown = MathHelper.secondToTick(5);
				}
			}
		}else if(this.tpCooldown > 0){
			this.tpCooldown--;
		}
		
		ArrayList<EntityPlayer> players = EffectHelper.getClosePlayers(worldObj, posX, posY, posZ, 4);
		
		if(!players.isEmpty()){
			for(EntityPlayer player : players){
				EntityArrow arrow = new EntityArrow(worldObj, this, player, 1, 1);
				arrow.canBePickedUp = 0;

				worldObj.spawnEntityInWorld(arrow);
			}
		}
	}
	
	public void attackPlayer(EntityPlayer player){
		if(!player.capabilities.isCreativeMode){
			player.setHealth(player.getHealth() - this.attackDamage);
			player.attackEntityFrom(DamageSource.generic, this.attackDamage);
			
			if((player.getHealth() - this.attackDamage) <= 0)
				player.onDeath(DamageSource.generic);
		}
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float par2){
		return super.attackEntityFrom(source, par2);
	}


	@Override
	public void damageEntity(DamageSource source, float par2) {
		super.damageEntity(source, par2);
		
		Entity e = source.getEntity();
	}
	
	protected void dropFewItems(boolean par1, int par2){
		dropItem(BUItems.bloodShard_royal, 1);
	}
}