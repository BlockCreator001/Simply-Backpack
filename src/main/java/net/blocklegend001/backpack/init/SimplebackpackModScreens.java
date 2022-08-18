
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.blocklegend001.backpack.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.blocklegend001.backpack.client.gui.WoodenBackpackGUIScreen;
import net.blocklegend001.backpack.client.gui.NetheriteBackpackGUIScreen;
import net.blocklegend001.backpack.client.gui.IronBackpackGUIScreen;
import net.blocklegend001.backpack.client.gui.GoldBackpackGUIScreen;
import net.blocklegend001.backpack.client.gui.EmeraldBackpackGUIScreen;
import net.blocklegend001.backpack.client.gui.DiamondBackpackGUIScreen;
import net.blocklegend001.backpack.client.gui.CopperBackpackGUIScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class SimplebackpackModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(SimplebackpackModMenus.WOODEN_BACKPACK_GUI, WoodenBackpackGUIScreen::new);
			MenuScreens.register(SimplebackpackModMenus.IRON_BACKPACK_GUI, IronBackpackGUIScreen::new);
			MenuScreens.register(SimplebackpackModMenus.GOLD_BACKPACK_GUI, GoldBackpackGUIScreen::new);
			MenuScreens.register(SimplebackpackModMenus.COPPER_BACKPACK_GUI, CopperBackpackGUIScreen::new);
			MenuScreens.register(SimplebackpackModMenus.DIAMOND_BACKPACK_GUI, DiamondBackpackGUIScreen::new);
			MenuScreens.register(SimplebackpackModMenus.EMERALD_BACKPACK_GUI, EmeraldBackpackGUIScreen::new);
			MenuScreens.register(SimplebackpackModMenus.NETHERITE_BACKPACK_GUI, NetheriteBackpackGUIScreen::new);
		});
	}
}
