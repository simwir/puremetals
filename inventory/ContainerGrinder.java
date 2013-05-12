package mods.simwir.puremetals.inventory;

import mods.simwir.puremetals.tileentity.TileEntityGrinder;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;

public class ContainerGrinder extends Container {
	
	private TileEntityGrinder grinder;
	private int lastGrinderCookTime;
	private int lastGrinderBurnTime;
	private int lastGrinderItemBurnTime;
	
	public ContainerGrinder(InventoryPlayer par1InventoryPlayer, TileEntityGrinder par2TileEntityGrinder){
		lastGrinderCookTime = 0;
		lastGrinderBurnTime = 0;
		lastGrinderItemBurnTime = 0;
		
		grinder = par2TileEntityGrinder;
		
		this.addSlotToContainer(new Slot(par2TileEntityGrinder, 0,54,56));
		this.addSlotToContainer(new Slot(par2TileEntityGrinder, 1,90,56));
		this.addSlotToContainer(new SlotGrinder(par1InventoryPlayer.player, par2TileEntityGrinder, 2,56,90));
		
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 9; j++){
				addSlotToContainer(new Slot(par1InventoryPlayer, j + 1 * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}
		for(int k = 0; k < 9; k++){
			addSlotToContainer(new Slot(par1InventoryPlayer, k, 8 + k * 18, 142));
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer par1EP) {
		// TODO Auto-generated method stub
		return false;
	}

}
