package com.kevitv.game.control;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.kevitv.game.model.Player;
import com.kevitv.game.view.MainScreen;

public class PlayerControl {

    public static Player player = MainScreen.player;
    public static CameraControl cameraControl = new CameraControl();

    public static void update() {

        MainScreen.batch.setProjectionMatrix(MainScreen.camera.combined);
        MainScreen.camera.position.set(Player.x, Player.y, 0);
        MainScreen.camera.update();

        if(Gdx.input.isKeyPressed(Input.Keys.W) && Gdx.input.isKeyPressed(Input.Keys.A)) {
            Player.x -= player.speed * MainScreen.deltaCff * 60;
            Player.y += player.speed * MainScreen.deltaCff * 60;

            if (player.object.getRotation() <= 45f)
                player.object.rotate( player.rotateSpeed * MainScreen.deltaCff * 60);
            if(player.object.getRotation() > 45f)
                player.object.rotate( -player.rotateSpeed * MainScreen.deltaCff * 60);

            return;
        }

        if(Gdx.input.isKeyPressed(Input.Keys.W) && Gdx.input.isKeyPressed(Input.Keys.D)) {
            Player.x += player.speed * MainScreen.deltaCff * 60;
            Player.y += player.speed * MainScreen.deltaCff * 60;
            if (player.object.getRotation() >= -45f) {
                player.object.rotate( -player.rotateSpeed * MainScreen.deltaCff * 60);
            }
            if(player.object.getRotation() < -45f)
                player.object.rotate( player.rotateSpeed * MainScreen.deltaCff * 60);
            return;
        }

        if(Gdx.input.isKeyPressed(Input.Keys.S) && Gdx.input.isKeyPressed(Input.Keys.A)) {
            Player.x -= player.speed * MainScreen.deltaCff * 60;
            Player.y -= player.speed * MainScreen.deltaCff * 60;
            if (player.object.getRotation() < 135f) {
                player.object.rotate(player.rotateSpeed * MainScreen.deltaCff * 60);
            }
            return;
        }

        if(Gdx.input.isKeyPressed(Input.Keys.S) && Gdx.input.isKeyPressed(Input.Keys.D)) {
            Player.x += player.speed * MainScreen.deltaCff * 60;
            Player.y -= player.speed * MainScreen.deltaCff * 60;
            if (player.object.getRotation() > -135f) {
                player.object.rotate( -player.rotateSpeed * MainScreen.deltaCff * 60);
            }
            return;
        }

        if(Gdx.input.isKeyPressed(Input.Keys.W)) {
            Player.y += player.speed * MainScreen.deltaCff * 60;
            if (player.object.getRotation() > 0.1f) {
                player.object.rotate( -player.rotateSpeed * MainScreen.deltaCff * 60);
            }
            if (player.object.getRotation() < -0.1f) {
                player.object.rotate( player.rotateSpeed * MainScreen.deltaCff * 60);
            }
        }

        if(Gdx.input.isKeyPressed(Input.Keys.D)) {
            Player.x += player.speed * MainScreen.deltaCff * 60;
            if (player.object.getRotation() > -90f) {
                player.object.rotate( -player.rotateSpeed * MainScreen.deltaCff * 60);
            }
        }

        if(Gdx.input.isKeyPressed(Input.Keys.A)) {
            Player.x -= player.speed * MainScreen.deltaCff * 60;
            if (player.object.getRotation() < 90f) {
                player.object.rotate( player.rotateSpeed * MainScreen.deltaCff * 60);
            }
        }

        if(Gdx.input.isKeyPressed(Input.Keys.S)) {
            Player.y -= player.speed * MainScreen.deltaCff * 60;

            if(player.object.getRotation() > 0) {
                if (player.object.getRotation() < 180f) {
                    player.object.rotate(player.rotateSpeed * MainScreen.deltaCff * 60);
                }
            } else {
                if (player.object.getRotation() > -180f) {
                    player.object.rotate(-player.rotateSpeed * MainScreen.deltaCff * 60);
                }
            }
        }

    }
}
