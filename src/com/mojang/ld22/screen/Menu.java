package com.mojang.ld22.screen;

import java.util.List;

import com.mojang.ld22.Game;
import com.mojang.ld22.InputHandler;
import com.mojang.ld22.gfx.Color;
import com.mojang.ld22.gfx.Font;
import com.mojang.ld22.gfx.Screen;

public class Menu {
    protected Game game;
    protected InputHandler input;

    public void init(Game game, InputHandler input) {
        this.input = input;
        this.game = game;
    }

    public void tick() {
    }

    public void render(Screen screen) {
    }

    protected void render0(Screen screen, boolean won) {
        Font.renderFrame(screen, "", 1, 3, 18, 9);
        Font.draw(won ? "You won! Yay!" : "You died! Aww!", screen, 2 * 8, 4 * 8, Color.get(-1, 555, 555, 555));

        int seconds = game.gameTime / 60;
        int minutes = seconds / 60;
        int hours = minutes / 60;
        minutes %= 60;
        seconds %= 60;

        String timeString;
        if (hours > 0) {
            timeString = hours + "h" + (minutes < 10 ? "0" : "") + minutes + "m";
        } else {
            timeString = minutes + "m " + (seconds < 10 ? "0" : "") + seconds + "s";
        }
        Font.draw("Time:", screen, 2 * 8, 5 * 8, Color.get(-1, 555, 555, 555));
        Font.draw(timeString, screen, (2 + 5) * 8, 5 * 8, Color.get(-1, 550, 550, 550));
        Font.draw("Score:", screen, 2 * 8, 6 * 8, Color.get(-1, 555, 555, 555));
        Font.draw("" + game.player.score, screen, (2 + 6) * 8, 6 * 8, Color.get(-1, 550, 550, 550));
        Font.draw(won ? "Press C to win" : "Press C to lose", screen, 2 * 8, 8 * 8, Color.get(-1, 333, 333, 333));
    }

    public void renderItemList(Screen screen, int xo, int yo, int x1, int y1, List<? extends ListItem> listItems, int selected) {
        boolean renderCursor = true;
        if (selected < 0) {
            selected = -selected - 1;
            renderCursor = false;
        }
        int w = x1 - xo;
        int h = y1 - yo - 1;
        int i0 = 0;
        int i1 = listItems.size();
        if (i1 > h) i1 = h;
        int io = selected - h / 2;
        if (io > listItems.size() - h) io = listItems.size() - h;
        if (io < 0) io = 0;

        for (int i = i0; i < i1; i++) {
            listItems.get(i + io).renderInventory(screen, (1 + xo) * 8, (i + 1 + yo) * 8);
        }

        if (renderCursor) {
            int yy = selected + 1 - io + yo;
            Font.draw(">", screen, (xo + 0) * 8, yy * 8, Color.get(5, 555, 555, 555));
            Font.draw("<", screen, (xo + w) * 8, yy * 8, Color.get(5, 555, 555, 555));
        }
    }
}
