package net.kato.carrot.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties KARROT = new FoodProperties.Builder().nutrition(3).saturationModifier(0.25f)
            .effect(()-> new MobEffectInstance(MobEffects.LEVITATION, 200),1).build();
}