package com.kevitv.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.kevitv.game.Main;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.height=480;
		config.width=850;
		config.foregroundFPS=0;
		config.vSyncEnabled=false;

		new LwjglApplication(new Main(), config);
	}
}
