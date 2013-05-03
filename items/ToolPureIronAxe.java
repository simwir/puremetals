package mods.simwir.puremetals.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;

public class ToolPureIronAxe extends ItemAxe{

	public ToolPureIronAxe(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		setUnlocalizedName("pureIronAxe");
		setMaxDamage(250);
	}
		
		@SideOnly(Side.CLIENT)
		public void registerIcons(IconRegister iconRegister){
		         this.itemIcon = iconRegister.registerIcon("simwir/puremetals:"+this.getUnlocalizedName().substring(5));
		}
		@SideOnly(Side.CLIENT)
		public boolean hasEffect(ItemStack par1ItemStack)
		{
		    return true;
		}
	}


