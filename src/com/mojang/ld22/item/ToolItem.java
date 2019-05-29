package com.mojang.ld22.item;

import com.mojang.ld22.entity.Entity;
import com.mojang.ld22.entity.ItemEntity;
import com.mojang.ld22.gfx.Color;
import com.mojang.ld22.gfx.Font;
import com.mojang.ld22.gfx.Screen;

public class ToolItem extends Item {
    public ToolType type;
    public ToolMaterial material;
    public int rarity;

    static {
        spriteOffset = 5 * 32;
    }

    public ToolItem(ToolType type, int rarity) {
        this.type = type;
        this.rarity = rarity;
        this.material = ToolMaterial.fromRarity(rarity);
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

    public void renderIcon(Screen screen, int x, int y) {
        screen.render(x, y, getSprite(), getColor(), 0);
    }

    public void renderInventory(Screen screen, int x, int y) {
        screen.render(x, y, getSprite(), getColor(), 0);
        Font.draw(getName(), screen, x + 8, y, Color.LIGHT_GRAY);
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
        return type.getAttackDamageBonus(rarity);
    }

    public boolean matches(Item item) {
        if (item instanceof ToolItem) {
            ToolItem other = (ToolItem) item;
            if (other.type != type) return false;
            return other.rarity == rarity;
        }
        return false;
    }
}