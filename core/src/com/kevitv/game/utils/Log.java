package com.kevitv.game.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {

    private static SimpleDateFormat formatForDateNow = new SimpleDateFormat("hh:mm:ss");

    public static String date () {
        Date dateNow = new Date();
        return "["+formatForDateNow.format(dateNow)+"]";
    }

    static void log(String text, Object... objects) {

        if (text.equals("[INFO]: ") || text.equals("[ERROR]: ") || text.equals("[WARN]: ")) {
            text = objects[0].toString();
        } else if(objects.length>0) {
            for(int i = 0; i < objects.length; i++) {
                text = text.replace("{"+i+"}", objects[i].toString());
            }
        }

        System.out.println(date()+text);
    }

    public static void info (String text, Object... objects) {
        log("[INFO]: "+text, objects);
    }
    public static void info (Object object) {
        log("[INFO]: ", object);
    }

    public static void warn (String text, Object... objects) {
        log("[WARN]: "+text, objects);
    }
    public static void warn (Object object) {
        log("[WARN]: ", object);
    }

    public static void err (String text, Object... objects) {
        log("[ERR]: "+text, objects);
    }
    public static void err (Object object) {
        log("[ERR]: ", object);
    }

}
