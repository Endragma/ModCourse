package com.icarocampos.modcourse.entity.render;

import com.icarocampos.modcourse.ModCourse;
import com.icarocampos.modcourse.entity.BuffaloEntity;
import com.icarocampos.modcourse.entity.model.BuffaloModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class BuffaloRenderer extends MobRenderer<BuffaloEntity, BuffaloModel<BuffaloEntity>>
{
    //Location of the texture for this entity.
    protected static final ResourceLocation TEXTURE = new ResourceLocation(ModCourse.MOD_ID,
            "textures/entity/buffalo.png");

    public BuffaloRenderer(EntityRendererManager renderManagerIn)
    {
        super(renderManagerIn, new BuffaloModel<>(), 0.9f);
    }

    @Override
    public ResourceLocation getEntityTexture(BuffaloEntity entity)
    {
        return TEXTURE;
    }
}