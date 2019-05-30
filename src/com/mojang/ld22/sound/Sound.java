package com.mojang.ld22.sound;

import java.applet.Applet;
import java.applet.AudioClip;

public enum Sound {
    PLAYER_HURT("/playerhurt.wav"),
    PLAYER_DEATH("/death.wav"),
    MONSTER_HURT("/monsterhurt.wav"),
    TEST("/test.wav"),
    PICKUP("/pickup.wav"),
    BOSS_DEATH("/bossdeath.wav"),
    CRAFT("/craft.wav");

    private AudioClip clip;

    Sound(String name) {
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