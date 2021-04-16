package com.icarocampos.modcourse.item;

import com.icarocampos.modcourse.ModCourse;
import net.minecraft.item.Food;
import net.minecraft.item.Item;

public class Zuccini extends Item {
    public Zuccini() {
        super(new Properties().group(ModCourse.COURSE_TAB)
                .food(new Food.Builder()
                        .hunger(3)
                        .saturation(2f)
                        .build()));

    }
}