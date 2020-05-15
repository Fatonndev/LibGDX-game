package com.kevitv.game.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.kevitv.game.view.MainScreen;

public class TextManager {

    static BitmapFont font;
    static float width, height;

    public static void initialize(float width,float height){

        font = new BitmapFont(Gdx.files.internal("fonts/font.fnt"));
        TextManager.width = width;
        TextManager.height = height;

        font.getData().scaleX=MainScreen.aspectRatio;
        font.getData().scaleY=MainScreen.aspectRatio;
        Log.info(font.getData().scaleY);

    }

    public static void displayMessage(String text){

        GlyphLayout glyphLayout = new GlyphLayout();
        glyphLayout.setText(font, text);

        font.draw(MainScreen.batch, glyphLayout, MainScreen.camera.position.x - MainScreen.WIDTH * MainScreen.aspectRatio / 2, MainScreen.camera.position.y + MainScreen.HEIGHT * MainScreen.aspectRatio / 2);
    }

    public static void dispose() {
        font.dispose();
    }
}
