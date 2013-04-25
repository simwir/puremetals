package mods.simwir.puremetals.common.core.handlers;

import mods.simwir.puremetals.PureMetals;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.ICraftingHandler;

public class CraftingHandler  implements ICraftingHandler{

	@Override
	public void onCrafting(EntityPlayer player, ItemStack item,
			IInventory craftMatrix) {
		for(int i=0; i<craftMatrix.getSizeInventory(); i++){ //Checks all slots
			if(craftMatrix.getStackInSlot(i) != null){ //Checks if there are a item in selected slot
				ItemStack j = craftMatrix.getStackInSlot(i); //stores the item in item
				if(j.getItem() != null && j.getItem() == PureMetals.chisel){ // if the item is a chisel
					ItemStack k = new ItemStack(PureMetals.chisel, 2, (j.getItemDamage()+1)); //Makes a new itemstack that's been damaged and has 2 items
					if(k.getItemDamage()>= k.getMaxDamage()){ //if the item is destroyed
						k.stackSize--; //removes added item
					}
					craftMatrix.setInventorySlotContents(i, k); //sets the slot to a new item
				}
			}
			
		}
		
	}

	@Override
	public void onSmelting(EntityPlayer player, ItemStack item) {
		// TODO Auto-generated method stub
		
	}
	
}
