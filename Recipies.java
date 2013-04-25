package mods.simwir.puremetals;

import mods.simwir.puremetals.common.core.handlers.CraftingHandler;
import mods.simwir.puremetals.lib.ItemReferences;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipies {
	
	public static final int WILDCARD_VALUE=Short.MAX_VALUE;
	
	public Recipies(){
	}

	public static void recipies() {
		//Adding Pure Iron Block Recipe
		ItemStack pureIronStack = new ItemStack (PureMetals.pureIron);
		GameRegistry.addShapelessRecipe(new ItemStack(PureMetals.blockPureIron),
		pureIronStack, pureIronStack, pureIronStack,
		pureIronStack, pureIronStack, pureIronStack,
		pureIronStack, pureIronStack, pureIronStack);
		
		//Adding Pure Gold Block Recipe
		ItemStack pureGoldStack = new ItemStack (PureMetals.pureGold);
		GameRegistry.addShapelessRecipe(new ItemStack(PureMetals.blockPureGold),
		pureGoldStack, pureGoldStack, pureGoldStack,
		pureGoldStack, pureGoldStack, pureGoldStack,
		pureGoldStack, pureGoldStack, pureGoldStack);
		
		//Adding Pure Iron Block to Pure Iron Recipe
		GameRegistry.addShapelessRecipe(new ItemStack(PureMetals.pureIron, 9), new ItemStack(PureMetals.blockPureIron));
		
		//Adding Pure Gold Block to Pure Gold Recipe
		GameRegistry.addShapelessRecipe(new ItemStack(PureMetals.pureGold, 9), new ItemStack(PureMetals.blockPureGold));
		
		//Adding Iron Dust Recipe
		GameRegistry.addShapelessRecipe(new ItemStack(PureMetals.ironDust),
		new ItemStack(Block.cobblestone), new ItemStack(Item.ingotIron));
		
		//Adding Gold Dust Recipe
		GameRegistry.addShapelessRecipe(new ItemStack(PureMetals.goldDust),
		new ItemStack(Block.cobblestone), new ItemStack(Item.ingotGold));
		
		//Adding Chisel Recipe
		GameRegistry.addShapedRecipe(new ItemStack(PureMetals.chisel), " x", "y ",
				'x', new ItemStack(Block.stone), 'y', new ItemStack(Item.stick) );
		
		//Adding Brick Bowl Recipe
		GameRegistry.addShapelessRecipe(new ItemStack(PureMetals.brickBowl), 
		new ItemStack(PureMetals.chisel,1, WILDCARD_VALUE), new ItemStack(Item.brick));
		
		//Adding Bowl of Crushed Iron Recipe
		GameRegistry.addShapelessRecipe(new ItemStack(PureMetals.bowlIron), 
		new ItemStack(PureMetals.brickBowl), new ItemStack(PureMetals.ironDust));
		
		//Adding Bowl of Crushed Gold Recipe
		GameRegistry.addShapelessRecipe(new ItemStack(PureMetals.bowlGold), 
		new ItemStack(PureMetals.brickBowl), new ItemStack(PureMetals.goldDust));
		
		//Adding Bowl of Molten Iron Smelting Recipe
		GameRegistry.addSmelting(PureMetals.bowlIron.itemID, new ItemStack(PureMetals.bowlMoltenIron), 0.1F);
		
		//Adding Bowl of Molten Gold Smelting Recipe
		GameRegistry.addSmelting(PureMetals.bowlGold.itemID, new ItemStack(PureMetals.bowlMoltenGold), 0.1F);
		
		//Adding Pure Iron Recipe
		GameRegistry.addShapelessRecipe(pureIronStack, 
		new ItemStack(PureMetals.chisel,1, WILDCARD_VALUE), new ItemStack(PureMetals.bowlMoltenIron));
		
		//Adding Pure Gold Recipe
		GameRegistry.addShapelessRecipe(pureGoldStack, 
		new ItemStack(PureMetals.chisel,1, WILDCARD_VALUE), new ItemStack(PureMetals.bowlMoltenGold));
	}
}
