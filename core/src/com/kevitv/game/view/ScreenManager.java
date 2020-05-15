package com.kevitv.game.view;

public class ScreenManager {

    private static Screen currentScreen;

    public static void setScreen(Screen screen) {
        if(currentScreen!=null)
            currentScreen.dispose();
        currentScreen = screen;
        currentScreen.create();
    }

    public static Screen getCurrentScreen() {
        return currentScreen;
    }
}
