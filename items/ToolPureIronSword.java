package mods.simwir.puremetals.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.simwir.puremetals.lib.References;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ToolPureIronSword extends ItemSword {

	public ToolPureIronSword(int par1, EnumToolMaterial mat) {
		super(par1, mat);

		setUnlocalizedName("pureIronSword");
		setMaxDamage(250);
	}
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister){
	         this.itemIcon = iconRegister.registerIcon(References.MOD_ID+":"+this.getUnlocalizedName().substring(5));
	}
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack par1ItemStack)
	{
	    return true;
	}
}

