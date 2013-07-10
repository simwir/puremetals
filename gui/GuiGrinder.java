package mods.simwir.puremetals.gui;

import org.lwjgl.opengl.GL11;

import mods.simwir.puremetals.inventory.ContainerGrinder;
import mods.simwir.puremetals.lib.References;
import mods.simwir.puremetals.tileentity.TileEntityGrinder;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public class GuiGrinder extends GuiContainer{
	
	private TileEntityGrinder grinderInventory;
	private static final ResourceLocation GUI_location = new ResourceLocation(References.MOD_ID+":furnace");

	public GuiGrinder(InventoryPlayer par1IP, TileEntityGrinder par2TEG) {
		super(new ContainerGrinder(par1IP, par2TEG));
		grinderInventory = par2TEG;
	}

	protected void drawGuiContainerBackgroundLayer(int par1, int par2) {
		fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, (ySize - 96 + 2), 0xffffff);
		
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		this.mc.renderEngine.func_110577_a(GUI_location);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		int j = (this.width - this.xSize) / 2;
		int k = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(j, k, 0, 0, this.xSize, this.ySize);
		int l;
		
		if (this.grinderInventory.isBurning())
        {
            l = this.grinderInventory.getBurnTimeRemainingScaled(12);
            this.drawTexturedModalRect(j + 56, k + 36 + 12 - l, 176, 12 - l, 14, l + 2);
        }

        l = this.grinderInventory.getCookProgressScaled(24);
        this.drawTexturedModalRect(j + 79, k + 34, 176, 14, l + 1, 16);
		
	}

}
