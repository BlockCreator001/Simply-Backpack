
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.blocklegend001.backpack.init;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class SimplebackpackModTabs {
	public static CreativeModeTab TAB_SIMPLE_BACKPACK;

	public static void load() {
		TAB_SIMPLE_BACKPACK = new CreativeModeTab("tabsimple_backpack") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(SimplebackpackModItems.NETHERITE_BACKPACK.get());
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
}
