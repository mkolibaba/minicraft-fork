package com.mojang.ld22.item;

import com.mojang.ld22.entity.Entity;
import com.mojang.ld22.entity.Furniture;
import com.mojang.ld22.entity.creature.Player;
import com.mojang.ld22.gfx.Color;

public class PowerGloveItem extends Item {
	private int color = Color.get(-1, 100, 320, 430);

	static {
		spriteOffset = 4 * 32;
	}

	public int getColor() {
		return color;
	}

	public int getSprite() {
		return 7 + spriteOffset;
	}

	public String getName() {
		return "Pow glove";
	}

	public boolean interact(Player player, Entity entity, int attackDir) {
		if (entity instanceof Furniture) {
			Furniture f = (Furniture) entity;
			f.take(player);
			return true;
		}
		return false;
	}
}