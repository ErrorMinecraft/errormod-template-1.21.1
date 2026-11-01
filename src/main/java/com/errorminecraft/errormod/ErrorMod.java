package com.errorminecraft.errormod;

import com.errorminecraft.errormod.block.ModBlocks;
import com.errorminecraft.errormod.block.entity.ModBlockEntities;
import com.errorminecraft.errormod.item.ModItemGroups;
import com.errorminecraft.errormod.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.entity.BlockEntityType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class ErrorMod implements ModInitializer {
	public static final String MOD_ID = "errormod";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModBlockEntities.registerModBlockEntities();
		ModItemGroups.registerModItemGroups();

		BlockEntityType.BRUSHABLE_BLOCK.addSupportedBlock(ModBlocks.SUSPICIOUS_IRON_ORE);
		BlockEntityType.BRUSHABLE_BLOCK.addSupportedBlock(ModBlocks.SUSPICIOUS_COPPER_BLOCK);

        try {
			Files.createDirectories(FabricLoader.getInstance().getConfigDir().resolve("reliable_replacer"));
			Files.copy(getClass().getResourceAsStream("/reliable_replacer_config.json"),FabricLoader.getInstance().getConfigDir().resolve("reliable_replacer").resolve("reliable_replacer_config.json"), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		LOGGER.info("ErrorMod Loaded!");
	}
}