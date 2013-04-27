package mods.simwir.puremetals.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.simwir.puremetals.lib.ToolReferences;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

public class ToolPureIronShovel extends ItemTool{
	public ToolPureIronShovel(int par1, EnumToolMaterial mat, int par4) {//par4 damage to mobs and entities
		super(par1, par4, mat, ToolReferences.SHOVEL_EFFEKTIVE_AGAINST);
		
		setUnlocalizedName("pureIronShovel");
		setMaxDamage(250);
	}
	
	public boolean canHarvestBlock(Block block){
		return block.blockMaterial == Material.snow;
	}
	
	public float getStrVsBlock(ItemStack itemStack, Block block){
		return block.blockMaterial != null && block.blockMaterial == Material.grass ? this.efficiencyOnProperMaterial : (block.blockMaterial == Material.sand ? this.efficiencyOnProperMaterial : super.getStrVsBlock(itemStack, block));
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
