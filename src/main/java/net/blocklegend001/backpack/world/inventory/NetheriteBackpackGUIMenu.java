
package net.blocklegend001.backpack.world.inventory;

import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.blocklegend001.backpack.init.SimplebackpackModMenus;

import java.util.function.Supplier;
import java.util.Map;
import java.util.HashMap;

public class NetheriteBackpackGUIMenu extends AbstractContainerMenu implements Supplier<Map<Integer, Slot>> {
	public final static HashMap<String, Object> guistate = new HashMap<>();
	public final Level world;
	public final Player entity;
	public int x, y, z;
	private IItemHandler internal;
	private final Map<Integer, Slot> customSlots = new HashMap<>();
	private boolean bound = false;

	public NetheriteBackpackGUIMenu(int id, Inventory inv, FriendlyByteBuf extraData) {
		super(SimplebackpackModMenus.NETHERITE_BACKPACK_GUI, id);
		this.entity = inv.player;
		this.world = inv.player.level;
		this.internal = new ItemStackHandler(90);
		BlockPos pos = null;
		if (extraData != null) {
			pos = extraData.readBlockPos();
			this.x = pos.getX();
			this.y = pos.getY();
			this.z = pos.getZ();
		}
		if (pos != null) {
			if (extraData.readableBytes() == 1) { // bound to item
				byte hand = extraData.readByte();
				ItemStack itemstack;
				if (hand == 0)
					itemstack = this.entity.getMainHandItem();
				else
					itemstack = this.entity.getOffhandItem();
				itemstack.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					this.internal = capability;
					this.bound = true;
				});
			} else if (extraData.readableBytes() > 1) {
				extraData.readByte(); // drop padding
				Entity entity = world.getEntity(extraData.readVarInt());
				if (entity != null)
					entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						this.internal = capability;
						this.bound = true;
					});
			} else { // might be bound to block
				BlockEntity ent = inv.player != null ? inv.player.level.getBlockEntity(pos) : null;
				if (ent != null) {
					ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						this.internal = capability;
						this.bound = true;
					});
				}
			}
		}
		this.customSlots.put(0, this.addSlot(new SlotItemHandler(internal, 0, 58, 37) {
		}));
		this.customSlots.put(1, this.addSlot(new SlotItemHandler(internal, 1, 76, 37) {
		}));
		this.customSlots.put(2, this.addSlot(new SlotItemHandler(internal, 2, 94, 37) {
		}));
		this.customSlots.put(3, this.addSlot(new SlotItemHandler(internal, 3, 112, 37) {
		}));
		this.customSlots.put(4, this.addSlot(new SlotItemHandler(internal, 4, 130, 37) {
		}));
		this.customSlots.put(5, this.addSlot(new SlotItemHandler(internal, 5, 148, 37) {
		}));
		this.customSlots.put(6, this.addSlot(new SlotItemHandler(internal, 6, 166, 37) {
		}));
		this.customSlots.put(7, this.addSlot(new SlotItemHandler(internal, 7, 184, 37) {
		}));
		this.customSlots.put(8, this.addSlot(new SlotItemHandler(internal, 8, 202, 37) {
		}));
		this.customSlots.put(9, this.addSlot(new SlotItemHandler(internal, 9, 58, 57) {
		}));
		this.customSlots.put(10, this.addSlot(new SlotItemHandler(internal, 10, 58, 77) {
		}));
		this.customSlots.put(11, this.addSlot(new SlotItemHandler(internal, 11, 76, 57) {
		}));
		this.customSlots.put(12, this.addSlot(new SlotItemHandler(internal, 12, 94, 57) {
		}));
		this.customSlots.put(13, this.addSlot(new SlotItemHandler(internal, 13, 112, 57) {
		}));
		this.customSlots.put(14, this.addSlot(new SlotItemHandler(internal, 14, 130, 57) {
		}));
		this.customSlots.put(15, this.addSlot(new SlotItemHandler(internal, 15, 148, 57) {
		}));
		this.customSlots.put(16, this.addSlot(new SlotItemHandler(internal, 16, 166, 57) {
		}));
		this.customSlots.put(17, this.addSlot(new SlotItemHandler(internal, 17, 184, 57) {
		}));
		this.customSlots.put(18, this.addSlot(new SlotItemHandler(internal, 18, 202, 57) {
		}));
		this.customSlots.put(19, this.addSlot(new SlotItemHandler(internal, 19, 76, 77) {
		}));
		this.customSlots.put(20, this.addSlot(new SlotItemHandler(internal, 20, 94, 77) {
		}));
		this.customSlots.put(21, this.addSlot(new SlotItemHandler(internal, 21, 112, 77) {
		}));
		this.customSlots.put(22, this.addSlot(new SlotItemHandler(internal, 22, 130, 77) {
		}));
		this.customSlots.put(23, this.addSlot(new SlotItemHandler(internal, 23, 148, 77) {
		}));
		this.customSlots.put(24, this.addSlot(new SlotItemHandler(internal, 24, 166, 77) {
		}));
		this.customSlots.put(25, this.addSlot(new SlotItemHandler(internal, 25, 184, 77) {
		}));
		this.customSlots.put(26, this.addSlot(new SlotItemHandler(internal, 26, 202, 77) {
		}));
		this.customSlots.put(27, this.addSlot(new SlotItemHandler(internal, 27, 58, 97) {
		}));
		this.customSlots.put(28, this.addSlot(new SlotItemHandler(internal, 28, 76, 97) {
		}));
		this.customSlots.put(29, this.addSlot(new SlotItemHandler(internal, 29, 94, 97) {
		}));
		this.customSlots.put(30, this.addSlot(new SlotItemHandler(internal, 30, 112, 97) {
		}));
		this.customSlots.put(31, this.addSlot(new SlotItemHandler(internal, 31, 130, 97) {
		}));
		this.customSlots.put(32, this.addSlot(new SlotItemHandler(internal, 32, 148, 97) {
		}));
		this.customSlots.put(33, this.addSlot(new SlotItemHandler(internal, 33, 166, 97) {
		}));
		this.customSlots.put(34, this.addSlot(new SlotItemHandler(internal, 34, 184, 97) {
		}));
		this.customSlots.put(35, this.addSlot(new SlotItemHandler(internal, 35, 202, 97) {
		}));
		this.customSlots.put(36, this.addSlot(new SlotItemHandler(internal, 36, 94, 117) {
		}));
		this.customSlots.put(37, this.addSlot(new SlotItemHandler(internal, 37, 58, 17) {
		}));
		this.customSlots.put(38, this.addSlot(new SlotItemHandler(internal, 38, 76, 17) {
		}));
		this.customSlots.put(39, this.addSlot(new SlotItemHandler(internal, 39, 94, 17) {
		}));
		this.customSlots.put(40, this.addSlot(new SlotItemHandler(internal, 40, 112, 17) {
		}));
		this.customSlots.put(41, this.addSlot(new SlotItemHandler(internal, 41, 130, 17) {
		}));
		this.customSlots.put(42, this.addSlot(new SlotItemHandler(internal, 42, 148, 17) {
		}));
		this.customSlots.put(43, this.addSlot(new SlotItemHandler(internal, 43, 166, 17) {
		}));
		this.customSlots.put(44, this.addSlot(new SlotItemHandler(internal, 44, 184, 17) {
		}));
		this.customSlots.put(45, this.addSlot(new SlotItemHandler(internal, 45, 202, 17) {
		}));
		this.customSlots.put(46, this.addSlot(new SlotItemHandler(internal, 46, 112, 117) {
		}));
		this.customSlots.put(47, this.addSlot(new SlotItemHandler(internal, 47, 130, 117) {
		}));
		this.customSlots.put(48, this.addSlot(new SlotItemHandler(internal, 48, 148, 117) {
		}));
		this.customSlots.put(49, this.addSlot(new SlotItemHandler(internal, 49, 166, 117) {
		}));
		this.customSlots.put(50, this.addSlot(new SlotItemHandler(internal, 50, 184, 117) {
			@Override
			public boolean mayPlace(ItemStack stack) {
				return false;
			}
		}));
		this.customSlots.put(51, this.addSlot(new SlotItemHandler(internal, 51, 202, 117) {
		}));
		this.customSlots.put(52, this.addSlot(new SlotItemHandler(internal, 52, 76, 117) {
		}));
		this.customSlots.put(53, this.addSlot(new SlotItemHandler(internal, 53, 58, 117) {
		}));
		this.customSlots.put(54, this.addSlot(new SlotItemHandler(internal, 54, 40, 17) {
		}));
		this.customSlots.put(55, this.addSlot(new SlotItemHandler(internal, 55, 220, 17) {
		}));
		this.customSlots.put(56, this.addSlot(new SlotItemHandler(internal, 56, 40, 37) {
		}));
		this.customSlots.put(57, this.addSlot(new SlotItemHandler(internal, 57, 40, 57) {
		}));
		this.customSlots.put(58, this.addSlot(new SlotItemHandler(internal, 58, 40, 77) {
		}));
		this.customSlots.put(59, this.addSlot(new SlotItemHandler(internal, 59, 40, 97) {
		}));
		this.customSlots.put(60, this.addSlot(new SlotItemHandler(internal, 60, 40, 117) {
		}));
		this.customSlots.put(61, this.addSlot(new SlotItemHandler(internal, 61, 220, 117) {
		}));
		this.customSlots.put(62, this.addSlot(new SlotItemHandler(internal, 62, 220, 97) {
		}));
		this.customSlots.put(63, this.addSlot(new SlotItemHandler(internal, 63, 220, 77) {
		}));
		this.customSlots.put(64, this.addSlot(new SlotItemHandler(internal, 64, 220, 57) {
		}));
		this.customSlots.put(65, this.addSlot(new SlotItemHandler(internal, 65, 220, 37) {
		}));
		this.customSlots.put(66, this.addSlot(new SlotItemHandler(internal, 66, 22, 17) {
		}));
		this.customSlots.put(67, this.addSlot(new SlotItemHandler(internal, 67, 238, 17) {
		}));
		this.customSlots.put(68, this.addSlot(new SlotItemHandler(internal, 68, 22, 37) {
		}));
		this.customSlots.put(69, this.addSlot(new SlotItemHandler(internal, 69, 22, 57) {
		}));
		this.customSlots.put(70, this.addSlot(new SlotItemHandler(internal, 70, 22, 77) {
		}));
		this.customSlots.put(71, this.addSlot(new SlotItemHandler(internal, 71, 22, 97) {
		}));
		this.customSlots.put(72, this.addSlot(new SlotItemHandler(internal, 72, 22, 117) {
		}));
		this.customSlots.put(73, this.addSlot(new SlotItemHandler(internal, 73, 238, 37) {
		}));
		this.customSlots.put(74, this.addSlot(new SlotItemHandler(internal, 74, 238, 57) {
		}));
		this.customSlots.put(75, this.addSlot(new SlotItemHandler(internal, 75, 238, 77) {
		}));
		this.customSlots.put(76, this.addSlot(new SlotItemHandler(internal, 76, 238, 97) {
		}));
		this.customSlots.put(77, this.addSlot(new SlotItemHandler(internal, 77, 238, 117) {
		}));
		this.customSlots.put(78, this.addSlot(new SlotItemHandler(internal, 78, 4, 17) {
		}));
		this.customSlots.put(79, this.addSlot(new SlotItemHandler(internal, 79, 256, 17) {
		}));
		this.customSlots.put(80, this.addSlot(new SlotItemHandler(internal, 80, 4, 37) {
		}));
		this.customSlots.put(81, this.addSlot(new SlotItemHandler(internal, 81, 4, 57) {
		}));
		this.customSlots.put(82, this.addSlot(new SlotItemHandler(internal, 82, 4, 77) {
		}));
		this.customSlots.put(83, this.addSlot(new SlotItemHandler(internal, 83, 4, 97) {
		}));
		this.customSlots.put(84, this.addSlot(new SlotItemHandler(internal, 84, 4, 117) {
		}));
		this.customSlots.put(85, this.addSlot(new SlotItemHandler(internal, 85, 256, 37) {
		}));
		this.customSlots.put(86, this.addSlot(new SlotItemHandler(internal, 86, 256, 57) {
		}));
		this.customSlots.put(87, this.addSlot(new SlotItemHandler(internal, 87, 256, 77) {
		}));
		this.customSlots.put(88, this.addSlot(new SlotItemHandler(internal, 88, 256, 97) {
		}));
		this.customSlots.put(89, this.addSlot(new SlotItemHandler(internal, 89, 256, 117) {
		}));
		for (int si = 0; si < 3; ++si)
			for (int sj = 0; sj < 9; ++sj)
				this.addSlot(new Slot(inv, sj + (si + 1) * 9, 52 + 8 + sj * 18, 55 + 84 + si * 18));
		for (int si = 0; si < 9; ++si)
			this.addSlot(new Slot(inv, si, 52 + 8 + si * 18, 55 + 142));
	}

	@Override
	public boolean stillValid(Player player) {
		return true;
	}

	@Override
	public ItemStack quickMoveStack(Player playerIn, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = (Slot) this.slots.get(index);
		if (slot != null && slot.hasItem()) {
			ItemStack itemstack1 = slot.getItem();
			itemstack = itemstack1.copy();
			if (index < 90) {
				if (!this.moveItemStackTo(itemstack1, 90, this.slots.size(), true)) {
					return ItemStack.EMPTY;
				}
				slot.onQuickCraft(itemstack1, itemstack);
			} else if (!this.moveItemStackTo(itemstack1, 0, 90, false)) {
				if (index < 90 + 27) {
					if (!this.moveItemStackTo(itemstack1, 90 + 27, this.slots.size(), true)) {
						return ItemStack.EMPTY;
					}
				} else {
					if (!this.moveItemStackTo(itemstack1, 90, 90 + 27, false)) {
						return ItemStack.EMPTY;
					}
				}
				return ItemStack.EMPTY;
			}
			if (itemstack1.getCount() == 0) {
				slot.set(ItemStack.EMPTY);
			} else {
				slot.setChanged();
			}
			if (itemstack1.getCount() == itemstack.getCount()) {
				return ItemStack.EMPTY;
			}
			slot.onTake(playerIn, itemstack1);
		}
		return itemstack;
	}

	@Override
	protected boolean moveItemStackTo(ItemStack p_38904_, int p_38905_, int p_38906_, boolean p_38907_) {
		boolean flag = false;
		int i = p_38905_;
		if (p_38907_) {
			i = p_38906_ - 1;
		}
		if (p_38904_.isStackable()) {
			while (!p_38904_.isEmpty()) {
				if (p_38907_) {
					if (i < p_38905_) {
						break;
					}
				} else if (i >= p_38906_) {
					break;
				}
				Slot slot = this.slots.get(i);
				ItemStack itemstack = slot.getItem();
				if (slot.mayPlace(itemstack) && !itemstack.isEmpty() && ItemStack.isSameItemSameTags(p_38904_, itemstack)) {
					int j = itemstack.getCount() + p_38904_.getCount();
					int maxSize = Math.min(slot.getMaxStackSize(), p_38904_.getMaxStackSize());
					if (j <= maxSize) {
						p_38904_.setCount(0);
						itemstack.setCount(j);
						slot.set(itemstack);
						flag = true;
					} else if (itemstack.getCount() < maxSize) {
						p_38904_.shrink(maxSize - itemstack.getCount());
						itemstack.setCount(maxSize);
						slot.set(itemstack);
						flag = true;
					}
				}
				if (p_38907_) {
					--i;
				} else {
					++i;
				}
			}
		}
		if (!p_38904_.isEmpty()) {
			if (p_38907_) {
				i = p_38906_ - 1;
			} else {
				i = p_38905_;
			}
			while (true) {
				if (p_38907_) {
					if (i < p_38905_) {
						break;
					}
				} else if (i >= p_38906_) {
					break;
				}
				Slot slot1 = this.slots.get(i);
				ItemStack itemstack1 = slot1.getItem();
				if (itemstack1.isEmpty() && slot1.mayPlace(p_38904_)) {
					if (p_38904_.getCount() > slot1.getMaxStackSize()) {
						slot1.set(p_38904_.split(slot1.getMaxStackSize()));
					} else {
						slot1.set(p_38904_.split(p_38904_.getCount()));
					}
					slot1.setChanged();
					flag = true;
					break;
				}
				if (p_38907_) {
					--i;
				} else {
					++i;
				}
			}
		}
		return flag;
	}

	@Override
	public void removed(Player playerIn) {
		super.removed(playerIn);
		if (!bound && playerIn instanceof ServerPlayer serverPlayer) {
			if (!serverPlayer.isAlive() || serverPlayer.hasDisconnected()) {
				for (int j = 0; j < internal.getSlots(); ++j) {
					playerIn.drop(internal.extractItem(j, internal.getStackInSlot(j).getCount(), false), false);
				}
			} else {
				for (int i = 0; i < internal.getSlots(); ++i) {
					playerIn.getInventory().placeItemBackInInventory(internal.extractItem(i, internal.getStackInSlot(i).getCount(), false));
				}
			}
		}
	}

	public Map<Integer, Slot> get() {
		return customSlots;
	}
}
