package com.icarocampos.modcourse.events;

import com.icarocampos.modcourse.block.ModBlocks;
import com.icarocampos.modcourse.item.ModItems;
import com.icarocampos.modcourse.util.Config;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.apache.logging.log4j.LogManager;

import java.util.Collection;

public class ModEvents
{
    @SubscribeEvent
    public void onCopperedSheep(AttackEntityEvent event)
    {
        if(event.getPlayer().getHeldItemMainhand().getItem() == ModItems.COPPERED_APPLE.get())
        {
            if(event.getTarget().isAlive())
            {
                LivingEntity target = (LivingEntity)event.getTarget();
                if(target instanceof SheepEntity)
                {
                    PlayerEntity player = event.getPlayer();
                    player.getHeldItemMainhand().shrink(1);

                    target.addPotionEffect(new EffectInstance(Effects.GLOWING, Config.COPPERED_GLOW_DURATION.get()));

                    if(!player.world.isRemote())
                    {
                        String msg = TextFormatting.YELLOW + "Sheep is now glowing!";
                        player.sendMessage(new StringTextComponent(msg), player.getUniqueID());
                    }
                }
            }
        }
    }
    @SubscribeEvent
    public void onCopperedSheepDrops(LivingDropsEvent event)
    {
        LivingEntity entity = event.getEntityLiving();
        if(entity instanceof SheepEntity)
        {
            World world = entity.getEntityWorld();
            Collection<ItemEntity> drops = event.getDrops();

            LogManager.getLogger().debug(entity.getActivePotionEffects());

            if(entity.isPotionActive(Effects.GLOWING))
            {
                drops.add(new ItemEntity(world,entity.getPosX(),entity.getPosY(),entity.getPosZ(),
                        new ItemStack(ModItems.COPPER_INGOT.get())));
            }

        }
    }

    @SubscribeEvent
    public void onCopperatorStrike(AttackEntityEvent event)
    {
        if(event.getPlayer().getHeldItemMainhand().getItem() == ModItems.THE_COPPERATOR.get())
        {
            LivingEntity entity = event.getEntityLiving();
            World world = entity.getEntityWorld();
            if(event.getTarget().isAlive())
            {
                LivingEntity target = (LivingEntity)event.getTarget();
                    PlayerEntity player = event.getPlayer();

                    target.entityDropItem(new ItemStack(ModItems.COPPER_INGOT.get()));


                    if(!player.world.isRemote())
                    {
                        String msg = TextFormatting.YELLOW + "The Copperator turned the target's flesh into copper!";
                        player.sendMessage(new StringTextComponent(msg), player.getUniqueID());
                    }
            }
        }
    }

    @SubscribeEvent
    public void onCopperatorKill(LivingDeathEvent event)
    {
        LivingEntity entity = Minecraft.getInstance().player;
        if (entity.getHeldItemMainhand().getItem() == ModItems.THE_COPPERATOR.get())
        {
            Entity target = event.getEntity();
            target.entityDropItem(new ItemStack(ModBlocks.COPPER_BLOCK.get()));


            if (!entity.world.isRemote())
            {
                String msg = TextFormatting.YELLOW + "The target's remains turned to copper!";
                entity.sendMessage(new StringTextComponent(msg), entity.getUniqueID());
            }
        }
    }
}
