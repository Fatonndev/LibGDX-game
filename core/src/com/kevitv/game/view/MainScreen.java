package com.kevitv.game.view;

import com.badlogic.gdx.*;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.kevitv.game.content.Blocks;
import com.kevitv.game.control.CameraControl;
import com.kevitv.game.control.PlayerControl;
import com.kevitv.game.logic.Draw;
import com.kevitv.game.logic.World;
import com.kevitv.game.model.Player;
import com.kevitv.game.utils.Assets;
import com.kevitv.game.utils.TextManager;

public class MainScreen implements Screen {

    public static float deltaCff;
    public static SpriteBatch batch;
    public static TextureAtlas textureAtlas;
    public static World world = new World(200,200);
    public static int WIDTH, HEIGHT;
    public static OrthographicCamera camera;
    public static float aspectRatio;
    public static Player player;

    public void setTextureAtlas(TextureAtlas textureAtlas) {
        this.textureAtlas = textureAtlas;
    }

    @Override
    public void show() {
        TextManager.initialize(300,300);
        batch = new SpriteBatch();
        ScreenManager.setScreen(new MenuScreen());
        player = new Player();
        Gdx.input.setInputProcessor(PlayerControl.cameraControl);
    }


    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        Draw.draw();
        player.draw();
        TextManager.displayMessage(batch);
        PlayerControl.update();

        world.tile(2,1).setBlock(Blocks.wall);
        world.tile(1,2).setBlock(Blocks.grassRock);
        world.tile(1,3).setBlock(Blocks.wall);
        world.tile(2,3).setBlock(Blocks.wall);

        batch.end();

        if(ScreenManager.getCurrentUpdate()!=null)
            ScreenManager.getCurrentUpdate().Draw(batch);

        if(ScreenManager.getCurrentScreen()!=null)
            ScreenManager.getCurrentScreen().render(batch);

        deltaCff = delta;

    }

    @Override
    public void resize(int width, int height) {

        if(ScreenManager.getCurrentScreen()!=null)
            ScreenManager.getCurrentScreen().resize(width,height);

        aspectRatio = (float) height / width;
        camera = new OrthographicCamera(height, height*aspectRatio);
        camera.position.set(height/2,height*aspectRatio/2,0);
        camera.update();

        WIDTH = width;
        HEIGHT = height;

    }

    @Override
    public void pause() {
        if(ScreenManager.getCurrentScreen()!=null)
            ScreenManager.getCurrentScreen().pause();
    }

    @Override
    public void resume() {
        if(ScreenManager.getCurrentScreen()!=null)
            ScreenManager.getCurrentScreen().resume();
    }

    @Override
    public void hide() {
        if(ScreenManager.getCurrentScreen()!=null)
            ScreenManager.getCurrentScreen().hide();
    }

    @Override
    public void dispose() {
        if (ScreenManager.getCurrentScreen()!=null)
            ScreenManager.getCurrentScreen().dispose();
        batch.dispose();
        Assets.dispose();
        TextManager.dispose();
    }
}
