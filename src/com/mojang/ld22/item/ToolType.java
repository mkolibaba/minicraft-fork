package com.mojang.ld22.item;

import static com.mojang.ld22.Global.DEFAULT_RANDOM;

public enum ToolType {
    SHOVEL("Shvl", 0) {
        @Override
        public int getAttackDamageBonus(int level) {
            return 1;
        }
    },
    HOE("Hoe", 1) {
        @Override
        public int getAttackDamageBonus(int level) {
            return 1;
        }
    },
    SWORD("Swrd", 2) {
        @Override
        public int getAttackDamageBonus(int level) {
            return (level + 1) * 3 + DEFAULT_RANDOM.nextInt(2 + level * level * 2);
        }
    },
    PICKAXE("Pick", 3) {
        @Override
        public int getAttackDamageBonus(int level) {
            return 1;
        }
    },
    AXE("Axe", 4) {
        @Override
        public int getAttackDamageBonus(int level) {
            return (level + 1) * 2 + DEFAULT_RANDOM.nextInt(4);
        }
    };

    public final String name;
    public final int sprite;

    ToolType(String name, int sprite) {
        this.name = name;
        this.sprite = sprite;
    }

    public abstract int getAttackDamageBonus(int level);
}
