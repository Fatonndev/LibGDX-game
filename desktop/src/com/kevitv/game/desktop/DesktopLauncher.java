package com.kevitv.game.desktop;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.kevitv.game.Main;

public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();

		config.setTitle("BanDustry");
		config.setWindowedMode(1280, 720);
		config.setIdleFPS(30);
		config.useVsync(false);

		new Lwjgl3Application(new Main(), config);
	}
}
