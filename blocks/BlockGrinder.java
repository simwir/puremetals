package mods.simwir.puremetals.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.simwir.puremetals.tileentity.TileEntityGrinder;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.src.ModLoader;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockGrinder extends BlockContainer{
	
	@SideOnly(Side.CLIENT)
	private Icon grinderFront;
	@SideOnly(Side.CLIENT)
	private Icon grinderTop;
	private Random grinderRand;
	/** True if this is an active furnace, false if idle */
    private final boolean isActive;

	protected BlockGrinder(int par1, boolean par2) {
		super(par1, Material.rock);
		setCreativeTab(CreativeTabs.tabDecorations);
		setUnlocalizedName("blockGrinder");
		grinderRand = new Random();
		this.isActive = par2;
	}
	
	/**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public Icon getIcon(int par1, int par2)
    {
        return par1 == 1 ? this.grinderTop : (par1 == 0 ? this.grinderTop : (par1 != par2 ? this.blockIcon : this.grinderFront));
    }
    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("simwir/puremetals:grinder_side");
        this.grinderFront = par1IconRegister.registerIcon(this.isActive ? "grinder_front_lit" : "grinder_front");
        this.grinderTop = par1IconRegister.registerIcon("simwir/puremetals:grinder_top");
    }
    @Override
    public TileEntity createNewTileEntity(World world){
    	return new TileEntityGrinder();
    }
    
    public void onBlockAdded(World par1World, int par2, int par3, int par4){
    	super.onBlockAdded(par1World, par2, par3, par4);
    	
    	par1World.markBlockForUpdate(par2, par3, par4);
    }
    
    private void setDefaultDirection(World par1World, int par2, int par3, int par4){
    	TileEntity blockEntity = par1World.getBlockTileEntity(par2, par3, par4);
    	if(par1World.isRemote){
    		return;
    	}
    	int i = par1World.getBlockId(par2, par3, par4 - 1);
    	int j = par1World.getBlockId(par2, par3, par4 + 1);
    	int k = par1World.getBlockId(par2 - 1, par3, par4);
    	int l = par1World.getBlockId(par2 + 1, par3, par4);
    	
    	byte byte0 = 3;
    	
    	if (Block.opaqueCubeLookup[i] && !Block.opaqueCubeLookup[j])
        {
            byte0 = 3;
        }

        if (Block.opaqueCubeLookup[j] && !Block.opaqueCubeLookup[i])
        {
            byte0 = 2;
        }

        if (Block.opaqueCubeLookup[k] && !Block.opaqueCubeLookup[l])
        {
            byte0 = 5;
        }

        if (Block.opaqueCubeLookup[l] && !Block.opaqueCubeLookup[k])
        {
            byte0 = 4;
        }
        
        //((TileEntityGrinder) blockEntity).setFrontDirection(byte0);
        par1World.setBlockMetadataWithNotify(par2, par3, par4, byte0, 2);
    }
    /**
    public int getBlockTexture(IBlockAccess par1IBA, int par2, int par3, int par4, int par5){
    	int front = 0;
    	
    	TileEntity tile = ModLoader.getMinecraftInstance().getIntegratedServer().worldServers[0].getBlockTileEntity(par2, par3, par4);
    	if (tile != null){
    		front = ((TileEntityGrinder) tile).getFrontDirection();
    	}else{
    		ModLoader.getMinecraftInstance().getIntegratedServer().worldServers[0].markBlockForUpdate(par2, par3, par4);
    	}
    	
    	switch(par5)
    	
    }*/

}
