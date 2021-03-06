package mods.simwir.puremetals;

import mods.simwir.puremetals.blocks.BlockPureGold;
import mods.simwir.puremetals.blocks.BlockPureIron;
import mods.simwir.puremetals.common.core.handlers.CraftingHandler;
import mods.simwir.puremetals.items.IngotPureGold;
import mods.simwir.puremetals.items.IngotPureIron;
import mods.simwir.puremetals.items.ItemBowlGold;
import mods.simwir.puremetals.items.ItemBowlIron;
import mods.simwir.puremetals.items.ItemBowlMoltenGold;
import mods.simwir.puremetals.items.ItemBowlMoltenIron;
import mods.simwir.puremetals.items.ItemBrickBowl;
import mods.simwir.puremetals.items.ItemGoldDust;
import mods.simwir.puremetals.items.ItemIronDust;
import mods.simwir.puremetals.items.ToolChisel;
import mods.simwir.puremetals.items.ToolPureGoldAxe;
import mods.simwir.puremetals.items.ToolPureGoldPickaxe;
import mods.simwir.puremetals.items.ToolPureGoldShovel;
import mods.simwir.puremetals.items.ToolPureGoldSword;
import mods.simwir.puremetals.items.ToolPureIronAxe;
import mods.simwir.puremetals.items.ToolPureIronPickaxe;
import mods.simwir.puremetals.items.ToolPureIronShovel;
import mods.simwir.puremetals.items.ToolPureIronSword;
import mods.simwir.puremetals.items.ToolStoneHammer;
import mods.simwir.puremetals.lib.BlockReferences;
import mods.simwir.puremetals.lib.ItemReferences;
import mods.simwir.puremetals.lib.References;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
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
	public static int ironDustId;
	public static int goldDustId;
	public static int brickBowlId;
	public static int chiselId;
	public static int bowlIronId;
	public static int bowlGoldId;
	public static int bowlMoltenIronId;
	public static int bowlMoltenGoldId;
	public static int pureIronShovelId;
	public static int pureGoldShovelId;
	public static int pureIronPickaxeId;
	public static int pureGoldPickaxeId;
	public static int stoneHammerId;
	public static int pureIronAxeId;
	public static int pureGoldAxeId;
	public static int pureIronSwordId;
	public static int pureGoldSwordId;
	
	//Defining Blocks
	public static Block blockPureIron;
	public static Block blockPureGold;
	//Defining Items
	public static Item pureIron;
	public static Item pureGold;
	public static Item ironDust;
	public static Item goldDust;
	public static Item brickBowl;
	public static Item chisel;
	public static Item bowlIron;
	public static Item bowlGold;
	public static Item bowlMoltenIron;
	public static Item bowlMoltenGold;
	public static Item pureIronShovel;
	public static Item pureGoldShovel;
	public static Item pureIronPickaxe;
	public static Item pureGoldPickaxe;
	public static Item stoneHammer;
	public static Item pureIronAxe;
	public static Item pureGoldAxe;
	public static Item pureIronSword;
	public static Item pureGoldSword;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());

		config.load();
		//Creating Block IDs in config
		blockPureIronId = config.getBlock(BlockReferences.BLOCK_PURE_IRON_NAME, BlockReferences.BLOCK_PURE_IRON_DEFAULT_ID).getInt();
		blockPureGoldId = config.getBlock(BlockReferences.BLOCK_PURE_GOLD_NAME, BlockReferences.BLOCK_PURE_GOLD_DEFAULT_ID).getInt();
		
		//Creating Item IDs in config
		pureIronId = config.getItem(ItemReferences.PURE_IRON_NAME, ItemReferences.PURE_IRON_DEFAULT_ID).getInt();
		pureGoldId = config.getItem(ItemReferences.PURE_GOLD_NAME, ItemReferences.PURE_GOLD_DEFAULT_ID).getInt();
		ironDustId = config.getItem(ItemReferences.IRON_DUST_NAME, ItemReferences.IRON_DUST_DEFAULT_ID).getInt();
		goldDustId = config.getItem(ItemReferences.GOLD_DUST_NAME, ItemReferences.GOLD_DUST_DEFAULT_ID).getInt();
		brickBowlId = config.getItem(ItemReferences.BRICK_BOWL_NAME, ItemReferences.BRICK_BOWL_DEFAULT_ID).getInt();
		chiselId = config.getItem(ItemReferences.CHISEL_NAME, ItemReferences.CHISEL_DEFAULT_ID).getInt();
		bowlIronId = config.getItem(ItemReferences.BOWL_IRON_NAME, ItemReferences.BOWL_IRON_DEFAULT_ID).getInt();
		bowlGoldId = config.getItem(ItemReferences.BOWL_GOLD_NAME, ItemReferences.BOWL_GOLD_DEFAULT_ID).getInt();
		bowlMoltenIronId = config.getItem(ItemReferences.BOWL_MOLTEN_IRON_NAME, ItemReferences.BOWL_MOLTEN_IRON_DEFAULT_ID).getInt();
		bowlMoltenGoldId = config.getItem(ItemReferences.BOWL_MOLTEN_GOLD_NAME, ItemReferences.BOWL_MOLTEN_GOLD_DEFAULT_ID).getInt();
		pureIronShovelId = config.getItem(ItemReferences.PURE_IRON_SHOVEL_NAME, ItemReferences.PURE_IRON_SHOVEL_DEFAULT_ID).getInt();
		pureGoldShovelId = config.getItem(ItemReferences.PURE_GOLD_SHOVEL_NAME, ItemReferences.PURE_GOLD_SHOVEL_DEFAULT_ID).getInt();
		pureIronPickaxeId = config.getItem(ItemReferences.PURE_IRON_PICKAXE_NAME, ItemReferences.PURE_IRON_PICKAXE_DEFAULT_ID).getInt();
		pureGoldPickaxeId = config.getItem(ItemReferences.PURE_GOLD_PICKAXE_NAME, ItemReferences.PURE_GOLD_PICKACE_DEFAULT_ID).getInt();
		stoneHammerId = config.getItem(ItemReferences.STONE_HAMMER_NAME, ItemReferences.STONE_HAMMER_ID).getInt();
		pureIronAxeId = config.getItem(ItemReferences.PURE_IRON_AXE_NAME, ItemReferences.PURE_IRON_AXE_ID).getInt();
		pureGoldAxeId = config.getItem(ItemReferences.PURE_GOlD_AXE_NAME, ItemReferences.PURE_GOLD_AXE_ID).getInt();
		pureIronSwordId = config.getItem(ItemReferences.PURE_IRON_SWORD_NAME, ItemReferences.PURE_IRON_SWORD_ID).getInt();
		pureGoldSwordId = config.getItem(ItemReferences.PURE_GOLD_SWORD_NAME, ItemReferences.PURE_GOLD_SWORD_ID).getInt();
		
		config.save();
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event){
		//Adding blocks to game
		blockPureIron = new BlockPureIron(blockPureIronId,Material.iron);
		blockPureGold = new BlockPureGold(blockPureGoldId,Material.iron);
		//Adding items to game
		pureIron = new IngotPureIron(pureIronId);
		pureGold = new IngotPureGold(pureGoldId);
		ironDust = new ItemIronDust(ironDustId);
		goldDust = new ItemGoldDust(goldDustId);
		brickBowl = new ItemBrickBowl(brickBowlId);
		bowlIron = new ItemBowlIron(bowlIronId);
		bowlGold = new ItemBowlGold(bowlGoldId);
		bowlMoltenIron = new ItemBowlMoltenIron(bowlMoltenIronId);
		bowlMoltenGold = new ItemBowlMoltenGold(bowlMoltenGoldId);
		//Adding Tools to game
		chisel = new ToolChisel(chiselId);
		pureIronShovel = new ToolPureIronShovel(pureIronShovelId, EnumToolMaterial.EMERALD, 2);
		pureGoldShovel = new ToolPureGoldShovel(pureGoldShovelId, EnumToolMaterial.GOLD, 2);
		pureIronPickaxe = new ToolPureIronPickaxe(pureIronPickaxeId, EnumToolMaterial.EMERALD, 2);
		pureGoldPickaxe = new ToolPureGoldPickaxe(pureGoldPickaxeId, EnumToolMaterial.GOLD, 2);
		stoneHammer = new ToolStoneHammer(stoneHammerId);
		pureIronAxe = new ToolPureIronAxe(pureIronAxeId, EnumToolMaterial.EMERALD);
		pureGoldAxe = new ToolPureGoldAxe(pureGoldAxeId, EnumToolMaterial.GOLD);
		pureIronSword = new ToolPureIronSword(pureIronSwordId, EnumToolMaterial.EMERALD);
		pureGoldSword = new ToolPureGoldSword(pureGoldSwordId, EnumToolMaterial.GOLD);
		
		GameRegistry.registerCraftingHandler(new CraftingHandler());
		
		//Registering blocks to game
		gameRegisters();
		//Adding block and item names to game
		languageRegisters();
		//Adding recipes
		Recipies.recipies();
		
		proxy.registerRenders();
	}
	
	@EventHandler
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
		LanguageRegistry.addName(ironDust, ItemReferences.IRON_DUST_NAME);
		LanguageRegistry.addName(goldDust, ItemReferences.GOLD_DUST_NAME);
		LanguageRegistry.addName(brickBowl, ItemReferences.BRICK_BOWL_NAME);
		LanguageRegistry.addName(chisel, ItemReferences.CHISEL_NAME);
		LanguageRegistry.addName(bowlIron, ItemReferences.BOWL_IRON_NAME);
		LanguageRegistry.addName(bowlGold, ItemReferences.BOWL_GOLD_NAME);
		LanguageRegistry.addName(bowlMoltenIron, ItemReferences.BOWL_MOLTEN_IRON_NAME);
		LanguageRegistry.addName(bowlMoltenGold, ItemReferences.BOWL_MOLTEN_GOLD_NAME);
		LanguageRegistry.addName(pureIronShovel, ItemReferences.PURE_IRON_SHOVEL_NAME);
		LanguageRegistry.addName(pureGoldShovel, ItemReferences.PURE_GOLD_SHOVEL_NAME);
		LanguageRegistry.addName(pureIronPickaxe, ItemReferences.PURE_IRON_PICKAXE_NAME);
		LanguageRegistry.addName(pureGoldPickaxe, ItemReferences.PURE_GOLD_PICKAXE_NAME);
		LanguageRegistry.addName(stoneHammer, ItemReferences.STONE_HAMMER_NAME);
		LanguageRegistry.addName(pureIronAxe, ItemReferences.PURE_IRON_AXE_NAME);
		LanguageRegistry.addName(pureGoldAxe, ItemReferences.PURE_GOlD_AXE_NAME);
		LanguageRegistry.addName(pureIronSword, ItemReferences.PURE_IRON_SWORD_NAME);
		LanguageRegistry.addName(pureGoldSword, ItemReferences.PURE_GOLD_SWORD_NAME);
	}
}
