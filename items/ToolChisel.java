package mods.simwir.puremetals.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ToolChisel extends Item{

	public ToolChisel(int par1) {
		super(par1);
		setCreativeTab(CreativeTabs.tabTools);
		setUnlocalizedName("chisel");
		setMaxDamage(10);
		setMaxStackSize(1);
	}
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister){
	         this.itemIcon = iconRegister.registerIcon("simwir/puremetals:"+this.getUnlocalizedName().substring(5));
	}
}

