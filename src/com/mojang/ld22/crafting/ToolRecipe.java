package com.mojang.ld22.crafting;

import com.mojang.ld22.entity.Player;
import com.mojang.ld22.item.ToolItem;
import com.mojang.ld22.item.ToolMaterial;
import com.mojang.ld22.item.ToolType;

public class ToolRecipe extends Recipe {
	private ToolType type;
	private int level;

	public ToolRecipe(ToolType type, ToolMaterial material) {
		super(new ToolItem(type, material));
		this.type = type;
		this.level = material.rarity;
	}

	public void craft(Player player) {
		player.inventory.add(0, new ToolItem(type, ToolMaterial.fromRarity(level)));
	}
}
