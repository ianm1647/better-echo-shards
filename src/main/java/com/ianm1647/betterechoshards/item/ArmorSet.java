package com.ianm1647.betterechoshards.item;

import com.ianm1647.betterechoshards.BetterEchoShards;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.function.Consumer;

public class ArmorSet {

    //template from Mythic Metals

    private final ArmorItem helmet;
    private final ArmorItem chestplate;
    private final ArmorItem leggings;
    private final ArmorItem boots;

    public ArmorItem baseArmorItem(ArmorMaterial material, EquipmentSlot slot, Consumer<Item.Settings> settingsProcessor) {
        final var settings = new Item.Settings().group(BetterEchoShards.GROUP);
        settingsProcessor.accept(settings);
        return this.makeItem(material, slot, settings);
    }

    public ArmorSet(ArmorMaterial material) {
        this(material, settings -> {
        });
    }

    public ArmorSet(ArmorMaterial material, Consumer<Item.Settings> settingsProcessor) {
        this.helmet = baseArmorItem(material, EquipmentSlot.HEAD, settingsProcessor);
        this.chestplate = baseArmorItem(material, EquipmentSlot.CHEST, settingsProcessor);
        this.leggings = baseArmorItem(material, EquipmentSlot.LEGS, settingsProcessor);
        this.boots = baseArmorItem(material, EquipmentSlot.FEET, settingsProcessor);
    }

    public void register(String name) {
        String modid = BetterEchoShards.MODID;
        Registry.register(Registry.ITEM, new Identifier(modid, name + "_head"), helmet);
        Registry.register(Registry.ITEM, new Identifier(modid, name + "_chest"), chestplate);
        Registry.register(Registry.ITEM, new Identifier(modid, name + "_legs"), leggings);
        Registry.register(Registry.ITEM, new Identifier(modid, name + "_feet"), boots);
    }

    protected ArmorItem makeItem(ArmorMaterial material, EquipmentSlot slot, Item.Settings settings) {
        return new ArmorItem(material, slot, settings);
    }

    public ArmorItem getHelmet() {
        return helmet;
    }

    public ArmorItem getChestplate() {
        return chestplate;
    }

    public ArmorItem getLeggings() {
        return leggings;
    }

    public ArmorItem getBoots() {
        return boots;
    }
}
