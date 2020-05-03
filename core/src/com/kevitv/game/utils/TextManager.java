package com.kevitv.game.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TextManager {

    static BitmapFont font;
    static float width,height;

    public static void initialize(float width,float height){

        font = new BitmapFont(Gdx.files.internal("fonts/font.fnt"));
        TextManager.width  = width;
        TextManager.height = height;
        // масштабируем размер шрифта в соответсвии с шириной экрана
        font.getData().setScale(width/500f);
    }

    public static void displayMessage(SpriteBatch batch){

        GlyphLayout glyphLayout = new GlyphLayout();
        glyphLayout.setText(font, "FPS: "+Gdx.graphics.getFramesPerSecond());

        font.draw(batch, glyphLayout, width - width/15f, height*0.95f);
    }
}
