package net.kato.carrot.item.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.Map;

public class LockerItem extends Item {
    private static final Map<Block, Block> LOCKER_MAP =
            Map.of(
                    Blocks.CHEST, Blocks.BARREL,
                    Blocks.BARREL, Blocks.CHEST

            );

    public LockerItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();

        if (LOCKER_MAP.containsKey(clickedBlock)) {
            if(!level.isClientSide()) {
                level.setBlockAndUpdate(context.getClickedPos(), LOCKER_MAP.get(clickedBlock).defaultBlockState());

                context.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), context.getPlayer(),
                          item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.HEAD));

                level.playSound(null, context.getClickedPos(), SoundEvents.ANVIL_PLACE, SoundSource.BLOCKS);

                return InteractionResult.SUCCESS;

            }

        }




        return InteractionResult.PASS;
    }
}
