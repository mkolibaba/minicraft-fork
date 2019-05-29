package com.mojang.ld22.screen;

import com.mojang.ld22.gfx.Screen;

public class WonMenu extends Menu {
	private int inputDelay = 60;

	public WonMenu() {
	}

	public void tick() {
		if (inputDelay > 0)
			inputDelay--;
		else if (input.attack.clicked || input.menu.clicked) {
			game.setMenu(new TitleMenu());
		}
	}

	public void render(Screen screen) {
		render0(screen, true);
	}
}
