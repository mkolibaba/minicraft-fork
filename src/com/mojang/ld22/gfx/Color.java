package com.mojang.ld22.gfx;

public class Color {
    /**
     * 255 86 86 86
     */
    public static final int GRAY = Color.get(-1, 500, 500, 500);

    /**
     * 255 215 215 215
     */
    public static final int LIGHT_GRAY = Color.get(-1, 555, 555, 555);

    /**
     * 0 129 129 129
     */
    public static final int DARK_GRAY = Color.get(0, 333, 333, 333);

    /**
     * 0 1 5 173
     */
    public static final int DARK_BLUE = Color.get(-1, 1, 5, 445);

    // a - alpha, d - red, c - green, d - blue ?
    public static int get(int a, int b, int c, int d) {
        return (get(d) << 24) + (get(c) << 16) + (get(b) << 8) + (get(a));
    }

    public static int get(int d) {
        if (d < 0) return 255;
        int r = d / 100 % 10;
        int g = d / 10 % 10;
        int b = d % 10;
        return r * 36 + g * 6 + b;
    }
}