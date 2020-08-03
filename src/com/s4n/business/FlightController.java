package com.s4n.business;

import com.s4n.model.Dron;

public class FlightController {


    public void runDron(Dron dron, String route){

        for (int i = 0; i < route.length(); i++) {

            char action = route.charAt(i);

            if( action == 'A')
                dron.move();
            if( action == 'D')
                dron.rotateClockwise();
            if( action == 'I')
                dron.rotateCounterclockwise();


        }


    }


}
