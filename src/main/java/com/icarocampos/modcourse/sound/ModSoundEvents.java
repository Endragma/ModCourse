package com.icarocampos.modcourse.sound;

import com.icarocampos.modcourse.ModCourse;
import com.icarocampos.modcourse.util.Registration;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;

public class ModSoundEvents
{
    public static final RegistryObject<SoundEvent> SMALL_EXPLOSION =
            Registration.SOUND_EVENTS.register("small_explosion",
            ()-> new SoundEvent(new ResourceLocation(ModCourse.MOD_ID,"small_explosion")));

    public static void register(){}

}
