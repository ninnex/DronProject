package com.s4n.business;

import com.s4n.model.Dron;
import com.s4n.util.Constants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlightControllerTest {

    @Test
    void runDron() {
        Dron dron = new Dron(0, 0, Constants.orientation.NORTH);
        FlightController fc = new FlightController();
        fc.runDron(dron, "AAAAIAA ");
        assertEquals(-2, dron.getX());
        assertEquals(4, dron.getY());
        assertEquals(Constants.orientation.NORTH, dron.getO());

    }

    @Test
    void runAllRoutes() {
        Dron dron = new Dron(0, 0, Constants.orientation.NORTH);
        FlightController fc = new FlightController();
        fc.runDron(dron, "AAAAIAA ");
        fc.runDron(dron, "DDDAIAD ");
        fc.runDron(dron, "AAIADAD ");
        assertEquals("(-4, 2) dirección Oriente", dron.getPosition());
    }
}