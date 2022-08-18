
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.blocklegend001.backpack.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

import net.blocklegend001.backpack.item.WoodenBackpackItem;
import net.blocklegend001.backpack.item.NetheriteBackpackItem;
import net.blocklegend001.backpack.item.IronBackpackItem;
import net.blocklegend001.backpack.item.GoldBackpackItem;
import net.blocklegend001.backpack.item.EmeraldBackpackItem;
import net.blocklegend001.backpack.item.DiamondBackpackItem;
import net.blocklegend001.backpack.item.CopperBackpackItem;
import net.blocklegend001.backpack.SimplebackpackMod;

public class SimplebackpackModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, SimplebackpackMod.MODID);
	public static final RegistryObject<Item> WOODEN_BACKPACK = REGISTRY.register("wooden_backpack", () -> new WoodenBackpackItem());
	public static final RegistryObject<Item> IRON_BACKPACK = REGISTRY.register("iron_backpack", () -> new IronBackpackItem());
	public static final RegistryObject<Item> COPPER_BACKPACK = REGISTRY.register("copper_backpack", () -> new CopperBackpackItem());
	public static final RegistryObject<Item> GOLD_BACKPACK = REGISTRY.register("gold_backpack", () -> new GoldBackpackItem());
	public static final RegistryObject<Item> DIAMOND_BACKPACK = REGISTRY.register("diamond_backpack", () -> new DiamondBackpackItem());
	public static final RegistryObject<Item> EMERALD_BACKPACK = REGISTRY.register("emerald_backpack", () -> new EmeraldBackpackItem());
	public static final RegistryObject<Item> NETHERITE_BACKPACK = REGISTRY.register("netherite_backpack", () -> new NetheriteBackpackItem());
}
