package mods.simwir.puremetals.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TileEntityGrinder extends TileEntity implements IInventory{
	private ItemStack grinderItemStacks[];

	public int grinderBurnTime;
	public int grinderItemBurnTime;
	public int grinderCookTime;
	
	public int front;
	
	private boolean isActive;
	
	public TileEntityGrinder(){
		grinderItemStacks = new ItemStack[3]; //TODO
		grinderBurnTime= 0;
		grinderItemBurnTime=0;
		grinderCookTime= 0;
	}
	public void setFrontDirection(int par1){
		this.front = par1;
	}
	
	public int getFrontDirection(){
		return this.front;
	}
	
	@Override
	public int getSizeInventory() {
		return grinderItemStacks.length;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		return grinderItemStacks[i];
	}

	@Override
	public ItemStack decrStackSize(int i, int j) {
		if(grinderItemStacks[i] != null){
			if(grinderItemStacks[i].stackSize <= j){
				ItemStack itemstack = grinderItemStacks[i];
				grinderItemStacks[i]=null;
				return itemstack;
			}
			ItemStack itemstack1 = grinderItemStacks[i].splitStack(j);
			if(grinderItemStacks[i].stackSize == 0){
				grinderItemStacks[i]=null;
			}
			return itemstack1;
		}else{
			return null;
		}
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		if(grinderItemStacks[i] != null){
			ItemStack itemstack = grinderItemStacks[i];
			grinderItemStacks[i]=null;
			return itemstack;
		}else{
			return null;
		}
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		grinderItemStacks[i]= itemstack;
		
		if(itemstack != null && itemstack.stackSize > getInventoryStackLimit()){
			itemstack.stackSize = getInventoryStackLimit();
		}
	}

	@Override
	public String getInvName() {
		return "container.grinder";
	}

	@Override
	public boolean isInvNameLocalized() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}
	
	public int getCookProgressScaled(int par1){
		return (grinderCookTime+par1) / 200;
	}
	
	public int getBurnTimeRemainingScaled(int par1){
		if(grinderItemBurnTime == 0){
			grinderItemBurnTime = 200;
		}
		return (grinderItemBurnTime * par1) / grinderItemBurnTime;
	}
	
	public boolean isBurning(){
		return grinderBurnTime > 0;
	}
	

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		if(worldObj.getBlockTileEntity(xCoord, yCoord, zCoord)!= this){
			return false;
		}
		
		return entityplayer.getDistanceSq((double) xCoord + 0.5D, (double) yCoord+0.5D,(double) zCoord+0.5D) <= 64D;
	}
	/**
	private boolean canSmelt(){
		if(grinderItemStacks[0] == null){
			return false;
		}
		//TODO ItemStack itemstack = 
	}
	*/

	public static boolean isItemFuel(ItemStack par1){
		return getItemBurnTime(par1) > 0;
	}
	
	public static int getItemBurnTime(ItemStack par1){ //TODO
		return 200;
	}
	
	@Override
	public void openChest() {
		
	}

	@Override
	public void closeChest() {
		
	}
	
	public boolean isActive(){
		return this.isActive;
	}

	@Override
	public boolean isStackValidForSlot(int i, ItemStack itemstack) {
		// TODO Auto-generated method stub
		return false;
	}

}
