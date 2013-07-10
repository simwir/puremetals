package mods.simwir.puremetals.blocks;

import java.lang.ref.Reference;

import mods.simwir.puremetals.lib.References;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class BlockPureIron extends Block{

	public BlockPureIron(int id, Material Material) {
		super(id, Material);
		
		setUnlocalizedName("blockPureIron");
		setCreativeTab(CreativeTabs.tabBlock);
		setLightValue(0.8F);
		setResistance(10.0F);
		setHardness(5.0F);
	}
	@Override
	public void registerIcons(IconRegister iconRegister){
        this.blockIcon = iconRegister.registerIcon(References.MOD_ID+":"+this.getUnlocalizedName().substring(5));
	}
}
