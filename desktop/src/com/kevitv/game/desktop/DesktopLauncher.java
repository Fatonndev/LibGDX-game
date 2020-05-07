package com.kevitv.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.kevitv.game.Main;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.height=720;
		config.width=1280;
		config.foregroundFPS=100;
		config.vSyncEnabled=false;

		new LwjglApplication(new Main(), config);
	}
}
