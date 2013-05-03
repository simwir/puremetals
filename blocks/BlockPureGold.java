package mods.simwir.puremetals.blocks;

import net.minecraft.block.material.Material;

public class BlockPureGold extends BlockPureIron{

	public BlockPureGold(int id, Material Material) {
		super(id, Material);
		
		setUnlocalizedName("blockPureGold");
		setHardness(3.0F);
		setLightValue(1.0F);
	}

}
