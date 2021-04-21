package com.icarocampos.modcourse.entity;

import com.icarocampos.modcourse.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;

public class BuffaloEntity extends AnimalEntity
{
    protected BuffaloEntity(EntityType<? extends AnimalEntity> type, World worldIn)
    {
        super(type, worldIn);
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttribute()
    {
        //Add basic attributes here.
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 18.0D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.35D);
    }

    @Override
    protected int getExperiencePoints(PlayerEntity player)
    {
        return 1 + this.world.rand.nextInt(6); // Between 1 and 7.
    }

    //Sound made by this entity just for being around player.
    @Override
    protected SoundEvent getAmbientSound()
    {
        return SoundEvents.ENTITY_COW_AMBIENT;
    }

    //Sound made by this entity when dying.
    @Override
    protected SoundEvent getDeathSound()
    {
        return SoundEvents.ENTITY_COW_DEATH;
    }

    //Sound made by this entity when receiving damage.
    @Override
    protected SoundEvent getHurtSound(DamageSource source)
    {
        return SoundEvents.ENTITY_COW_HURT;
    }

    //Sound made by this entity when walking.
    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn)
    {
        this.playSound(SoundEvents.ENTITY_COW_STEP, 0.75f, 0.25f);
    }

    //Settings to entity behavior.
    @Override
    protected void registerGoals()
    {
        super.registerGoals();
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(2, new TemptGoal(this, 1.25D,
                Ingredient.fromItems(ModItems.COPPERED_APPLE.get()), false));
        this.goalSelector.addGoal(3, new FollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(5, new LookAtGoal(this, PlayerEntity.class, 8f));
        this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
    }

    //Breeding this entity will result in what comes in this part.
    @Nullable
    @Override
    public AgeableEntity createChild(ServerWorld world, AgeableEntity mate)
    {
        return ModEntityTypes.BUFFALO.get().create(this.world);
    }
}
