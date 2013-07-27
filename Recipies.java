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
		//Adding ItemStacks
		ItemStack pureIronStack = new ItemStack(PureMetals.pureIron);
		ItemStack pureGoldStack = new ItemStack(PureMetals.pureGold);
		ItemStack stickStack = new ItemStack(Item.stick);
		
		//Adding Pure Iron Block Recipe
		GameRegistry.addShapelessRecipe(new ItemStack(PureMetals.blockPureIron),
		pureIronStack, pureIronStack, pureIronStack,
		pureIronStack, pureIronStack, pureIronStack,
		pureIronStack, pureIronStack, pureIronStack);
		
		//Adding Pure Gold Block Recipe
		GameRegistry.addShapelessRecipe(new ItemStack(PureMetals.blockPureGold),
		pureGoldStack, pureGoldStack, pureGoldStack,
		pureGoldStack, pureGoldStack, pureGoldStack,
		pureGoldStack, pureGoldStack, pureGoldStack);
		
		//Pure Iron Block to Pure Iron Recipe
		GameRegistry.addShapelessRecipe(new ItemStack(PureMetals.pureIron, 9), new ItemStack(PureMetals.blockPureIron));
		
		//Pure Gold Block to Pure Gold Recipe
		GameRegistry.addShapelessRecipe(new ItemStack(PureMetals.pureGold, 9), new ItemStack(PureMetals.blockPureGold));
		
		//Iron Dust Recipe
		GameRegistry.addShapelessRecipe(new ItemStack(PureMetals.ironDust),
		new ItemStack(PureMetals.stoneHammer,1, WILDCARD_VALUE), new ItemStack(Item.ingotIron));
		
		//Gold Dust Recipe
		GameRegistry.addShapelessRecipe(new ItemStack(PureMetals.goldDust),
		new ItemStack(PureMetals.stoneHammer,1, WILDCARD_VALUE), new ItemStack(Item.ingotGold));
		
		//Chisel Recipe
		GameRegistry.addShapedRecipe(new ItemStack(PureMetals.chisel), " x", "y ",
				'x', new ItemStack(Block.stone), 'y', new ItemStack(Item.stick) );
		
		//Brick Bowl Recipe
		GameRegistry.addShapelessRecipe(new ItemStack(PureMetals.brickBowl), 
		new ItemStack(PureMetals.chisel,1, WILDCARD_VALUE), new ItemStack(Item.brick));
		
		//Bowl of Crushed Iron Recipe
		GameRegistry.addShapelessRecipe(new ItemStack(PureMetals.bowlIron), 
		new ItemStack(PureMetals.brickBowl), new ItemStack(PureMetals.ironDust));
		
		//Bowl of Crushed Gold Recipe
		GameRegistry.addShapelessRecipe(new ItemStack(PureMetals.bowlGold), 
		new ItemStack(PureMetals.brickBowl), new ItemStack(PureMetals.goldDust));
		
		//Bowl of Molten Iron Smelting Recipe
		GameRegistry.addSmelting(PureMetals.bowlIron.itemID, new ItemStack(PureMetals.bowlMoltenIron), 0.1F);
		
		//Bowl of Molten Gold Smelting Recipe
		GameRegistry.addSmelting(PureMetals.bowlGold.itemID, new ItemStack(PureMetals.bowlMoltenGold), 0.1F);
		
		//Pure Iron Recipe
		GameRegistry.addShapelessRecipe(pureIronStack, 
		new ItemStack(PureMetals.chisel,1, WILDCARD_VALUE), new ItemStack(PureMetals.bowlMoltenIron));
		
		//Pure Gold Recipe
		GameRegistry.addShapelessRecipe(pureGoldStack, 
		new ItemStack(PureMetals.chisel,1, WILDCARD_VALUE), new ItemStack(PureMetals.bowlMoltenGold));
		
		//Pure Iron Shovel Recipe
		GameRegistry.addShapedRecipe(new ItemStack(PureMetals.pureIronShovel), " x ", " y ", " y ",
				'x', pureIronStack, 'y', stickStack);
		
		//Pure Gold Shovel Recipe
		GameRegistry.addShapedRecipe(new ItemStack(PureMetals.pureGoldShovel), " x ", " y ", " y ",
				'x', pureGoldStack, 'y', stickStack);
		
		//Pure Iron Pickaxe Recipe
		GameRegistry.addShapedRecipe(new ItemStack(PureMetals.pureIronPickaxe), "xxx", " y ", " y ",
				'x', pureIronStack, 'y', stickStack);
		
		//Pure Gold Pickaxe Recipe
				GameRegistry.addShapedRecipe(new ItemStack(PureMetals.pureGoldPickaxe), "xxx", " y ", " y ",
						'x', pureGoldStack, 'y', stickStack);
		//Stone Hammer Recipe
				GameRegistry.addShapedRecipe(new ItemStack(PureMetals.stoneHammer), "xxx", "xyx", " y ",
						'x', new ItemStack(Block.cobblestone), 'y', stickStack);
		//Pure Iron Axe Recipe
				GameRegistry.addShapedRecipe(new ItemStack(PureMetals.pureIronAxe), "xx ", "xy ", " y ",
						'x', pureIronStack, 'y', stickStack);
		//Pure Gold Axe Recipe
				GameRegistry.addShapedRecipe(new ItemStack(PureMetals.pureGoldAxe), "xx ", "xy ", " y ",
						'x', pureGoldStack, 'y', stickStack);
		//Pure Iron Axe Reversed Recipe
				GameRegistry.addShapedRecipe(new ItemStack(PureMetals.pureIronAxe), " xx", " yx", " y ",
						'x', pureIronStack, 'y', stickStack);
		//Pure Gold Axe Reversed Recipe
				GameRegistry.addShapedRecipe(new ItemStack(PureMetals.pureGoldAxe), " xx", " yx", " y ",
						'x', pureGoldStack, 'y', stickStack);
		//Pure Iron Sword Recipe
				GameRegistry.addShapedRecipe(new ItemStack(PureMetals.pureIronSword), " x ", " x ", " y ",
						'x', pureIronStack, 'y', stickStack);
		//Pure Gold Sword Recipe
				GameRegistry.addShapedRecipe(new ItemStack(PureMetals.pureGoldSword), " x ", " x ", " y ",
						'x', pureGoldStack, 'y', stickStack);
	}
}
