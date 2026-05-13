package net.kato.carrot.item;

import net.kato.carrot.Carrot;
import net.kato.carrot.item.custom.ChiselItem;
import net.kato.carrot.item.custom.FuelItem;
import net.kato.carrot.item.custom.LockerItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class ModItems {
public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Carrot.MOD_ID);

public static final DeferredItem<Item> SILVER = ITEMS.register("silver",
        () -> new Item(new Item.Properties()));

public static final DeferredItem<Item> BRONZE = ITEMS.register("bronze",
        ()-> new Item(new Item.Properties()));

public static final DeferredItem<Item> WAND = ITEMS.register("wand",
        ()-> new ChiselItem(new Item.Properties().durability(32)));

public static final DeferredItem<Item> KARROT = ITEMS.register("karrot",
        ()-> new Item(new Item.Properties().food(ModFoodProperties.KARROT)) {
            @Override
            public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                tooltipComponents.add(Component.translatable("tooltip.hell.karrot.tooltip"));
                super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
            }
        });

public static final DeferredItem<Item> LOCKER = ITEMS.register("locker",
        () -> new LockerItem(new Item.Properties()));

public static final DeferredItem<Item> WALAHI = ITEMS.register("walahi",
        () -> new Item(new Item.Properties()));

public static final DeferredItem<Item> FIRST_COAL = ITEMS.register("first_coal",
        () -> new FuelItem(new Item.Properties(), 200));

public static final DeferredItem<Item> SECOND_COAL = ITEMS.register("second_coal",
        ()-> new Item(new Item.Properties()));

;

public static void register(IEventBus eventBus) {
    ITEMS.register(eventBus);
}
}
