package com.mojang.ld22.item;

import com.mojang.ld22.entity.Entity;
import com.mojang.ld22.entity.ItemEntity;

public class ToolItem extends Item implements Takeable {
    public ToolType type;
    public ToolMaterial material;
    public int rarity;

    static {
        spriteOffset = 5 * 32;
    }

    public ToolItem(ToolType type, ToolMaterial material) {
        this.type = type;
        this.material = material;
        this.rarity = material.rarity;
    }

    public int getColor() {
        return material.color;
    }

    public int getSprite() {
        return type.sprite + spriteOffset;
    }

    public String getName() {
        return material.name() + " " + type.name;
    }

    public void onTake(ItemEntity itemEntity) {
    }

    public boolean canAttack() {
        return true;
    }

    public int getAttackDamageBonus(Entity e) {
        return type.getAttackDamageBonus(material.rarity);
    }

    public boolean matches(Item item) {
        if (item instanceof ToolItem) {
            ToolItem other = (ToolItem) item;
            return this.type == other.type && this.material == other.material;
        }
        return false;
    }
}