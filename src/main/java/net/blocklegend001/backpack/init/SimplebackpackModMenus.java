
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.blocklegend001.backpack.init;

import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.AbstractContainerMenu;

import net.blocklegend001.backpack.world.inventory.WoodenBackpackGUIMenu;
import net.blocklegend001.backpack.world.inventory.NetheriteBackpackGUIMenu;
import net.blocklegend001.backpack.world.inventory.IronBackpackGUIMenu;
import net.blocklegend001.backpack.world.inventory.GoldBackpackGUIMenu;
import net.blocklegend001.backpack.world.inventory.EmeraldBackpackGUIMenu;
import net.blocklegend001.backpack.world.inventory.DiamondBackpackGUIMenu;
import net.blocklegend001.backpack.world.inventory.CopperBackpackGUIMenu;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SimplebackpackModMenus {
	private static final List<MenuType<?>> REGISTRY = new ArrayList<>();
	public static final MenuType<WoodenBackpackGUIMenu> WOODEN_BACKPACK_GUI = register("wooden_backpack_gui",
			(id, inv, extraData) -> new WoodenBackpackGUIMenu(id, inv, extraData));
	public static final MenuType<IronBackpackGUIMenu> IRON_BACKPACK_GUI = register("iron_backpack_gui",
			(id, inv, extraData) -> new IronBackpackGUIMenu(id, inv, extraData));
	public static final MenuType<GoldBackpackGUIMenu> GOLD_BACKPACK_GUI = register("gold_backpack_gui",
			(id, inv, extraData) -> new GoldBackpackGUIMenu(id, inv, extraData));
	public static final MenuType<CopperBackpackGUIMenu> COPPER_BACKPACK_GUI = register("copper_backpack_gui",
			(id, inv, extraData) -> new CopperBackpackGUIMenu(id, inv, extraData));
	public static final MenuType<DiamondBackpackGUIMenu> DIAMOND_BACKPACK_GUI = register("diamond_backpack_gui",
			(id, inv, extraData) -> new DiamondBackpackGUIMenu(id, inv, extraData));
	public static final MenuType<EmeraldBackpackGUIMenu> EMERALD_BACKPACK_GUI = register("emerald_backpack_gui",
			(id, inv, extraData) -> new EmeraldBackpackGUIMenu(id, inv, extraData));
	public static final MenuType<NetheriteBackpackGUIMenu> NETHERITE_BACKPACK_GUI = register("netherite_backpack_gui",
			(id, inv, extraData) -> new NetheriteBackpackGUIMenu(id, inv, extraData));

	private static <T extends AbstractContainerMenu> MenuType<T> register(String registryname, IContainerFactory<T> containerFactory) {
		MenuType<T> menuType = new MenuType<T>(containerFactory);
		menuType.setRegistryName(registryname);
		REGISTRY.add(menuType);
		return menuType;
	}

	@SubscribeEvent
	public static void registerContainers(RegistryEvent.Register<MenuType<?>> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new MenuType[0]));
	}
}
