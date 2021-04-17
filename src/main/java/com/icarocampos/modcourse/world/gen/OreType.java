package com.icarocampos.modcourse.world.gen;

import com.icarocampos.modcourse.block.ModBlocks;
import net.minecraft.block.Block;

public enum OreType
{
    //Add new ores here!!
    COPPER(ModBlocks.COPPER_ORE.get(),8,25,50);

    private final Block block;
    private final int maxVeinSize;
    private final int minHeight;
    private final int maxHeight;


    OreType(Block block, int maxVeinSize, int minHeight, int maxHeight) {
        this.block = block;
        this.maxVeinSize = maxVeinSize;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
    }


    public Block getBlock() {
        return block;
    }

    public int getMaxVeinSize() {
        return maxVeinSize;
    }

    public int getMinHeight() {
        return minHeight;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public static OreType get(Block block)
    {
        for (OreType ore : values())
        {
            if (block == ore.block)
            {
                return ore;
            }
        }
        return null;
    }
}
