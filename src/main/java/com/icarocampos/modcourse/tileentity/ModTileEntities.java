package com.icarocampos.modcourse.tileentity;

import com.icarocampos.modcourse.block.ModBlocks;
import com.icarocampos.modcourse.util.Registration;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;

public class ModTileEntities
{
    public static final RegistryObject<TileEntityType<ElectrifierTile>> ELECTRIFIER_TILE_ENTITY
            = Registration.TILE_ENTITY_TYPES.register("electrifier_tile_entity", ()->TileEntityType.Builder.create(
            () -> new ElectrifierTile(), ModBlocks.ELECTRIFIER.get()).build(null));

    public static void register(){}


}
