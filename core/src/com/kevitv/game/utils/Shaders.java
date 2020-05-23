package com.kevitv.game.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.kevitv.game.view.MainScreen;

public class Shaders {

    public static ShaderProgram shadow;

    public static void load() {

        // Желательно использовать, тк если мы используем не все юниформы, то шейдер не скомпилируется
        ShaderProgram.pedantic = false;

        shadow = new ShaderProgram(
            Gdx.files.internal("shaders/shadow.vert"),
            Gdx.files.internal("shaders/shadow.frag")
        );

        if (!shadow.isCompiled()) {
            System.err.println(shadow.getLog());
            System.exit(0);
        }
    }

    public static void dispose() {
        shadow.dispose();
    }
}
