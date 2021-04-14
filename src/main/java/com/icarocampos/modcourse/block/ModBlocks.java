package com.icarocampos.modcourse.block;

import com.icarocampos.modcourse.ModCourse;
import com.icarocampos.modcourse.util.Registration;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks
{
    public static final RegistryObject <Block> COPPER_BLOCK = register("copper_block",
            () -> new Block(AbstractBlock.Properties.create(Material.IRON)
            .hardnessAndResistance(3f,10f).sound(SoundType.METAL)));

    public static final RegistryObject <Block> COPPER_ORE = register("copper_ore",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(2).harvestTool(ToolType.PICKAXE)
            .hardnessAndResistance(3f,10f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> COPPER_STAIRS =
            register("copper_stairs", () -> new StairsBlock(() -> ModBlocks.COPPER_BLOCK.get().getDefaultState(),
                    AbstractBlock.Properties.create(Material.IRON)));

    public static final RegistryObject<Block> COPPER_FENCE =
            register("copper_fence", () -> new FenceBlock((AbstractBlock.Properties.create(Material.IRON))));

    public static final RegistryObject<Block> COPPER_FENCE_GATE =
            register("copper_fence_gate", () -> new FenceGateBlock((AbstractBlock.Properties.create(Material.IRON))));

    public static final RegistryObject<Block> COPPER_PRESSURE_PLATE =
            register("copper_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,
                    AbstractBlock.Properties.create(Material.IRON)));

    public static final RegistryObject<Block> COPPER_SLAB =
            register("copper_slab", () -> new SlabBlock((AbstractBlock.Properties.create(Material.IRON))));

    public static final RegistryObject<Block> COPPER_BUTTON =
            register("copper_button", () -> new StoneButtonBlock((AbstractBlock.Properties.create(Material.IRON))));

    public static final RegistryObject<Block> ZUCCINI_CROP =
            Registration.BLOCKS.register("zuccini_crop",
                    ()-> new ZucciniCrop(AbstractBlock.Properties.from(Blocks.WHEAT)));

    public static final RegistryObject<Block> ELECTRIFIER =
            register("electrifier",()-> new Electrifier(AbstractBlock.Properties.create(Material.IRON)
                    .hardnessAndResistance(4f).harvestTool(ToolType.PICKAXE)));

    public static void register() { }


    private static  <T extends Block>RegistryObject<T> register(String name, Supplier<T> block)
    {
        RegistryObject<T> toReturn = Registration.BLOCKS.register(name,block);
        Registration.ITEMS.register(name,() -> new BlockItem(toReturn.get(),
                new Item.Properties().group(ModCourse.COURSE_TAB)));
        return toReturn;
    }
}
