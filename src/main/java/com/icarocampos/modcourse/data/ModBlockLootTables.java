package com.icarocampos.modcourse.data;

import com.icarocampos.modcourse.block.ModBlocks;
import com.icarocampos.modcourse.item.ModItems;
import com.icarocampos.modcourse.util.Registration;
import net.minecraft.block.Block;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraftforge.fml.RegistryObject;

public class ModBlockLootTables extends BlockLootTables
{
    @Override
    protected void addTables()
    {
        this.registerLootTable(ModBlocks.COPPER_ORE.get(),(block) -> {
            return  droppingItemWithFortune(block, ModItems.COPPER_INGOT.get());
        });
        this.registerLootTable(ModBlocks.REDWOOD_LEAVES.get(), (block)->{
            return droppingWithChancesAndSticks(ModBlocks.REDWOOD_LEAVES.get(),
                    ModBlocks.REDWOOD_SAPLING.get(),0.6f);
        });

        this.registerLootTable(ModBlocks.COPPER_SLAB.get(), (block) -> {
            return  droppingSlab(ModBlocks.COPPER_SLAB.get());
        });

        this.registerLootTable(ModBlocks.ZUCCINI_CROP.get(),(block)->{
            return droppingSeeds(ModBlocks.ZUCCINI_CROP.get());
        });

        this.registerDropSelfLootTable(ModBlocks.COPPER_BLOCK.get());
        this.registerDropSelfLootTable(ModBlocks.COPPER_ORE.get());
        this.registerDropSelfLootTable(ModBlocks.REDWOOD_LOG.get());
        this.registerDropSelfLootTable(ModBlocks.REDWOOD_LEAVES.get());
        this.registerDropSelfLootTable(ModBlocks.REDWOOD_SAPLING.get());
        this.registerDropSelfLootTable(ModBlocks.REDWOOD_PLANKS.get());

        this.registerDropSelfLootTable(ModBlocks.COPPER_FENCE.get());
        this.registerDropSelfLootTable(ModBlocks.COPPER_FENCE_GATE.get());
        this.registerDropSelfLootTable(ModBlocks.COPPER_BUTTON.get());
        this.registerDropSelfLootTable(ModBlocks.COPPER_STAIRS.get());
        this.registerDropSelfLootTable(ModBlocks.COPPER_PRESSURE_PLATE.get());
        this.registerDropSelfLootTable(ModBlocks.ELECTRIFIER.get());
        this.registerDropSelfLootTable(ModBlocks.COPPER_BLOCK.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks()
    {
        return Registration.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
