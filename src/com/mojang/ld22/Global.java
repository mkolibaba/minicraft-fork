package com.mojang.ld22;

import java.util.Random;

/**
 * @author Maksim Kolibaba
 * @since 29.05.2019
 */
public class Global {
    public static final Random DEFAULT_RANDOM = new Random();

    private Global() {
        throw new UnsupportedOperationException();
    }
}
