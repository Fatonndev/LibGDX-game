package com.kevitv.game.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.kevitv.game.utils.Log;
import com.kevitv.game.view.MainScreen;

public class TextManager {

    static BitmapFont font;
    static float width, height;

    public static void initialize(float width,float height){

        font = new BitmapFont(Gdx.files.internal("fonts/font.fnt"));
        TextManager.width = width;
        TextManager.height = height;

        font.getData().scaleX = MainScreen.aspectRatio * 1.5f;
        font.getData().scaleY = 1;
        Log.info(font.getData().scaleY);

    }

    public static void displayMessage(String text, float x, float y){

        GlyphLayout glyphLayout = new GlyphLayout();
        glyphLayout.setText(font, text);

        font.draw(MainScreen.batch, glyphLayout, x, y);
    }

    public static void displayMessage(String text, boolean left, boolean right, boolean top, boolean bottom){
        float x = (float) MainScreen.WIDTH/2, y = (float) MainScreen.HEIGHT/2;
        if(left) x = 0;
        if(bottom) y = 20;
        if(right) x = MainScreen.WIDTH-50;
        if(top) y = MainScreen.HEIGHT-20;
        displayMessage(text, x, y);
    }

    public static void dispose() {
        font.dispose();
    }
}
