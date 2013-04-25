package mods.simwir.puremetals.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.simwir.puremetals.lib.ItemReferences;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.Icon;

public class IngotPureIron extends Item{

	public IngotPureIron(int par1) {
		super(par1);
		
		setCreativeTab(CreativeTabs.tabMaterials);
		setUnlocalizedName("pureIron");
		setMaxStackSize(64);
	}
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister){
	         this.itemIcon = iconRegister.registerIcon("simwir/puremetals:"+this.getUnlocalizedName().substring(5));
	}

}
