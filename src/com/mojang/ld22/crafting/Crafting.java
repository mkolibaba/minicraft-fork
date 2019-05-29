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
    public static final List<Recipe> ANVIL_RECIPES = new ArrayList<>();
    public static final List<Recipe> OVEN_RECIPES = new ArrayList<>();
    public static final List<Recipe> FURNACE_RECIPES = new ArrayList<>();
    public static final List<Recipe> WORKBENCH_RECIPES = new ArrayList<>();

    static {
        try {
            WORKBENCH_RECIPES.add(new FurnitureRecipe(Lantern.class).addCost(Resource.WOOD, 5).addCost(Resource.SLIME, 10).addCost(Resource.GLASS, 4));

            WORKBENCH_RECIPES.add(new FurnitureRecipe(Oven.class).addCost(Resource.STONE, 15));
            WORKBENCH_RECIPES.add(new FurnitureRecipe(Furnace.class).addCost(Resource.STONE, 20));
            WORKBENCH_RECIPES.add(new FurnitureRecipe(Workbench.class).addCost(Resource.WOOD, 20));
            WORKBENCH_RECIPES.add(new FurnitureRecipe(Chest.class).addCost(Resource.WOOD, 20));
            WORKBENCH_RECIPES.add(new FurnitureRecipe(Anvil.class).addCost(Resource.IRON_INGOT, 5));

            WORKBENCH_RECIPES.add(new ToolRecipe(ToolType.SWORD, 0).addCost(Resource.WOOD, 5));
            WORKBENCH_RECIPES.add(new ToolRecipe(ToolType.AXE, 0).addCost(Resource.WOOD, 5));
            WORKBENCH_RECIPES.add(new ToolRecipe(ToolType.HOE, 0).addCost(Resource.WOOD, 5));
            WORKBENCH_RECIPES.add(new ToolRecipe(ToolType.PICKAXE, 0).addCost(Resource.WOOD, 5));
            WORKBENCH_RECIPES.add(new ToolRecipe(ToolType.SHOVEL, 0).addCost(Resource.WOOD, 5));
            WORKBENCH_RECIPES.add(new ToolRecipe(ToolType.SWORD, 1).addCost(Resource.WOOD, 5).addCost(Resource.STONE, 5));
            WORKBENCH_RECIPES.add(new ToolRecipe(ToolType.AXE, 1).addCost(Resource.WOOD, 5).addCost(Resource.STONE, 5));
            WORKBENCH_RECIPES.add(new ToolRecipe(ToolType.HOE, 1).addCost(Resource.WOOD, 5).addCost(Resource.STONE, 5));
            WORKBENCH_RECIPES.add(new ToolRecipe(ToolType.PICKAXE, 1).addCost(Resource.WOOD, 5).addCost(Resource.STONE, 5));
            WORKBENCH_RECIPES.add(new ToolRecipe(ToolType.SHOVEL, 1).addCost(Resource.WOOD, 5).addCost(Resource.STONE, 5));

            ANVIL_RECIPES.add(new ToolRecipe(ToolType.SWORD, 2).addCost(Resource.WOOD, 5).addCost(Resource.IRON_INGOT, 5));
            ANVIL_RECIPES.add(new ToolRecipe(ToolType.AXE, 2).addCost(Resource.WOOD, 5).addCost(Resource.IRON_INGOT, 5));
            ANVIL_RECIPES.add(new ToolRecipe(ToolType.HOE, 2).addCost(Resource.WOOD, 5).addCost(Resource.IRON_INGOT, 5));
            ANVIL_RECIPES.add(new ToolRecipe(ToolType.PICKAXE, 2).addCost(Resource.WOOD, 5).addCost(Resource.IRON_INGOT, 5));
            ANVIL_RECIPES.add(new ToolRecipe(ToolType.SHOVEL, 2).addCost(Resource.WOOD, 5).addCost(Resource.IRON_INGOT, 5));

            ANVIL_RECIPES.add(new ToolRecipe(ToolType.SWORD, 3).addCost(Resource.WOOD, 5).addCost(Resource.GOLD_INGOT, 5));
            ANVIL_RECIPES.add(new ToolRecipe(ToolType.AXE, 3).addCost(Resource.WOOD, 5).addCost(Resource.GOLD_INGOT, 5));
            ANVIL_RECIPES.add(new ToolRecipe(ToolType.HOE, 3).addCost(Resource.WOOD, 5).addCost(Resource.GOLD_INGOT, 5));
            ANVIL_RECIPES.add(new ToolRecipe(ToolType.PICKAXE, 3).addCost(Resource.WOOD, 5).addCost(Resource.GOLD_INGOT, 5));
            ANVIL_RECIPES.add(new ToolRecipe(ToolType.SHOVEL, 3).addCost(Resource.WOOD, 5).addCost(Resource.GOLD_INGOT, 5));

            ANVIL_RECIPES.add(new ToolRecipe(ToolType.SWORD, 4).addCost(Resource.WOOD, 5).addCost(Resource.GEM, 50));
            ANVIL_RECIPES.add(new ToolRecipe(ToolType.AXE, 4).addCost(Resource.WOOD, 5).addCost(Resource.GEM, 50));
            ANVIL_RECIPES.add(new ToolRecipe(ToolType.HOE, 4).addCost(Resource.WOOD, 5).addCost(Resource.GEM, 50));
            ANVIL_RECIPES.add(new ToolRecipe(ToolType.PICKAXE, 4).addCost(Resource.WOOD, 5).addCost(Resource.GEM, 50));
            ANVIL_RECIPES.add(new ToolRecipe(ToolType.SHOVEL, 4).addCost(Resource.WOOD, 5).addCost(Resource.GEM, 50));

            FURNACE_RECIPES.add(new ResourceRecipe(Resource.IRON_INGOT).addCost(Resource.IRON_ORE, 4).addCost(Resource.COAL, 1));
            FURNACE_RECIPES.add(new ResourceRecipe(Resource.GOLD_INGOT).addCost(Resource.GOLD_ORE, 4).addCost(Resource.COAL, 1));
            FURNACE_RECIPES.add(new ResourceRecipe(Resource.GLASS).addCost(Resource.SAND, 4).addCost(Resource.COAL, 1));

            OVEN_RECIPES.add(new ResourceRecipe(Resource.BREAD).addCost(Resource.WHEAT, 4));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}