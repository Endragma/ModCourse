package com.icarocampos.modcourse.data;

import com.icarocampos.modcourse.ModCourse;
import com.icarocampos.modcourse.block.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider
{
    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper)
    {
        super(gen, ModCourse.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels()
    {
        simpleBlock(ModBlocks.COPPER_BLOCK.get());
        simpleBlock(ModBlocks.COPPER_ORE.get());

    }
}
