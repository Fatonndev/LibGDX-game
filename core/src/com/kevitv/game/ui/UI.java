package com.kevitv.game.ui;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.kevitv.game.control.CameraControl;
import com.kevitv.game.utils.Assets;
import com.kevitv.game.view.MainScreen;

public class UI {

    public static void drawCurrentBlock() {
        TextureRegion texture = Assets.getTexture(CameraControl.currentBlock.name);

        Sprite object = new Sprite(texture);
        object.setSize(32.04f * MainScreen.camera.zoom,32.04f * MainScreen.camera.zoom);
        object.setOrigin(32/2f * MainScreen.camera.zoom, 32/2f * MainScreen.camera.zoom);
        object.setPosition(MainScreen.camera.position.x - MainScreen.HEIGHT/2 * MainScreen.camera.zoom + 5 * MainScreen.camera.zoom,
                MainScreen.camera.position.y - MainScreen.HEIGHT/2 * MainScreen.aspectRatio * MainScreen.camera.zoom + 5 * MainScreen.camera.zoom);

        Sprite shadow = new Sprite(Assets.getTexture("shadow"));
        shadow.setSize(42 * MainScreen.camera.zoom,42 * MainScreen.camera.zoom);
        shadow.setOrigin(42/2f * MainScreen.camera.zoom, 42/2f * MainScreen.camera.zoom);
        shadow.setPosition(MainScreen.camera.position.x - MainScreen.HEIGHT/2 * MainScreen.camera.zoom + 1 * MainScreen.camera.zoom,
                MainScreen.camera.position.y - MainScreen.HEIGHT/2 * MainScreen.aspectRatio * MainScreen.camera.zoom + 1 * MainScreen.camera.zoom);

        shadow.draw(MainScreen.batch);
        object.draw(MainScreen.batch);
    }

    public static void drawButton () {

    }

}
