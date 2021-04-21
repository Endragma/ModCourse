package com.icarocampos.modcourse.util;

import com.icarocampos.modcourse.ModCourse;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluid;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;



//These deferred registers need to be done once for each type of content you want to be in the game.
//Deferred registers make Minecraft notice new contents that it needs to insert in the game.
public class Registration
{
    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, ModCourse.MOD_ID);
    public static final DeferredRegister<Item> ITEMS
            = DeferredRegister.create(ForgeRegistries.ITEMS, ModCourse.MOD_ID);
    public  static final DeferredRegister<Fluid> FLUIDS
            = DeferredRegister.create(ForgeRegistries.FLUIDS, ModCourse.MOD_ID);
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES
            = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, ModCourse.MOD_ID);
    public static final DeferredRegister<ContainerType<?>> CONTAINERS
            = DeferredRegister.create(ForgeRegistries.CONTAINERS, ModCourse.MOD_ID);
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES
            = DeferredRegister.create(ForgeRegistries.ENTITIES, ModCourse.MOD_ID);



    //All deferred registers created above needs to be registered through this format below.
    //init is called by ModCourse.java class
    public static void init()
    {
        IEventBus eventbus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(eventbus);
        ITEMS.register(eventbus);
        FLUIDS.register(eventbus);
        TILE_ENTITY_TYPES.register(eventbus);
        CONTAINERS.register(eventbus);
        ENTITY_TYPES.register(eventbus);
    }
}
