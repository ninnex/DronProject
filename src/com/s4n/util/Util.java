package com.s4n.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static com.s4n.util.Constants.orientation.*;

public class Util {

    public static List<String> getDirectoryFiles(){
        List<String> list = new ArrayList<>();

        try (Stream<Path> paths = Files.walk(Paths.get("files/in/"))) {
            paths.filter(Files::isRegularFile)
                    .forEach( f -> list.add(f.toString()));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return  list;

    }

    public static String translateOrientation(Constants.orientation ori){
        switch (ori){
            case NORTH:
                return "Norte";
            case SOUTH:
                return "Sur";
            case EAST:
                return "Oriente";
            case WEST:
                return "Occidente";
        }
        return null;
    }

    public static Constants.orientation getEnumOrientation(char ori){
        switch (ori){
            case 'N':
                return NORTH;
            case 'S':
                return SOUTH;
            case 'E':
                return EAST;
            case 'O':
                return WEST;
        }
        return NORTH;
    }
}
