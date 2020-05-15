package com.kevitv.game.control;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.kevitv.game.model.Player;
import com.kevitv.game.view.MainScreen;

public class PlayerControl {

    public static Player player = MainScreen.player;
    public static CameraControl cameraControl = new CameraControl();

    public static void update() {

        Player.x += (CameraControl.cameraX-Player.x) / (player.speed / 100) * MainScreen.deltaCff ;
        Player.y += (CameraControl.cameraY-Player.y) / (player.speed / 100) * MainScreen.deltaCff ;

        if (Gdx.input.isKeyPressed(Input.Keys.W) && Gdx.input.isKeyPressed(Input.Keys.A)) {
            if(player.rotation > 135f) player.rotation-=player.rotateSpeed*MainScreen.deltaCff;
            if(player.rotation < 135f) player.rotation+=player.rotateSpeed*MainScreen.deltaCff;
            return;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W) && Gdx.input.isKeyPressed(Input.Keys.D)) {
            if(player.rotation > 215f) player.rotation-=player.rotateSpeed*MainScreen.deltaCff;
            if(player.rotation < 215f) player.rotation+=player.rotateSpeed*MainScreen.deltaCff;
            return;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S) && Gdx.input.isKeyPressed(Input.Keys.A)) {
            if(player.rotation > 45f) player.rotation-=player.rotateSpeed*MainScreen.deltaCff;
            if(player.rotation < 45f) player.rotation+=player.rotateSpeed*MainScreen.deltaCff;
            return;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S) && Gdx.input.isKeyPressed(Input.Keys.D)) {
            if(player.rotation > 315f) player.rotation-=player.rotateSpeed*MainScreen.deltaCff;
            if(player.rotation < 315f) player.rotation+=player.rotateSpeed*MainScreen.deltaCff;
        }

    }

    public static void WA() {

    }
    public static void WD() {

    }
    public static void SA() {

    }
    public static void SD() {

    }
    public static void W() {
        if(player.rotation > 180f) player.rotation-=player.rotateSpeed*MainScreen.deltaCff;
        if(player.rotation < 180f) player.rotation+=player.rotateSpeed*MainScreen.deltaCff;
    }
    public static void A() {
        if(player.rotation > 90f) player.rotation-=player.rotateSpeed*MainScreen.deltaCff;
        if(player.rotation < 90f) player.rotation+=player.rotateSpeed*MainScreen.deltaCff;
    }
    public static void S() {
        if(player.rotation > 180f) {
            if (player.rotation < 360f) player.rotation += player.rotateSpeed*MainScreen.deltaCff;
        } else {
            if (player.rotation > 0f) player.rotation -= player.rotateSpeed*MainScreen.deltaCff;
        }
    }
    public static void D() {
        if(player.rotation > 270f) player.rotation-=player.rotateSpeed*MainScreen.deltaCff;
        if(player.rotation < 270f) player.rotation+=player.rotateSpeed*MainScreen.deltaCff;
    }
}
