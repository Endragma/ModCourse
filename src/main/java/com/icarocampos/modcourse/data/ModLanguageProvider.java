package com.icarocampos.modcourse.data;

import com.icarocampos.modcourse.ModCourse;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class ModLanguageProvider extends LanguageProvider
{
    public ModLanguageProvider(DataGenerator gen, String locale)
    {
        super(gen, ModCourse.MOD_ID, locale);
    }

    @Override
    protected void addTranslations()
    {
        String locale = this.getName().replace("Languages: ","");

        switch (locale)
        {
            case "en_us":
                add("item.modcourse.copper_ingot", "Copper Ingot");
                add("block.modcourse.copper_block", "Copper Block");
                add("item.modcourse.copper_wire", "Copper Wire");
                add("block.modcourse.copper_ore", "Copper Ore");
                add("item.modcourse.coppered_apple", "Coppered Apple");
                add("item.modcourse.copper_shovel", "Copper Shovel");
                add("item.modcourse.copper_sword", "Copper Sword");
                add("item.modcourse.copper_pickaxe", "Copper Pickaxe");
                add("item.modcourse.copper_hoe", "Copper Hoe");
                add("item.modcourse.copper_axe", "Copper Axe");
                add("item.modcourse.the_copperator", "The Copperator");
                add("item.modcourse.copper_helmet", "Copper Helmet");
                add("item.modcourse.copper_chestplate", "Copper Chestplate");
                add("item.modcourse.copper_leggings", "Copper Leggings");
                add("item.modcourse.copper_boots", "Copper Boots");
                add("block.modcourse.copper_stairs", "Copper Stairs");
                add("block.modcourse.copper_fence", "Copper Fence");
                add("block.modcourse.copper_fence_gate", "Copper Fence Gate");
                add("block.modcourse.copper_pressure_plate", "Copper Pressure Plate");
                add("block.modcourse.copper_slab", "Copper Slab");
                add("block.modcourse.copper_button", "Copper Button");
                add("block.modcourse.zuccini_crop", "Zuccini Seeds");
                add("item.modcourse.zuccini", "Zuccini");
                add("item.modcourse.oil_bucket", "Oil Bucket");
                add("block.modcourse.electrifier", "Electrifier");
                add("block.modcourse.redwood_planks", "Redwood Planks");
                add("block.modcourse.redwood_log", "Redwood Log");
                add("block.modcourse.redwood_leaves", "Redwood Leaves");
                add("block.modcourse.redwood_sapling", "Redwood Sapling");
                add("item.modcourse.buffalo_spawn_egg", "Buffalo Spawn Egg");
                add("item.modcourse.copper_club", "Copper Club");
                add("advancements.story.copper_block.title", "Coppering");
                add("advancements.story.copper_block.description", "Acquire Copper Blocks");
                break;
            default:
                break;
        }
    }
}
