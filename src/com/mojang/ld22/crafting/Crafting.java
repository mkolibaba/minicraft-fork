package com.mojang.ld22.crafting;

import java.util.ArrayList;
import java.util.List;

import com.mojang.ld22.entity.Anvil;
import com.mojang.ld22.entity.Chest;
import com.mojang.ld22.entity.Furnace;
import com.mojang.ld22.entity.Oven;
import com.mojang.ld22.entity.Lantern;
import com.mojang.ld22.entity.Workbench;
import com.mojang.ld22.item.ToolType;
import com.mojang.ld22.item.resource.Resource;

public class Crafting {
	public static final List<Recipe> anvilRecipes = new ArrayList<>();
	public static final List<Recipe> ovenRecipes = new ArrayList<>();
	public static final List<Recipe> furnaceRecipes = new ArrayList<>();
	public static final List<Recipe> workbenchRecipes = new ArrayList<>();

	static {
		try {
			workbenchRecipes.add(new FurnitureRecipe(Lantern.class).addCost(Resource.WOOD, 5).addCost(Resource.SLIME, 10).addCost(Resource.GLASS, 4));

			workbenchRecipes.add(new FurnitureRecipe(Oven.class).addCost(Resource.STONE, 15));
			workbenchRecipes.add(new FurnitureRecipe(Furnace.class).addCost(Resource.STONE, 20));
			workbenchRecipes.add(new FurnitureRecipe(Workbench.class).addCost(Resource.WOOD, 20));
			workbenchRecipes.add(new FurnitureRecipe(Chest.class).addCost(Resource.WOOD, 20));
			workbenchRecipes.add(new FurnitureRecipe(Anvil.class).addCost(Resource.IRON_INGOT, 5));

			workbenchRecipes.add(new ToolRecipe(ToolType.sword, 0).addCost(Resource.WOOD, 5));
			workbenchRecipes.add(new ToolRecipe(ToolType.axe, 0).addCost(Resource.WOOD, 5));
			workbenchRecipes.add(new ToolRecipe(ToolType.hoe, 0).addCost(Resource.WOOD, 5));
			workbenchRecipes.add(new ToolRecipe(ToolType.pickaxe, 0).addCost(Resource.WOOD, 5));
			workbenchRecipes.add(new ToolRecipe(ToolType.shovel, 0).addCost(Resource.WOOD, 5));
			workbenchRecipes.add(new ToolRecipe(ToolType.sword, 1).addCost(Resource.WOOD, 5).addCost(Resource.STONE, 5));
			workbenchRecipes.add(new ToolRecipe(ToolType.axe, 1).addCost(Resource.WOOD, 5).addCost(Resource.STONE, 5));
			workbenchRecipes.add(new ToolRecipe(ToolType.hoe, 1).addCost(Resource.WOOD, 5).addCost(Resource.STONE, 5));
			workbenchRecipes.add(new ToolRecipe(ToolType.pickaxe, 1).addCost(Resource.WOOD, 5).addCost(Resource.STONE, 5));
			workbenchRecipes.add(new ToolRecipe(ToolType.shovel, 1).addCost(Resource.WOOD, 5).addCost(Resource.STONE, 5));

			anvilRecipes.add(new ToolRecipe(ToolType.sword, 2).addCost(Resource.WOOD, 5).addCost(Resource.IRON_INGOT, 5));
			anvilRecipes.add(new ToolRecipe(ToolType.axe, 2).addCost(Resource.WOOD, 5).addCost(Resource.IRON_INGOT, 5));
			anvilRecipes.add(new ToolRecipe(ToolType.hoe, 2).addCost(Resource.WOOD, 5).addCost(Resource.IRON_INGOT, 5));
			anvilRecipes.add(new ToolRecipe(ToolType.pickaxe, 2).addCost(Resource.WOOD, 5).addCost(Resource.IRON_INGOT, 5));
			anvilRecipes.add(new ToolRecipe(ToolType.shovel, 2).addCost(Resource.WOOD, 5).addCost(Resource.IRON_INGOT, 5));

			anvilRecipes.add(new ToolRecipe(ToolType.sword, 3).addCost(Resource.WOOD, 5).addCost(Resource.GOLD_INGOT, 5));
			anvilRecipes.add(new ToolRecipe(ToolType.axe, 3).addCost(Resource.WOOD, 5).addCost(Resource.GOLD_INGOT, 5));
			anvilRecipes.add(new ToolRecipe(ToolType.hoe, 3).addCost(Resource.WOOD, 5).addCost(Resource.GOLD_INGOT, 5));
			anvilRecipes.add(new ToolRecipe(ToolType.pickaxe, 3).addCost(Resource.WOOD, 5).addCost(Resource.GOLD_INGOT, 5));
			anvilRecipes.add(new ToolRecipe(ToolType.shovel, 3).addCost(Resource.WOOD, 5).addCost(Resource.GOLD_INGOT, 5));

			anvilRecipes.add(new ToolRecipe(ToolType.sword, 4).addCost(Resource.WOOD, 5).addCost(Resource.GEM, 50));
			anvilRecipes.add(new ToolRecipe(ToolType.axe, 4).addCost(Resource.WOOD, 5).addCost(Resource.GEM, 50));
			anvilRecipes.add(new ToolRecipe(ToolType.hoe, 4).addCost(Resource.WOOD, 5).addCost(Resource.GEM, 50));
			anvilRecipes.add(new ToolRecipe(ToolType.pickaxe, 4).addCost(Resource.WOOD, 5).addCost(Resource.GEM, 50));
			anvilRecipes.add(new ToolRecipe(ToolType.shovel, 4).addCost(Resource.WOOD, 5).addCost(Resource.GEM, 50));

			furnaceRecipes.add(new ResourceRecipe(Resource.IRON_INGOT).addCost(Resource.IRON_ORE, 4).addCost(Resource.COAL, 1));
			furnaceRecipes.add(new ResourceRecipe(Resource.GOLD_INGOT).addCost(Resource.GOLD_ORE, 4).addCost(Resource.COAL, 1));
			furnaceRecipes.add(new ResourceRecipe(Resource.GLASS).addCost(Resource.SAND, 4).addCost(Resource.COAL, 1));

			ovenRecipes.add(new ResourceRecipe(Resource.BREAD).addCost(Resource.WHEAT, 4));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}