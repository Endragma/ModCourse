package com.icarocampos.modcourse.data;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.LootTableProvider;
import net.minecraft.data.loot.*;
import net.minecraft.loot.*;
import net.minecraft.util.ResourceLocation;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ModLootTableProvider extends LootTableProvider
{
    private final List<com.mojang.datafixers.util.Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>> loot_tables
            = ImmutableList.of(com.mojang.datafixers.util.Pair.of(ModBlockLootTables::new, LootParameterSets.BLOCK));

    public ModLootTableProvider(DataGenerator dataGeneratorIn)
    {
        super(dataGeneratorIn);
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>> getTables()
    {
        return this.loot_tables;
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationTracker validationtracker)
    {    }
}
