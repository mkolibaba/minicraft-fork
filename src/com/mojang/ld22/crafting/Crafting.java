package com.mojang.ld22.crafting;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.mojang.ld22.entity.Anvil;
import com.mojang.ld22.entity.Chest;
import com.mojang.ld22.entity.Furnace;
import com.mojang.ld22.entity.Oven;
import com.mojang.ld22.entity.Lantern;
import com.mojang.ld22.entity.Workbench;
import com.mojang.ld22.item.ToolMaterial;
import com.mojang.ld22.item.ToolType;
import com.mojang.ld22.item.resource.Resource;

public class Crafting {
    public static final List<Recipe> ANVIL_RECIPES =
            Arrays.asList(
                    new ToolRecipe(ToolType.SWORD, ToolMaterial.IRON).addCost(Resource.WOOD, 5).addCost(Resource.IRON_INGOT, 5),
                    new ToolRecipe(ToolType.AXE, ToolMaterial.IRON).addCost(Resource.WOOD, 5).addCost(Resource.IRON_INGOT, 5),
                    new ToolRecipe(ToolType.HOE, ToolMaterial.IRON).addCost(Resource.WOOD, 5).addCost(Resource.IRON_INGOT, 5),
                    new ToolRecipe(ToolType.PICKAXE, ToolMaterial.IRON).addCost(Resource.WOOD, 5).addCost(Resource.IRON_INGOT, 5),
                    new ToolRecipe(ToolType.SHOVEL, ToolMaterial.IRON).addCost(Resource.WOOD, 5).addCost(Resource.IRON_INGOT, 5),
                    new ToolRecipe(ToolType.SWORD, ToolMaterial.GOLD).addCost(Resource.WOOD, 5).addCost(Resource.GOLD_INGOT, 5),
                    new ToolRecipe(ToolType.AXE, ToolMaterial.GOLD).addCost(Resource.WOOD, 5).addCost(Resource.GOLD_INGOT, 5),
                    new ToolRecipe(ToolType.HOE, ToolMaterial.GOLD).addCost(Resource.WOOD, 5).addCost(Resource.GOLD_INGOT, 5),
                    new ToolRecipe(ToolType.PICKAXE, ToolMaterial.GOLD).addCost(Resource.WOOD, 5).addCost(Resource.GOLD_INGOT, 5),
                    new ToolRecipe(ToolType.SHOVEL, ToolMaterial.GOLD).addCost(Resource.WOOD, 5).addCost(Resource.GOLD_INGOT, 5),
                    new ToolRecipe(ToolType.SWORD, ToolMaterial.GEM).addCost(Resource.WOOD, 5).addCost(Resource.GEM, 50),
                    new ToolRecipe(ToolType.AXE, ToolMaterial.GEM).addCost(Resource.WOOD, 5).addCost(Resource.GEM, 50),
                    new ToolRecipe(ToolType.HOE, ToolMaterial.GEM).addCost(Resource.WOOD, 5).addCost(Resource.GEM, 50),
                    new ToolRecipe(ToolType.PICKAXE, ToolMaterial.GEM).addCost(Resource.WOOD, 5).addCost(Resource.GEM, 50),
                    new ToolRecipe(ToolType.SHOVEL, ToolMaterial.GEM).addCost(Resource.WOOD, 5).addCost(Resource.GEM, 50)
            );

    public static final List<Recipe> OVEN_RECIPES =
            Collections.singletonList(new ResourceRecipe(Resource.BREAD).addCost(Resource.WHEAT, 4));

    public static final List<Recipe> FURNACE_RECIPES =
            Arrays.asList(
                    new ResourceRecipe(Resource.IRON_INGOT).addCost(Resource.IRON_ORE, 4).addCost(Resource.COAL, 1),
                    new ResourceRecipe(Resource.GOLD_INGOT).addCost(Resource.GOLD_ORE, 4).addCost(Resource.COAL, 1),
                    new ResourceRecipe(Resource.GLASS).addCost(Resource.SAND, 4).addCost(Resource.COAL, 1)
            );

    public static final List<Recipe> WORKBENCH_RECIPES =
            Arrays.asList(
                    FurnitureRecipe.fromClass(Lantern.class).addCost(Resource.WOOD, 5).addCost(Resource.SLIME, 10).addCost(Resource.GLASS, 4),
                    FurnitureRecipe.fromClass(Oven.class).addCost(Resource.STONE, 15),
                    FurnitureRecipe.fromClass(Furnace.class).addCost(Resource.STONE, 20),
                    FurnitureRecipe.fromClass(Workbench.class).addCost(Resource.WOOD, 20),
                    FurnitureRecipe.fromClass(Chest.class).addCost(Resource.WOOD, 20),
                    FurnitureRecipe.fromClass(Anvil.class).addCost(Resource.IRON_INGOT, 5),
                    new ToolRecipe(ToolType.SWORD, ToolMaterial.WOOD).addCost(Resource.WOOD, 5),
                    new ToolRecipe(ToolType.AXE, ToolMaterial.WOOD).addCost(Resource.WOOD, 5),
                    new ToolRecipe(ToolType.HOE, ToolMaterial.WOOD).addCost(Resource.WOOD, 5),
                    new ToolRecipe(ToolType.PICKAXE, ToolMaterial.WOOD).addCost(Resource.WOOD, 5),
                    new ToolRecipe(ToolType.SHOVEL, ToolMaterial.WOOD).addCost(Resource.WOOD, 5),
                    new ToolRecipe(ToolType.SWORD, ToolMaterial.ROCK).addCost(Resource.WOOD, 5).addCost(Resource.STONE, 5),
                    new ToolRecipe(ToolType.AXE, ToolMaterial.ROCK).addCost(Resource.WOOD, 5).addCost(Resource.STONE, 5),
                    new ToolRecipe(ToolType.HOE, ToolMaterial.ROCK).addCost(Resource.WOOD, 5).addCost(Resource.STONE, 5),
                    new ToolRecipe(ToolType.PICKAXE, ToolMaterial.ROCK).addCost(Resource.WOOD, 5).addCost(Resource.STONE, 5),
                    new ToolRecipe(ToolType.SHOVEL, ToolMaterial.ROCK).addCost(Resource.WOOD, 5).addCost(Resource.STONE, 5)
            );
}