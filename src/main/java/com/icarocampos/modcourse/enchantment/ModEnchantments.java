package com.icarocampos.modcourse.enchantment;

import com.icarocampos.modcourse.item.weapon.BluntItem;
import com.icarocampos.modcourse.util.Registration;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.fml.RegistryObject;

public class ModEnchantments
{
    public static final RegistryObject<Enchantment> BLUNTNESS =
            Registration.ENCHANTMENTS.register("bluntness", ()->
                    new BluntEnchantment(Enchantment.Rarity.COMMON, ModEnchantments.BLUNTNESS_TYPE,
                            0, EquipmentSlotType.MAINHAND));

    private static final EnchantmentType BLUNTNESS_TYPE =
            EnchantmentType.create("modcourse:bluntness",(item)-> item instanceof BluntItem);

    public static void register(){}
}
