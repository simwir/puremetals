package mods.simwir.puremetals;

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
	}
}
