package com.mojang.ld22.item;

import com.mojang.ld22.gfx.Color;

/**
 * @author Maksim Kolibaba
 * @since 29.05.2019
 */
public enum ToolMaterial {
    WOOD(Color.get(Color.WHITE_COLOR, 100, 321, 431), 0),
    ROCK(Color.get(Color.WHITE_COLOR, 100, 321, 111), 1),
    IRON(Color.get(Color.WHITE_COLOR, 100, 321, 555), 2),
    GOLD(Color.get(Color.WHITE_COLOR, 100, 321, 550), 3),
    GEM(Color.get(Color.WHITE_COLOR, 100, 321, 55), 4);

    public final int color;
    public final int rarity;

    ToolMaterial(int color, int rarity) {
        this.color = color;
        this.rarity = rarity;
    }
}
