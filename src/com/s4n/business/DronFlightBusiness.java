package com.s4n.business;

import com.s4n.model.Dron;
import com.s4n.util.Constants;

public class DronFlightBusiness {


    public void runDron(Dron dron, String route){


        if(dron.getLunchNumber() >= Constants.MAX_LUNCH_CAPACITY){
            dron.setX(0);
            dron.setY(0);
            dron.setLunchNumber(0);
            dron.setO(Constants.orientation.NORTH);
        }


        for (int i = 0; i < route.length(); i++) {

            char action = route.charAt(i);

            if( action == 'A')
                dron.move();
            if( action == 'D')
                dron.rotateClockwise();
            if( action == 'I')
                dron.rotateCounterclockwise();


        }

        dron.deliverLunch();


    }


}
