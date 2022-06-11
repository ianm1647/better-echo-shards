package com.ianm1647.betterechogems.item;

import com.ianm1647.betterechogems.BetterEchoGems;
import com.ianm1647.betterechogems.item.mod.*;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.function.Consumer;

public class ToolSet {

    //template from Mythic Metals

    private final SwordItem sword;
    private final AxeItem axe;
    private final PickaxeItem pickaxe;
    private final ShovelItem shovel;
    private final HoeItem hoe;

    private static Item.Settings createSettings(Consumer<Item.Settings> settingsProcessor) {
        final var settings = new Item.Settings().group(BetterEchoGems.GROUP);
        settingsProcessor.accept(settings);
        return settings;
    }

    public ToolSet(ToolMaterial material) {
        this(material, settings -> {});
    }

    public ToolSet(ToolMaterial material, Consumer<Item.Settings> settingsProcessor) {
        this.sword = this.makeSword(material, createSettings(settingsProcessor));
        this.axe = this.makeAxe(material, createSettings(settingsProcessor));
        this.pickaxe = this.makePickaxe(material, createSettings(settingsProcessor));
        this.shovel = this.makeShovel(material, createSettings(settingsProcessor));
        this.hoe = this.makeHoe(material, createSettings(settingsProcessor));
    }

    public void register(String name) {
        String modid = BetterEchoGems.MODID;
        Registry.register(Registry.ITEM, new Identifier(modid, name + "_sword"), sword);
        Registry.register(Registry.ITEM, new Identifier(modid, name + "_axe"), axe);
        Registry.register(Registry.ITEM, new Identifier(modid, name + "_pickaxe"), pickaxe);
        Registry.register(Registry.ITEM, new Identifier(modid, name + "_shovel"), shovel);
        Registry.register(Registry.ITEM, new Identifier(modid, name + "_hoe"), hoe);
    }

    protected SwordItem makeSword(ToolMaterial material, Item.Settings settings) {
        return new ModSword(material, settings);
    }

    protected AxeItem makeAxe(ToolMaterial material, Item.Settings settings) {
        return new ModAxe(material, settings);
    }

    protected PickaxeItem makePickaxe(ToolMaterial material, Item.Settings settings) {
        return new ModPickaxe(material, settings);
    }

    protected ShovelItem makeShovel(ToolMaterial material, Item.Settings settings) {
        return new ModShovel(material, settings);
    }

    protected HoeItem makeHoe(ToolMaterial material, Item.Settings settings) {
        return new ModHoe(material, settings);
    }

    public SwordItem getSword() {
        return sword;
    }

    public AxeItem getAxe() {
        return axe;
    }

    public PickaxeItem getPickaxe() {
        return pickaxe;
    }

    public ShovelItem getShovel() {
        return shovel;
    }

    public HoeItem getHoe() {
        return hoe;
    }
}
