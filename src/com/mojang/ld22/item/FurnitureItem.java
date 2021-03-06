package com.mojang.ld22.item;

import com.mojang.ld22.entity.Furniture;
import com.mojang.ld22.entity.ItemEntity;
import com.mojang.ld22.entity.creature.Player;
import com.mojang.ld22.level.Level;
import com.mojang.ld22.level.tile.Tile;

public class FurnitureItem extends Item implements Takeable {
	public Furniture furniture;
	public boolean placed = false;

	static {
		spriteOffset = 10 * 32;
	}

	public FurnitureItem(Furniture furniture) {
		this.furniture = furniture;
	}

	public int getColor() {
		return furniture.col;
	}

	public int getSprite() {
		return furniture.sprite + spriteOffset;
	}

	public void onTake(ItemEntity itemEntity) {
	}

	public boolean interactOn(Tile tile, Level level, int xt, int yt, Player player, int attackDir) {
		if (tile.mayPass(level, xt, yt, furniture)) {
			furniture.x = xt * 16 + 8;
			furniture.y = yt * 16 + 8;
			level.add(furniture);
			placed = true;
			return true;
		}
		return false;
	}

	public boolean isDepleted() {
		return placed;
	}
	
	public String getName() {
		return furniture.name;
	}
}