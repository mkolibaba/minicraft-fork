package com.mojang.ld22.entity.creature;

import static com.mojang.ld22.Global.DEFAULT_RANDOM;

/**
 * @author Maksim Kolibaba
 * @since 01.06.2019
 */
public class Mob extends Creature {
    protected int xa, ya;

    public Mob() {
        x = DEFAULT_RANDOM.nextInt(64 * 16);
        y = DEFAULT_RANDOM.nextInt(64 * 16);
    }
}
