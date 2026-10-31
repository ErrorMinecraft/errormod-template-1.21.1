package com.errorminecraft.errormod.item;

import com.errorminecraft.errormod.ErrorMod;
import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.BrushableBlockEntity;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.LoreComponent;
import net.minecraft.component.type.UnbreakableComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModItems {
    public static final Item DIAMOND_UPGRADE_SMITHING_TEMPLATE = registerItems("diamond_upgrade_smithing_template", new Item(new Item.Settings()));
    public static final Item IRON_UPGRADE_SMITHING_TEMPLATE = registerItems("iron_upgrade_smithing_template", new Item(new Item.Settings()));
    public static final Item GOLDEN_UPGRADE_SMITHING_TEMPLATE = registerItems("golden_upgrade_smithing_template", new Item(new Item.Settings()));
    private static Item registerItems(String id, Item item){
        //return Registry.register(Registries.ITEM, RegistryKey.of(Registries.ITEM.getKey(), Identifier.of(ErrorMod.MOD_ID,id)), item);
        return Registry.register(Registries.ITEM, Identifier.of(ErrorMod.MOD_ID,id), item);
    }
    private static void addItemToIG(FabricItemGroupEntries fabricItemGroupEntries){
        fabricItemGroupEntries.add(DIAMOND_UPGRADE_SMITHING_TEMPLATE);
        fabricItemGroupEntries.add(IRON_UPGRADE_SMITHING_TEMPLATE);
        fabricItemGroupEntries.add(GOLDEN_UPGRADE_SMITHING_TEMPLATE);
    }
    String a = String.valueOf(Text.translatable("a"));
    public static void registerModItems(){
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemToIG);
        ErrorMod.LOGGER.info("Registering Items");
    }

}
