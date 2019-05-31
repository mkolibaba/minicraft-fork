package com.mojang.ld22.item;

import static com.mojang.ld22.Global.DEFAULT_RANDOM;

public enum ToolType {
    SHOVEL("Shvl", 0) {
        @Override
        public int getAttackDamageBonus(ToolMaterial material) {
            return 1;
        }
    },
    HOE("Hoe", 1) {
        @Override
        public int getAttackDamageBonus(ToolMaterial material) {
            return 1;
        }
    },
    SWORD("Swrd", 2) {
        @Override
        public int getAttackDamageBonus(ToolMaterial material) {
            return (material.rarity + 1) * 3 + DEFAULT_RANDOM.nextInt(2 + material.rarity * material.rarity * 2);
        }
    },
    PICKAXE("Pick", 3) {
        @Override
        public int getAttackDamageBonus(ToolMaterial material) {
            return 1;
        }
    },
    AXE("Axe", 4) {
        @Override
        public int getAttackDamageBonus(ToolMaterial material) {
            return (material.rarity + 1) * 2 + DEFAULT_RANDOM.nextInt(4);
        }
    };

    public final String name;
    public final int sprite;

    ToolType(String name, int sprite) {
        this.name = name;
        this.sprite = sprite;
    }

    public abstract int getAttackDamageBonus(ToolMaterial material);
}
