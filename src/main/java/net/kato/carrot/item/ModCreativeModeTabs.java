package net.kato.carrot.item;

import net.kato.carrot.Carrot;
import net.kato.carrot.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import javax.swing.*;
import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Carrot.MOD_ID);

    public static final Supplier<CreativeModeTab> CARROT_TAB = CREATIVE_MODE_TAB.register("carrot_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SILVER.get()))
                    .title(Component.translatable("creativetab.hell.carrot"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.BRONZE);
                        output.accept(ModBlocks.CARROT_BLOCK);
                        output.accept(ModBlocks.CARROT_DEEPSLATE_ORE);
                        output.accept(ModBlocks.CARROT_ORE);
                        output.accept(ModItems.WAND);
                        output.accept(ModBlocks.MAGICAL_BLOCK);





                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }

}
