package com.mojang.ld22.sound;

import java.applet.Applet;
import java.applet.AudioClip;

public class Sound {
	public static final Sound PLAYER_HURT = new Sound("/playerhurt.wav");
	public static final Sound PLAYER_DEATH = new Sound("/death.wav");
	public static final Sound MONSTER_HURT = new Sound("/monsterhurt.wav");
	public static final Sound TEST = new Sound("/test.wav");
	public static final Sound PICKUP = new Sound("/pickup.wav");
	public static final Sound BOSS_DEATH = new Sound("/bossdeath.wav");
	public static final Sound CRAFT = new Sound("/craft.wav");

	private AudioClip clip;

	private Sound(String name) {
		try {
			clip = Applet.newAudioClip(Sound.class.getResource(name));
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void play() {
		try {
			new Thread(() -> clip.play()).start();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}