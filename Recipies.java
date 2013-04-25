package mods.simwir.puremetals;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipies {
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
		new ItemStack(PureMetals.chisel,1,1), new ItemStack(Item.brick));
	}
}
