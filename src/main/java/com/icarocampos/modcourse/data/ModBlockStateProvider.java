package com.icarocampos.modcourse.data;

import com.icarocampos.modcourse.ModCourse;
import com.icarocampos.modcourse.block.ModBlocks;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;

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
        slabBlock(ModBlocks.COPPER_SLAB.get(), modLoc("block/copper_block"), modLoc("block/copper_block"));
        stairsBlock(ModBlocks.COPPER_STAIRS.get(),modLoc("block/copper_block"));
        fenceBlock(ModBlocks.COPPER_FENCE.get(),"copper_fence",modLoc("block/copper_block"));
        fenceGateBlock(ModBlocks.COPPER_FENCE_GATE.get(),modLoc("block/copper_block"));
        simpleBlock(ModBlocks.REDWOOD_PLANKS.get());
        logBlock(ModBlocks.REDWOOD_LOG.get());
    }
}
