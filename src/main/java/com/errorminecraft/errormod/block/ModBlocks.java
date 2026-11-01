package com.errorminecraft.errormod.block;

import com.errorminecraft.errormod.ErrorMod;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.minecraft.block.Blocks.*;

public class ModBlocks{
    public static final Block SUSPICIOUS_IRON_ORE = register(
            "suspicious_iron_ore",
            new ModBrushableBlock(IRON_ORE, "archaeology/suspicious_iron_ore")
    );
    public static final Block SUSPICIOUS_COPPER_BLOCK = register(
            "suspicious_copper_block",
            new ModBrushableBlock(COPPER_BLOCK, "archaeology/suspicious_copper_block")
    );
    public static final Block SUSPICIOUS_MOSSY_STONE_BRICKS = register(
            "suspicious_mossy_stone_bricks",
            new ModBrushableBlock(MOSSY_STONE_BRICKS,"archaeology/suspicious_mossy_stone_bricks")
    );
    public static void registerModItems(String id, Block block){
        BlockItem item = Registry.register(Registries.ITEM, Identifier.of(ErrorMod.MOD_ID,id), new BlockItem(block,new Item.Settings()));
        if (item instanceof BlockItem) {
            item.appendBlocks(Item.BLOCK_ITEMS, item);
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
