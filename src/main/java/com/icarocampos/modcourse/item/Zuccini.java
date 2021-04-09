package com.icarocampos.modcourse.item;

import com.icarocampos.modcourse.ModCourse;
import com.icarocampos.modcourse.util.Config;
import com.icarocampos.modcourse.util.KeyboardHelper;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import java.util.List;

public class Zuccini extends Item {
    public Zuccini() {
        super(new Properties().group(ModCourse.COURSE_TAB)
                .food(new Food.Builder()
                        .hunger(3)
                        .saturation(2f)
                        .build()));

    }
}