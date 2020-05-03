package com.kevitv.game.view;

import com.kevitv.game.logic.Update;

public class ScreenManager {

    private static Screen currentScreen;
    private static Update currentUpdate;

    public static void setUpdate(Update update) {
        currentUpdate = update;
    }

    public static void setScreen(Screen screen) {
        if(currentScreen!=null)
            currentScreen.dispose();
        currentScreen = screen;
        currentScreen.create();
    }

    public static Screen getCurrentScreen() {
        return currentScreen;
    }

    public static Update getCurrentUpdate() {
        return currentUpdate;
    }
}
