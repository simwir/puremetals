package mods.simwir.puremetals.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.simwir.puremetals.PureMetals;
import mods.simwir.puremetals.gui.GuiGrinder;
import mods.simwir.puremetals.inventory.ContainerGrinder;
import mods.simwir.puremetals.lib.References;
import mods.simwir.puremetals.tileentity.TileEntityGrinder;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.src.ModLoader;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
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
    private static boolean keepGrinderInventory = false;

	protected BlockGrinder(int par1, boolean par2) {
		super(par1, Material.rock);
		setCreativeTab(CreativeTabs.tabDecorations);
		setUnlocalizedName("blockGrinder");
		grinderRand = new Random();
		this.isActive = par2;
	}
	public int idDropped(int par1, Random par2Random, int par3)
    {
        return PureMetals.blockGrinderId;
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
        this.blockIcon = par1IconRegister.registerIcon(References.MOD_ID+":grinder_side");
        this.grinderFront = par1IconRegister.registerIcon(this.isActive ? References.MOD_ID+":grinder_front_lit" : References.MOD_ID+":grinder_front");
        this.grinderTop = par1IconRegister.registerIcon(References.MOD_ID+":grinder_top");
    }
    @Override
    public TileEntity createNewTileEntity(World world){
    	return new TileEntityGrinder();
    }
    
    public void onBlockAdded(World par1World, int par2, int par3, int par4){
    	super.onBlockAdded(par1World, par2, par3, par4);
    	this.setDefaultDirection(par1World, par2, par3, par4);
    	par1World.markBlockForUpdate(par2, par3, par4);
    }
    
    private void setDefaultDirection(World par1World, int par2, int par3, int par4){
    	//TileEntity blockEntity = par1World.getBlockTileEntity(par2, par3, par4);
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
    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLiving par5EntityLiving, ItemStack par6ItemStack)
    {
        int l = MathHelper.floor_double((double)(par5EntityLiving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (l == 0)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);
        }

        if (l == 1)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 5, 2);
        }

        if (l == 2)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);
        }

        if (l == 3)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 4, 2);
        }

        if (par6ItemStack.hasDisplayName())
        {
            ((TileEntityGrinder)par1World.getBlockTileEntity(par2, par3, par4)).func_94129_a(par6ItemStack.getDisplayName());
        }
    }
    public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6){
    	if(!keepGrinderInventory){
    		TileEntityGrinder grinder = (TileEntityGrinder) par1World.getBlockTileEntity(par2, par3, par4);
    		if(grinder != null){
    			for(int i = 0; i < grinder.getSizeInventory(); ++i){
    				ItemStack itemstack = grinder.getStackInSlot(i);
    				if(itemstack != null){
    					float j = this.grinderRand.nextFloat() * 0.8F + 0.1F;
    					float k = this.grinderRand.nextFloat() * 0.8F + 0.1F;
    					float l = this.grinderRand.nextFloat() * 0.8F + 0.1F;
    					
    					while(itemstack.stackSize > 0){
    						int m = this.grinderRand.nextInt(21) + 10;
    						
    						if(m > itemstack.stackSize){
    							m = itemstack.stackSize;
    						}
    						
    						itemstack.stackSize-= m;
    						
    						EntityItem n = new EntityItem(par1World, (double)((float) par2 + j), (double)((float) par3 + k), (double)((float) par4 + l), new ItemStack(itemstack.itemID, m, itemstack.getItemDamage()));
    						
    						if(itemstack.hasTagCompound()){
    							n.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
    						}
    						
    						float o = 0.05F;
    						
    						n.motionX = (double) ((float)this.grinderRand.nextGaussian()*o);
    						n.motionY = (double) ((float)this.grinderRand.nextGaussian()*o);
    						n.motionZ = (double) ((float)this.grinderRand.nextGaussian()*o);
    						
    						par1World.spawnEntityInWorld(n);
    					}
    				}
    			}
    		}
    		
    	}
    	super.breakBlock(par1World, par2, par3, par4, par5, par6);
    }
   
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EPlayer, int par6, float par7, float par8, float par9){
    	TileEntityGrinder grinder =  (TileEntityGrinder) par1World.getBlockTileEntity(par2, par3, par4);
    	
    	if(par5EPlayer instanceof EntityPlayerMP){
    		ModLoader.serverOpenWindow((EntityPlayerMP) par5EPlayer, new ContainerGrinder(par5EPlayer.inventory, grinder),PureMetals.blockGrinderGUIId, par2, par3, par4);
    		
    	}else{
    		ModLoader.openGUI((EntityPlayerSP) par5EPlayer, new GuiGrinder(par5EPlayer.inventory, (TileEntityGrinder) par5EPlayer.worldObj.getBlockTileEntity(par2, par3, par4)));
    		
    	}
    	
    	return true;
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
