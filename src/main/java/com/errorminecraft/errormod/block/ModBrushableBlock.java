package com.errorminecraft.errormod.block;

import com.errorminecraft.errormod.ErrorMod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BrushableBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BrushableBlockEntity;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.loot.LootTable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class ModBrushableBlock extends BrushableBlock {
    private final RegistryKey<LootTable> lootTable;
    public ModBrushableBlock(Block baseBlock, String lootTable) {
        super(
                baseBlock,
                SoundEvents.ITEM_BRUSH_BRUSHING_SAND,
                SoundEvents.ITEM_BRUSH_BRUSHING_SAND_COMPLETE,
                AbstractBlock.Settings.create()
                        .strength(0.25F)
                        .sounds(BlockSoundGroup.SUSPICIOUS_SAND)
                        .pistonBehavior(PistonBehavior.DESTROY)
        );
        this.lootTable=RegistryKey.of(RegistryKeys.LOOT_TABLE,Identifier.of(ErrorMod.MOD_ID, lootTable));
    }
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        BrushableBlockEntity brushableBlockEntity = new BrushableBlockEntity(pos, state);
        brushableBlockEntity.setLootTable(lootTable,0);
        return brushableBlockEntity;
    }
}
