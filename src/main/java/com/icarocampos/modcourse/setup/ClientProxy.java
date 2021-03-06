package com.icarocampos.modcourse.setup;

import com.icarocampos.modcourse.ModCourse;
import com.icarocampos.modcourse.block.ModBlocks;
import com.icarocampos.modcourse.container.ModContainers;
import com.icarocampos.modcourse.entity.ModEntityTypes;
import com.icarocampos.modcourse.entity.render.BuffaloRenderer;
import com.icarocampos.modcourse.item.ModSpawnEggItem;
import com.icarocampos.modcourse.screens.ElectrifierScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ModCourse.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD,value = Dist.CLIENT)
public class ClientProxy implements IProxy
{

    //Initializes renderings for GUIs, Crops, Saplings and Entities.
    @Override
    public void init()
    {
        RenderTypeLookup.setRenderLayer(ModBlocks.ZUCCINI_CROP.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.REDWOOD_SAPLING.get(), RenderType.getCutout());

        ScreenManager.registerFactory(ModContainers.ELECTRIFIER_CONTAINER.get(), ElectrifierScreen::new);

        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.BUFFALO.get(), BuffaloRenderer::new);

        ModSpawnEggItem.initSpawnEggs();
    }

    @Override
    public World getClientWorld()
    {
        return Minecraft.getInstance().world;
    }
}
