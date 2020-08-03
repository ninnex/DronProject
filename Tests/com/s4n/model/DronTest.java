package com.s4n.model;

import org.junit.jupiter.api.Test;

import static com.s4n.util.Constants.orientation.*;
import static org.junit.jupiter.api.Assertions.*;

class DronTest {

    Dron dron = new Dron(0, 0, NORTH);

    @Test
    void getPosition() {
        assertEquals("(0, 0) dirección Norte", dron.getPosition());
    }

    @Test
    void move() {

        dron.move();
        dron.move();
        assertEquals(dron.getX(), 0);
        assertEquals(dron.getY(), 2);
        assertEquals(dron.getO(), NORTH);
    }

    @Test
    void rotate() {
        dron.rotate("D");
        dron.rotate("I");
        dron.rotate("I");
        assertEquals(dron.getX(), 0);
        assertEquals(dron.getY(), 0);
        assertEquals(dron.getO(), WEST);
    }

    @Test
    void rotateClockwise() {
        dron.rotateClockwise();
        assertEquals(dron.getX(), 0);
        assertEquals(dron.getY(), 0);
        assertEquals(dron.getO(), EAST);
    }

    @Test
    void rotateCounterclockwise() {
        dron.rotateCounterclockwise();
        assertEquals(dron.getX(), 0);
        assertEquals(dron.getY(), 0);
        assertEquals(dron.getO(), WEST);
    }

    @Test
    void deliverLunch() {
        dron.deliverLunch();
        assertEquals(1, dron.getLunchNumber());
    }
}