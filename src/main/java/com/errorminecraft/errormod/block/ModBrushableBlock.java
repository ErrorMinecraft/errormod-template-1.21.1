package com.errorminecraft.errormod.block;

import com.errorminecraft.errormod.ErrorMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BrushableBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BrushableBlockEntity;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class ModBrushableBlock extends BrushableBlock {
    private final String lootTable;
    public ModBrushableBlock(Block baseBlock, SoundEvent brushingSound, SoundEvent brushingCompleteSound, Settings settings, String lootTable) {
        super(baseBlock, brushingSound, brushingCompleteSound, settings);
        this.lootTable=lootTable;
    }
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        BrushableBlockEntity brushableBlockEntity = new BrushableBlockEntity(pos, state);
        brushableBlockEntity.setLootTable(RegistryKey.of(RegistryKeys.LOOT_TABLE,Identifier.of(ErrorMod.MOD_ID, lootTable)),0);
        return brushableBlockEntity;
    }
}
