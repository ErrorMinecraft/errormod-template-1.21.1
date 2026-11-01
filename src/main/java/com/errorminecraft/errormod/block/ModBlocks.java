package com.errorminecraft.errormod.block;

import com.errorminecraft.errormod.ErrorMod;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import static net.minecraft.block.Blocks.COPPER_BLOCK;
import static net.minecraft.block.Blocks.IRON_ORE;

public class ModBlocks{
    public static final Block SUSPICIOUS_IRON_ORE = register(
            "suspicious_iron_ore",
            new ModBrushableBlock(
                    IRON_ORE,
                    SoundEvents.ITEM_BRUSH_BRUSHING_SAND,
                    SoundEvents.ITEM_BRUSH_BRUSHING_SAND_COMPLETE,
                    AbstractBlock.Settings.create()
                            .strength(0.25F)
                            .sounds(BlockSoundGroup.SUSPICIOUS_SAND)
                            .pistonBehavior(PistonBehavior.DESTROY),
                    "archaeology/suspicious_iron_ore"
            )
    );
    public static final Block SUSPICIOUS_COPPER_BLOCK = register(
            "suspicious_copper_block",
            new ModBrushableBlock(
                    COPPER_BLOCK,
                    SoundEvents.ITEM_BRUSH_BRUSHING_SAND,
                    SoundEvents.ITEM_BRUSH_BRUSHING_SAND_COMPLETE,
                    AbstractBlock.Settings.create()
                            .strength(0.25F)
                            .sounds(BlockSoundGroup.SUSPICIOUS_SAND)
                            .pistonBehavior(PistonBehavior.DESTROY),
                    "archaeology/suspicious_copper_block"
            )
    );

    public static void registerModItems(String id, Block block){
        Item item = Registry.register(Registries.ITEM, Identifier.of(ErrorMod.MOD_ID,id), new BlockItem(block,new Item.Settings()));
        if (item instanceof BlockItem) {
            ((BlockItem)item).appendBlocks(Item.BLOCK_ITEMS, item);
        }
    }

    public static Block register(String id, Block block) {
        registerModItems(id,block);
        return Registry.register(Registries.BLOCK, Identifier.of(ErrorMod.MOD_ID,id), block);
    }

    public static void registerModBlocks(){
        ErrorMod.LOGGER.info("Registering Blocks");
    }
}
