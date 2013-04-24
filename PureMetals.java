package mods.simwir.puremetals;

import mods.simwir.puremetals.items.PureGold;
import mods.simwir.puremetals.items.PureIron;
import mods.simwir.puremetals.lib.ItemReferences;
import mods.simwir.puremetals.lib.References;
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
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid=References.MOD_ID, name=References.MOD_NAME, version=References.MOD_VERSION)
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class PureMetals {
	
	@Instance(References.MOD_ID)
	public static PureMetals instance;
	
	@SidedProxy(clientSide="mods.simwir.puremetals.client.ClientProxy", serverSide="mods.simwir.puremetals.CommonProxy" )
	public static CommonProxy proxy;
	
	public static int pureIronId;
	public static int pureGoldId;
	
	public static Item pureIron;
	public static Item pureGold;
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event){
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());

		config.load();

		pureIronId = config.getItem(ItemReferences.PURE_IRON_NAME, ItemReferences.PURE_IRON_DEFAULT_ID).getInt();
		pureGoldId = config.getItem(ItemReferences.PURE_GOLD_NAME, ItemReferences.PURE_GOLD_DEFAULT_ID).getInt();
		
		config.save();
	}
	
	@Init
	public void load(FMLInitializationEvent event){
		pureIron = new PureIron(pureIronId);
		pureGold = new PureGold(pureGoldId);
		LanguageRegistry.addName(pureIron, ItemReferences.PURE_IRON_NAME);
		LanguageRegistry.addName(pureGold, ItemReferences.PURE_GOLD_NAME);
		
		proxy.registerRenders();
	}
	
	@PostInit
	public void postInit(FMLPostInitializationEvent event){
		//Stub Method
	}
}
