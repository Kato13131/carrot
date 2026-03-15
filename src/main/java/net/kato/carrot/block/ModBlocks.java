package net.kato.carrot.block;

import net.kato.carrot.block.custom.MagicBlock;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;

import net.kato.carrot.Carrot;
import net.kato.carrot.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(Carrot.MOD_ID);



    public static  final DeferredBlock<Block> CARROT_BLOCK = registerBlock("carrot_block",
            ()-> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().sound(SoundType.CHAIN)));

    public static  final  DeferredBlock<Block> CARROT_ORE = registerBlock("carrot_ore",
            ()-> new DropExperienceBlock(UniformInt.of(2, 4),
                    BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.GLASS)));
    public static  final  DeferredBlock<Block> CARROT_DEEPSLATE_ORE = registerBlock("carrot_deepslate_ore",
            ()-> new DropExperienceBlock(UniformInt.of(3, 6),
                    BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));

    public static final DeferredBlock<Block> MAGICAL_BLOCK = registerBlock("magical_block",
            ()-> new MagicBlock(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.GRASS)));




    private  static  <T extends  Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return  toReturn;
    }



    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
