package com.icarocampos.modcourse.setup;

import com.icarocampos.modcourse.ModCourse;
import com.icarocampos.modcourse.block.ModBlocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ModCourse.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD,value = Dist.CLIENT)
public class ClientProxy implements IProxy
{

    @Override
    public void init()
    {
        RenderTypeLookup.setRenderLayer(ModBlocks.ZUCCINI_CROP.get(), RenderType.getCutout());
    }

    @Override
    public World getClientWorld()
    {
        return Minecraft.getInstance().world;
    }
}