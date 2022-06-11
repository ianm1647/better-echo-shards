package com.ianm1647.betterechoshards;

import com.ianm1647.betterechoshards.item.ArmorMaterials;
import com.ianm1647.betterechoshards.item.ArmorSet;
import com.ianm1647.betterechoshards.item.ToolMaterials;
import com.ianm1647.betterechoshards.item.ToolSet;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BetterEchoShards implements ModInitializer {
	public static final String MODID = "betterechoshards";
	public static final Logger LOGGER = LoggerFactory.getLogger(MODID);
	public static final ItemGroup GROUP = FabricItemGroupBuilder.build(new Identifier(MODID, "group"),
			() -> new ItemStack(Registry.ITEM.get(new Identifier(MODID, "echorite_ingot"))));

	@Override
	public void onInitialize() {
		item("echorite_ingot");
		toolSet("echorite", ToolMaterials.ECHORITE);
		armorSet("echorite", ArmorMaterials.ECHORITE);

		block("echo_shard_block", new Block(blockSettings(Material.AMETHYST, 1.5F, 0, BlockSoundGroup.AMETHYST_BLOCK)));
		block("echorite_block", new Block(blockSettings(Material.METAL, 55.0F, 1200.0F, BlockSoundGroup.NETHERITE)));
	}

	private static void item(String name) {
		Registry.register(Registry.ITEM, new Identifier(BetterEchoShards.MODID, name),
				new Item(new FabricItemSettings().group(GROUP)));
	}

	private static void block(String name, Block block) {
		blockItem(name, block);
		Registry.register(Registry.BLOCK, new Identifier(MODID, name), block);
	}

	private static void blockItem(String name, Block block) {
		Registry.register(Registry.ITEM, new Identifier(MODID, name),
				new BlockItem(block, new FabricItemSettings().group(GROUP)));
	}

	private static FabricBlockSettings blockSettings(Material material, float hardness, float resistance, BlockSoundGroup sound) {
		return FabricBlockSettings.of(material).strength(hardness, resistance).sounds(sound).requiresTool();
	}

	private static void toolSet(String name, ToolMaterial material) {
		new ToolSet(material).register(name);
	}

	private static void armorSet(String name, ArmorMaterial material) {
		new ArmorSet(material).register(name);
	}
}
