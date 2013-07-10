package mods.simwir.puremetals.items;

import mods.simwir.puremetals.lib.References;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemIronDust extends Item{
	public ItemIronDust(int par1) {
		super(par1);
		
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName("ironDust");
		setMaxStackSize(64);
	}
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister){
	         this.itemIcon = iconRegister.registerIcon(References.MOD_ID+":"+this.getUnlocalizedName().substring(5));
	}
}
