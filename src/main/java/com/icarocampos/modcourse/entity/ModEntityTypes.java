package com.icarocampos.modcourse.entity;

import com.icarocampos.modcourse.ModCourse;
import com.icarocampos.modcourse.util.Registration;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;

public class ModEntityTypes
{

    //Add all types of entities of the mod here with its basic configurations.
    public static final RegistryObject<EntityType<BuffaloEntity>> BUFFALO = Registration.ENTITY_TYPES.register("buffalo",
            () -> EntityType.Builder.create(BuffaloEntity::new, EntityClassification.CREATURE)
                    .size(1.5f, 1.5f)
                    .build(new ResourceLocation(ModCourse.MOD_ID + "buffalo").toString()));

    public static void register() { }

}
