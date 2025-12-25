package com.errorminecraft.errormod.item;

import com.errorminecraft.errormod.ErrorMod;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item REVERSED_BOW = registerItems("reversed_bow", new Item(new Item.Settings()));
    private static Item registerItems(String id, Item item){
        //return Registry.register(Registries.ITEM, RegistryKey.of(Registries.ITEM.getKey(), Identifier.of(ErrorMod.MOD_ID,id)), item);
        return Registry.register(Registries.ITEM, Identifier.of(ErrorMod.MOD_ID,id), item);
    }
    public static void registerModItems(){
        ErrorMod.LOGGER.info("Registering Items");
    }
}
