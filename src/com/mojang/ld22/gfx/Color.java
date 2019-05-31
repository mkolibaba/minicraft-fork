package com.mojang.ld22.gfx;

// https://en.wikipedia.org/wiki/List_of_software_palettes
public class Color {
    /*
    a, b, c, d means 4 colors of sprite
     */

    public static final int BLACK_COLOR = 0;
    public static final int WHITE_COLOR = -1;
    public static final int BLUE_COLOR = 5;
    public static final int GREEN_COLOR = 50;
    public static final int RED_COLOR = 500;
    public static final int GRAY20_COLOR = 111;
    public static final int GRAY60_COLOR = 333;

    public static final int WHITE_RED_RED_RED = Color.get(WHITE_COLOR, RED_COLOR, RED_COLOR, RED_COLOR);
    public static final int LIGHT_GRAY = Color.get(WHITE_COLOR, 555, 555, 555);
    public static final int BLACK_GRAY60_GRAY60_GRAY60 = Color.get(BLACK_COLOR, GRAY60_COLOR, GRAY60_COLOR, GRAY60_COLOR);
    public static final int DARK_BLUE = Color.get(WHITE_COLOR, 1, 5, 445);

    public static int get(int a, int b, int c, int d) {
        return (encodeTo6LevelRGB(d) << 24) + (encodeTo6LevelRGB(c) << 16) + (encodeTo6LevelRGB(b) << 8) + (encodeTo6LevelRGB(a));
    }

    public static int encodeTo6LevelRGB(int d) {
        if (d < 0) return 255;
        int r = d / 100 % 10;
        int g = d / 10 % 10;
        int b = d % 10;
        return r * 36 + g * 6 + b;
    }
}