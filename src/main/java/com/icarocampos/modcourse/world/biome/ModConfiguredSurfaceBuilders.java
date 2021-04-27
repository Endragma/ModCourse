package com.icarocampos.modcourse.world.biome;

import com.icarocampos.modcourse.ModCourse;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilders;

//Used to key biomes.
public class ModConfiguredSurfaceBuilders
{
    public static RegistryKey<ConfiguredSurfaceBuilder<?>> OIL_SURFACE
            = RegistryKey.getOrCreateKey(Registry.CONFIGURED_SURFACE_BUILDER_KEY,
            new ResourceLocation(ModCourse.MOD_ID, "oil_surface"));


}
