package com.mojang.ld22.item;

import com.mojang.ld22.entity.Entity;
import com.mojang.ld22.entity.creature.Player;
import com.mojang.ld22.gfx.Color;
import com.mojang.ld22.gfx.Font;
import com.mojang.ld22.gfx.Screen;
import com.mojang.ld22.level.Level;
import com.mojang.ld22.level.tile.Tile;
import com.mojang.ld22.screen.ListItem;

public abstract class Item implements ListItem {
    protected static int spriteOffset;
    protected static int fontOffset = 8;

    public abstract int getColor();

    public abstract int getSprite();

    public void renderInventory(Screen screen, int x, int y) {
        renderIcon(screen, x, y);
        Font.draw(getName(), screen, x + fontOffset, y, Color.LIGHT_GRAY);
    }

    public boolean interact(Player player, Entity entity, int attackDir) {
        return false;
    }

    public void renderIcon(Screen screen, int x, int y) {
        screen.render(x, y, getSprite(), getColor(), 0);
    }

    public boolean interactOn(Tile tile, Level level, int xt, int yt, Player player, int attackDir) {
        return false;
    }

    public boolean isDepleted() {
        return false;
    }

    public boolean canAttack() {
        return false;
    }

    public int getAttackDamageBonus(Entity e) {
        return 0;
    }

    public abstract String getName();

    public boolean matches(Item item) {
        return item.getClass() == getClass();
    }
}