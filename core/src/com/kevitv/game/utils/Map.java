package com.kevitv.game.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.kevitv.game.content.Blocks;
import com.kevitv.game.logic.World;
import com.kevitv.game.model.Block;
import com.kevitv.game.model.Floor;

import java.io.*;

public class Map {

    public static int mapSizeX = 1, mapSizeY = 1;
    public static World world;

    private static int yi = 0;

    public static World load() {
        try {

            // Основа
            FileHandle handle = Gdx.files.internal("maps/testMap.map");
            FileReader fr = new FileReader(handle.file());
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();

            while (line != null) {

                if(line.startsWith("mapSizeX: ")) {
                    mapSizeX = Integer.parseInt(line.replace("mapSizeX: ", ""));
                } else if(line.startsWith("mapSizeY: ")) {
                    mapSizeY = Integer.parseInt(line.replace("mapSizeY: ", ""));
                    world = new World(mapSizeX, mapSizeY);
                } else {
                    for(int xi = 0; xi < line.split(" ").length; xi++) {
                        world.tile(xi, mapSizeY - yi - 1).setFloor(searchFloor(line.split(" ")[xi].split(":")[0]));
                        world.tile(xi, mapSizeY - yi - 1).setBlock(search(line.split(" ")[xi].split(":")[1]));
                    }
                    yi++;
                }
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return world;
    }

    public static void save() {
        try {
            FileWriter fw = new FileWriter("maps/testMap.map");
            fw.write("mapSizeX: "+mapSizeX+"\n");
            fw.write("mapSizeY: "+mapSizeY);

            for(int yi = 0; yi < mapSizeY; yi++) {
                fw.write("\n");
                for(int xi = 0; xi < mapSizeX; xi++) {
                    fw.write(search(world.tile(xi, mapSizeY-yi-1).floor)+":"+search(world.tile(xi, mapSizeY-yi-1).block)+" ");
                }
            }

            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String search(Floor floor) {

        String name = "0";

        if(floor.name.equals(Blocks.sand.name)) name = "1";

        return name;
    }

    public static String search(Block block) {

        String name = "0";

        if(block.name.equals(Blocks.wall.name)) name = "1";
        if(block.name.equals(Blocks.grassRock.name)) name = "2";

        return name;
    }

    public static Floor searchFloor(String name) {
        Floor block = (Floor) Blocks.grass;

        if(name.equals("1")) block = (Floor) Blocks.sand;

        return block;
    }

    public static Block search(String name) {
        Block block = Blocks.air;

        if(name.equals("1")) block = Blocks.wall;
        if(name.equals("2")) block = Blocks.grassRock;

        return block;
    }

}
