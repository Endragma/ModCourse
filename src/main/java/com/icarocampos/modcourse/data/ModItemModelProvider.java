package com.icarocampos.modcourse.data;

import com.icarocampos.modcourse.ModCourse;
import com.icarocampos.modcourse.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider
{

    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper)
    {
        super(generator, ModCourse.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels()
    {
        withExistingParent("copper_block", modLoc("block/copper_block"));
        withExistingParent("copper_ore", modLoc("block/copper_ore"));
        singleTexture("copper_pressure_plate", mcLoc("block/pressure_plate_up"), modLoc("block/copper_block"));
        singleTexture("copper_pressure_plate_down", mcLoc("block/pressure_plate_down"), modLoc("block/copper_block"));
        singleTexture("copper_button", mcLoc("block/button"), modLoc("block/copper_block"));
        singleTexture("copper_button_inventory", mcLoc("block/button_inventory"), modLoc("block/copper_block"));
        singleTexture("copper_button_pressed", mcLoc("block/button_pressed"), modLoc("block/copper_block"));
        slab("copper_slab",modLoc("block/copper_block"), modLoc("block/copper_block"),modLoc("block/copper_block"));
        slabTop("copper_slab_top",modLoc("block/copper_block"),modLoc("block/copper_block"),modLoc("block/copper_block"));
        stairs("copper_stairs",modLoc("block/copper_block"),modLoc("block/copper_block"),modLoc("block/copper_block"));
        stairsInner("copper_stairs_inner",modLoc("block/copper_block"),modLoc("block/copper_block"),modLoc("block/copper_block"));
        stairsOuter("copper_stairs_outer",modLoc("block/copper_block"),modLoc("block/copper_block"),modLoc("block/copper_block"));
        fencePost("copper_fence_post", modLoc("block/copper_block"));
        fenceSide("copper_fence_side", modLoc("block/copper_block"));
        fenceInventory("copper_fence_inventory",modLoc("block/copper_block"));
        fenceGate("copper_fence_gate",modLoc("block/copper_block"));
        fenceGateOpen("copper_fence_gate_open",modLoc("block/copper_block"));
        fenceGateWall("copper_fence_gate_wall",modLoc("block/copper_block"));
        fenceGateWallOpen("copper_fence_gate_wall_open",modLoc("block/copper_block"));
        cubeColumn("redwood_log",modLoc("block/redwood_log"),modLoc("block/redwood_log_top"));
        cubeColumnHorizontal("redwood_log",modLoc("block/redwood_log"),modLoc("block/redwood_log_top"));
        cubeAll("redwood_planks",modLoc("block/redwood_planks"));
        withExistingParent("buffalo_spawn_egg", "item/template_spawn_egg");
        cross("redwood_sapling",modLoc("block/redwood_sapling"));

        ModelFile itemGenerated = getExistingFile(mcLoc("item/generated"));
        ModelFile itemHandheld = getExistingFile(mcLoc("item/handheld"));

        builder(itemGenerated,"copper_ingot");
        builder(itemGenerated,"copper_wire");
        builder(itemGenerated,"coppered_apple");
        builder(itemGenerated,"zuccini");
        builder(itemHandheld,"copper_sword");
        builder(itemHandheld,"copper_axe");
        builder(itemHandheld,"copper_pickaxe");
        builder(itemHandheld,"copper_hoe");
        builder(itemHandheld,"copper_shovel");
        builder(itemHandheld,"the_copperator");
        builder(itemHandheld,"copper_club");
        builder(itemGenerated,"oil_bucket");
        builder(itemGenerated,"zuccini_seed");
        builder(itemGenerated,"copper_helmet");
        builder(itemGenerated,"copper_chestplate");
        builder(itemGenerated,"copper_leggings");
        builder(itemGenerated,"copper_boots");
        ModelFile leaves = getExistingFile(mcLoc("block/leaves"));
        builderLeaves(leaves,"redwood_leaves");

    }

    private ItemModelBuilder builder(ModelFile itemGenerated, String name)
    {
        return getBuilder(name).parent(itemGenerated).texture("layer0","item/" + name);
    }

    private ItemModelBuilder builderLeaves(ModelFile itemGenerated, String name)
    {
        return getBuilder(name).parent(itemGenerated).texture("all","block/" + name);
    }

    private ItemModelBuilder builderWithTextureKey(ModelFile itemGenerated, String name)
    {
        return getBuilder(name).parent(itemGenerated).texture("texture","block/" + name);
    }

}
