package com.icarocampos.modcourse.data;

import com.icarocampos.modcourse.ModCourse;
import com.icarocampos.modcourse.block.ModBlocks;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

public class ModBlockTagsProvider extends BlockTagsProvider
{
    public ModBlockTagsProvider(DataGenerator generatorIn, @Nullable ExistingFileHelper existingFileHelper)
    {
        super(generatorIn, ModCourse.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerTags()
    {
        getOrCreateBuilder(Tags.Blocks.ORES).add(ModBlocks.COPPER_ORE.get());

        super.registerTags();
    }
}
