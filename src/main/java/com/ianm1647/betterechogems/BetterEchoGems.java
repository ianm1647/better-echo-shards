package com.ianm1647.betterechogems;

import com.ianm1647.betterechogems.item.ToolMaterials;
import com.ianm1647.betterechogems.item.ToolSet;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BetterEchoGems implements ModInitializer {
	public static final String MODID = "betterechogems";
	public static final Logger LOGGER = LoggerFactory.getLogger(MODID);
	public static final ItemGroup GROUP = FabricItemGroupBuilder.build(new Identifier(MODID, "group"),
			() -> new ItemStack(Registry.ITEM.get(new Identifier(MODID, "echorite_ingot"))));

	@Override
	public void onInitialize() {
		item("echorite_ingot");
		toolSet("echorite", ToolMaterials.ECHORITE);
	}

	private static void item(String name) {
		Registry.register(Registry.ITEM, new Identifier(BetterEchoGems.MODID, name),
				new Item(new FabricItemSettings().group(GROUP)));
	}

	private static void toolSet(String name, ToolMaterial material) {
		new ToolSet(material).register(name);
	}
}
