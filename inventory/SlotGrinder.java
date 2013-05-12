package mods.simwir.puremetals.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

public class SlotGrinder extends Slot {
	
	private EntityPlayer ePlayer;
	
	private int field_75228_b;

	public SlotGrinder(EntityPlayer par1EntityPlayer, IInventory par2iInventory, int par3, int par4, int par5) {
		super(par2iInventory, par5, par3, par4);
		
		this.ePlayer = par1EntityPlayer;
	}

}
