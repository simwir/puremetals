package mods.simwir.puremetals.items;

import mods.simwir.puremetals.lib.ToolReferences;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;

public class ToolPureIronPickaxe extends ToolPureIronShovel{

	public ToolPureIronPickaxe(int par1, EnumToolMaterial mat, int par4) {
		super(par1, mat, par4);
		setUnlocalizedName("pureIronPickaxe");
	}
	public boolean canHarvestBlock(Block block){
		return block.blockMaterial == Material.rock;
	}
	public float getStrVsBlock(ItemStack itemStack, Block block){
		return block.blockMaterial != null && block.blockMaterial == Material.rock ? this.efficiencyOnProperMaterial : super.getStrVsBlock(itemStack, block);
	}

}
