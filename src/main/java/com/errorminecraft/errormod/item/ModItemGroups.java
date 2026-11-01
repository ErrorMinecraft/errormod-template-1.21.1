package com.errorminecraft.errormod.item;

import com.errorminecraft.errormod.ErrorMod;
import com.errorminecraft.errormod.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final RegistryKey<ItemGroup> MOD_GROUP = register("mod_group");
    private static RegistryKey<ItemGroup> register(String id) {
        return RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of(ErrorMod.MOD_ID,id));
    }
    public static void registerModItemGroups(){

        Registry.register(
                Registries.ITEM_GROUP,
                MOD_GROUP,
                ItemGroup.create(null,-1)
                        .displayName(Text.translatable("itemgroup.mod_group"))
                        .icon(() -> new ItemStack(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE))
                        .entries((displayContext, entries) -> {
                            entries.add(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE);
                            entries.add(ModItems.IRON_UPGRADE_SMITHING_TEMPLATE);
                            entries.add(ModItems.GOLDEN_UPGRADE_SMITHING_TEMPLATE);
                            entries.add(ModItems.MACE_UPGRADE_SMITHING_TEMPLATE);
                            entries.add(ModItems.ENDER_EYE_UPGRADE_SMITHING_TEMPLATE);
                            entries.add(ModBlocks.SUSPICIOUS_IRON_ORE);
                            entries.add(ModBlocks.SUSPICIOUS_COPPER_BLOCK);
                            entries.add(ModBlocks.SUSPICIOUS_MOSSY_STONE_BRICKS);
                        })
                        .build()
                );
        ErrorMod.LOGGER.info("Registering Item Groups");
    }
}
