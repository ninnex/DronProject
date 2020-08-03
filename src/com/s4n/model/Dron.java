package com.s4n.model;
import com.s4n.util.Constants;
import com.s4n.util.Util;

import java.util.UUID;

import static com.s4n.util.Constants.orientation.*;

public class Dron {

    private final UUID id;
    private int x;
    private int y;
    private Constants.orientation o;
    private int lunchNumber;

    public String getPosition(){
        return "(" + x + ", " + y + ") dirección " + Util.translateOrientation(o);
    }



    public Dron() {
        id = UUID.randomUUID();
        this.x = 0;
        this.y = 0;
        this.o = Constants.orientation.NORTH;
        this.lunchNumber = 0;
    }

    public Dron(int x, int y, Constants.orientation o) {
        id = UUID.randomUUID();
        this.x = x;
        this.y = y;
        this.o = o;
    }

    public void move(){

        switch (o){
            case NORTH:
                y++;
                break;
            case SOUTH:
                y--;
               break;
            case EAST:
                x++;
                break;
            case WEST:
                x--;
                break;
        }

    }

    public void rotate(String direction){
        if(direction.equals("D"))
            rotateClockwise();
        else if(direction.equals("I"))
            rotateCounterclockwise();
        else
            System.out.println("Wrong Direction");
    }

    public void rotateClockwise(){
        switch (o){
            case NORTH:
                o = EAST;
                break;
            case EAST:
                o = SOUTH;
                break;
            case SOUTH:
                o = WEST;
                break;
            case WEST:
                o = NORTH;
                break;
        }
    }

    public void rotateCounterclockwise(){
        switch (o){
            case NORTH:
                o = WEST;
                break;
            case WEST:
                o = SOUTH;
                break;
            case SOUTH:
                o = EAST;
                break;
            case EAST:
                o = NORTH;
                break;
        }
    }

    public boolean deliverLunch(){
        this.lunchNumber++;
        return lunchNumber >= 0;
    }


    public UUID getId() {
        return id;
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Constants.orientation getO() {
        return o;
    }

    public void setO(Constants.orientation o) {
        this.o = o;
    }


    public int getLunchNumber() {
        return lunchNumber;
    }

    public void setLunchNumber(int lunchNumber) {
        this.lunchNumber = lunchNumber;
    }
}
