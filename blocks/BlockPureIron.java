package mods.simwir.puremetals.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class BlockPureIron extends Block{

	public BlockPureIron(int id, Material Material) {
		super(id, Material);
		
		setUnlocalizedName("blockPureIron");
		setCreativeTab(CreativeTabs.tabBlock);
		setLightValue(1.0F);
		setResistance(50);
		setHardness(5.0F);
	}
	@Override
	public void registerIcons(IconRegister iconRegister){
        this.blockIcon = iconRegister.registerIcon("simwir/puremetals:"+this.getUnlocalizedName().substring(5));
	}
}
