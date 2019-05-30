package com.mojang.ld22.crafting;

import com.mojang.ld22.entity.Player;
import com.mojang.ld22.item.ToolItem;
import com.mojang.ld22.item.ToolMaterial;
import com.mojang.ld22.item.ToolType;

public class ToolRecipe extends Recipe {
	private ToolType type;
	private ToolMaterial material;

	public ToolRecipe(ToolType type, ToolMaterial material) {
		super(new ToolItem(type, material));
		this.type = type;
		this.material = material;
	}

	public void craft(Player player) {
		player.inventory.add(0, new ToolItem(type, material));
	}
}
