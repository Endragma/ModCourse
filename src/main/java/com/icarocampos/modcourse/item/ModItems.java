package com.icarocampos.modcourse.item;

import com.icarocampos.modcourse.ModCourse;
import com.icarocampos.modcourse.block.ModBlocks;
import com.icarocampos.modcourse.block.ModFluids;
import com.icarocampos.modcourse.entity.ModEntityTypes;
import com.icarocampos.modcourse.item.weapon.BluntItem;
import com.icarocampos.modcourse.util.Registration;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

public class ModItems
{
    /* Copper Basics */
    public static final RegistryObject<Item> COPPER_INGOT =
            Registration.ITEMS.register("copper_ingot",
            () -> new Item(new Item.Properties().group(ModCourse.COURSE_TAB)));
    public static final RegistryObject<Item> COPPER_WIRE =
            Registration.ITEMS.register("copper_wire",
            () -> new Item(new Item.Properties().group(ModCourse.COURSE_TAB)));
    public static final RegistryObject<Item> COPPERED_APPLE =
            Registration.ITEMS.register("coppered_apple",
            () -> new CopperedApple());
    public static final RegistryObject<Item> ZUCCINI =
            Registration.ITEMS.register("zuccini",
                    () -> new Zuccini());

    /* Copper Tools */
    public static final RegistryObject<Item> COPPER_SHOVEL =
            Registration.ITEMS.register("copper_shovel",
            () -> new ShovelItem(ModItemTier.COPPER, 0f,0f,
                    new Item.Properties()
                        .defaultMaxDamage(150)
                        .addToolType(ToolType.SHOVEL, 2)
                        .group(ModCourse.COURSE_TAB)));

    public static final RegistryObject<Item> COPPER_SWORD =
            Registration.ITEMS.register("copper_sword",
                    () -> new SwordItem(ModItemTier.COPPER, 2,0f,
                            new Item.Properties()
                                    .defaultMaxDamage(150)
                                    .group(ModCourse.COURSE_TAB)));

    public static final RegistryObject<Item> COPPER_CLUB =
            Registration.ITEMS.register("copper_club",
                    () -> new CopperClub(ModItemTier.COPPER, 2,0f,
                            new Item.Properties()
                                    .defaultMaxDamage(150)
                                    .group(ModCourse.COURSE_TAB)));

    public static final RegistryObject<Item> COPPER_PICKAXE =
            Registration.ITEMS.register("copper_pickaxe",
                    () -> new PickaxeItem(ModItemTier.COPPER, 0,0f,
                            new Item.Properties()
                                    .defaultMaxDamage(150)
                                    .addToolType(ToolType.PICKAXE, 2)
                                    .group(ModCourse.COURSE_TAB)));

    public static final RegistryObject<Item> COPPER_HOE =
            Registration.ITEMS.register("copper_hoe",
                    () -> new HoeItem(ModItemTier.COPPER, 0,0f,
                            new Item.Properties()
                                    .defaultMaxDamage(150)
                                    .addToolType(ToolType.HOE, 2)
                                    .group(ModCourse.COURSE_TAB)));

    public static final RegistryObject<Item> COPPER_AXE =
            Registration.ITEMS.register("copper_axe",
                    () -> new AxeItem(ModItemTier.COPPER, 2.5f,-3f,
                            new Item.Properties()
                                    .defaultMaxDamage(150)
                                    .addToolType(ToolType.AXE, 2)
                                    .group(ModCourse.COURSE_TAB)));

    public static final RegistryObject<Item> THE_COPPERATOR =
            Registration.ITEMS.register("the_copperator",
                    () -> new SwordItem(ItemTier.IRON, 5,0f,
                            new Item.Properties()
                                    .defaultMaxDamage(300)
                                    .group(ModCourse.COURSE_TAB)));

    /* Copper Armor */
    public static final RegistryObject<Item> COPPER_HELMET =
            Registration.ITEMS.register("copper_helmet",
                    () -> new ArmorItem(ModArmorMaterial.COPPER, EquipmentSlotType.HEAD,
                            new Item.Properties().group(ModCourse.COURSE_TAB)));

    public static final RegistryObject<Item> COPPER_CHESTPLATE =
            Registration.ITEMS.register("copper_chestplate",
                    () -> new ArmorItem(ModArmorMaterial.COPPER, EquipmentSlotType.CHEST,
                            new Item.Properties().group(ModCourse.COURSE_TAB)));

    public static final RegistryObject<Item> COPPER_LEGGINGS =
            Registration.ITEMS.register("copper_leggings",
                    () -> new ArmorItem(ModArmorMaterial.COPPER, EquipmentSlotType.LEGS,
                            new Item.Properties().group(ModCourse.COURSE_TAB)));

    public static final RegistryObject<Item> COPPER_BOOTS =
            Registration.ITEMS.register("copper_boots",
                    () -> new ArmorItem(ModArmorMaterial.COPPER, EquipmentSlotType.FEET,
                            new Item.Properties().group(ModCourse.COURSE_TAB)));

    /*Crops*/
    public static final RegistryObject<Item> ZUCCINI_SEED =
            Registration.ITEMS.register("zuccini_seed",
                    ()-> new BlockItem(ModBlocks.ZUCCINI_CROP.get(),
                            new Item.Properties().group(ModCourse.COURSE_TAB)));

    /*Fluids*/
    public static final RegistryObject<Item> OIL_BUCKET =
            Registration.ITEMS.register("oil_bucket",
                    ()-> new BucketItem(ModFluids.OIL_FLUID::get,
                            new Item.Properties().group(ModCourse.COURSE_TAB).maxStackSize(1)));

    /*Entity Eggs*/
    public static final RegistryObject<ModSpawnEggItem> BUFFALO_SPAWNING_EGG =
            Registration.ITEMS.register("buffalo_spawn_egg",
                    ()-> new ModSpawnEggItem(ModEntityTypes.BUFFALO,0xF02F4A,0x7034F1,
                            new Item.Properties().group(ModCourse.COURSE_TAB)));

    public static void register() { }

    public enum ModArmorMaterial implements IArmorMaterial
    {
        COPPER(50, new int[]{ 2, 5, 7, 3 }, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON,
                Ingredient.fromStacks(new ItemStack(ModItems.COPPER_INGOT.get())),
                ModCourse.MOD_ID + ":copper", 0, 0.1f);

        private final int durability;
        private final int[] damageReductionAmountArray;
        private final int enchantability;
        private final SoundEvent soundEvent;
        private final Ingredient repairMaterial;
        private final String name;
        private final float toughness;
        private final float knockbackResistance;

        ModArmorMaterial(int durability, int[] damageReductionAmountArray, int enchantability,
                         SoundEvent soundEvent, Ingredient repairMaterial, String name, float toughness, float knockbackResistance) {
            this.durability = durability;
            this.damageReductionAmountArray = damageReductionAmountArray;
            this.enchantability = enchantability;
            this.soundEvent = soundEvent;
            this.repairMaterial = repairMaterial;
            this.name = name;
            this.toughness = toughness;
            this.knockbackResistance = knockbackResistance;
        }

        @Override
        public int getDurability(EquipmentSlotType slotIn) {
            return durability;
        }

        @Override
        public int getDamageReductionAmount(EquipmentSlotType slotIn) {
            return damageReductionAmountArray[slotIn.getIndex()];
        }

        @Override
        public int getEnchantability() {
            return enchantability;
        }

        @Override
        public SoundEvent getSoundEvent() {
            return soundEvent;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return repairMaterial;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public float getToughness() {
            return toughness;
        }

        @Override
        public float getKnockbackResistance() {
            return knockbackResistance;
        }
    }

    public enum ModItemTier implements IItemTier
    {
        COPPER(2, 150, 2.5f, 0f, 15,
                Ingredient.fromStacks(new ItemStack(ModItems.COPPER_INGOT.get())));

        private final int harvestLevel;
        private final int maxUses;
        private final float efficiency;
        private final float attackDamage;
        private final int enchantability;
        private final Ingredient repairMaterial;

        ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Ingredient repairMaterial) {
            this.harvestLevel = harvestLevel;
            this.maxUses = maxUses;
            this.efficiency = efficiency;
            this.attackDamage = attackDamage;
            this.enchantability = enchantability;
            this.repairMaterial = repairMaterial;
        }

        @Override
        public int getMaxUses() {
            return maxUses;
        }

        @Override
        public float getEfficiency() {
            return efficiency;
        }

        @Override
        public float getAttackDamage() {
            return attackDamage;
        }

        @Override
        public int getHarvestLevel() {
            return harvestLevel;
        }

        @Override
        public int getEnchantability() {
            return enchantability;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return repairMaterial;
        }
    }
}
