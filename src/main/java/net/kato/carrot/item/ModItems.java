package net.kato.carrot.item;

import net.kato.carrot.Carrot;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Carrot.MOD_ID);

public static final DeferredItem<Item> SILVER = ITEMS.register("silver",
        () -> new Item(new Item.Properties()));

public static final DeferredItem<Item> BRONZE = ITEMS.register("bronze",
        ()-> new Item(new Item.Properties()));
;

public static void register(IEventBus eventBus) {
    ITEMS.register(eventBus);
}
}
