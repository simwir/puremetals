package mods.simwir.puremetals;

import mods.simwir.puremetals.blocks.BlockPureGold;
import mods.simwir.puremetals.blocks.BlockPureIron;
import mods.simwir.puremetals.items.IngotPureGold;
import mods.simwir.puremetals.items.IngotPureIron;
import mods.simwir.puremetals.lib.BlockReferences;
import mods.simwir.puremetals.lib.ItemReferences;
import mods.simwir.puremetals.lib.References;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid=References.MOD_ID, name=References.MOD_NAME, version=References.MOD_VERSION)
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class PureMetals {
	
	@Instance(References.MOD_ID)
	public static PureMetals instance;
	
	@SidedProxy(clientSide="mods.simwir.puremetals.client.ClientProxy", serverSide="mods.simwir.puremetals.CommonProxy" )
	public static CommonProxy proxy;
	
	//Defining Block ID int
	public static int blockPureIronId;
	public static int blockPureGoldId;
	//Defining Item ID int
	public static int pureIronId;
	public static int pureGoldId;
	//Defining Blocks
	public static Block blockPureIron;
	public static Block blockPureGold;
	//Defining Items
	public static Item pureIron;
	public static Item pureGold;
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event){
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());

		config.load();
		//Creating Block IDs in config
		blockPureIronId = config.getBlock(BlockReferences.BLOCK_PURE_IRON_NAME, BlockReferences.BLOCK_PURE_IRON_DEFAULT_ID).getInt();
		blockPureGoldId = config.getBlock(BlockReferences.BLOCK_PURE_GOLD_NAME, BlockReferences.BLOCK_PURE_GOLD_DEFAULT_ID).getInt();
		
		//Creating Item IDs in config
		pureIronId = config.getItem(ItemReferences.PURE_IRON_NAME, ItemReferences.PURE_IRON_DEFAULT_ID).getInt();
		pureGoldId = config.getItem(ItemReferences.PURE_GOLD_NAME, ItemReferences.PURE_GOLD_DEFAULT_ID).getInt();
		
		config.save();
	}
	
	@Init
	public void load(FMLInitializationEvent event){
		//Adding blocks to game
		blockPureIron = new BlockPureIron(blockPureIronId,Material.iron);
		blockPureGold = new BlockPureGold(blockPureGoldId,Material.iron);
		//Adding items to game
		pureIron = new IngotPureIron(pureIronId);
		pureGold = new IngotPureGold(pureGoldId);
		//Registering blocks to game
		gameRegisters();
		//Adding block and item names to game
		languageRegisters();
		//Adding recipes
		Recipies.recipies();
		
		proxy.registerRenders();
	}
	
	@PostInit
	public void postInit(FMLPostInitializationEvent event){
		//Stub Method
	}
	private static void gameRegisters(){
		//Registering blocks to game
		GameRegistry.registerBlock(blockPureIron, "blockPureIron");
		GameRegistry.registerBlock(blockPureGold, "blockPureGold");
	}
	private static void languageRegisters(){
		//Adding block names to game
		LanguageRegistry.addName(blockPureIron, BlockReferences.BLOCK_PURE_IRON_NAME);
		LanguageRegistry.addName(blockPureGold, BlockReferences.BLOCK_PURE_GOLD_NAME);
		//Adding item names to game
		LanguageRegistry.addName(pureIron, ItemReferences.PURE_IRON_NAME);
		LanguageRegistry.addName(pureGold, ItemReferences.PURE_GOLD_NAME);
	}
}
