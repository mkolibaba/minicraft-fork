package com.mojang.ld22.item;

import com.mojang.ld22.entity.ItemEntity;

/**
 * @author Maksim Kolibaba
 * @since 29.05.2019
 */
public interface Takeable {
    void onTake(ItemEntity itemEntity);
}
