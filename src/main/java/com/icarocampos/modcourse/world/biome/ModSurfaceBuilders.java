package com.icarocampos.modcourse.world.biome;

import com.icarocampos.modcourse.util.Registration;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.fml.RegistryObject;

public class ModSurfaceBuilders
{
    public static final RegistryObject<SurfaceBuilder<SurfaceBuilderConfig>> LOGGING_DEFAULT =
            Registration.SURFACE_BUILDERS.register("logging_default",
                    ()-> new LoggingSurfaceBuilder<>(()-> SurfaceBuilder.DEFAULT, SurfaceBuilderConfig.CODEC));

    public static void register(){}
}
