package com.mojang.ld22.crafting;

import com.mojang.ld22.entity.Furniture;
import com.mojang.ld22.entity.Player;
import com.mojang.ld22.item.FurnitureItem;

public class FurnitureRecipe extends Recipe {
    private Class<? extends Furniture> clazz;

    public FurnitureRecipe(FurnitureItem item) {
        super(item);
        this.clazz = item.furniture.getClass();
    }

    public static FurnitureRecipe fromClass(Class<? extends Furniture> clazz) {
        FurnitureItem furnitureItem = null;
        try {
            furnitureItem = new FurnitureItem(clazz.newInstance());
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return new FurnitureRecipe(furnitureItem);
    }

    public void craft(Player player) {
        try {
            player.inventory.add(0, new FurnitureItem(clazz.newInstance()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
