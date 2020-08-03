package com.s4n;

import com.s4n.business.FlightController;
import com.s4n.model.Dron;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        try {
            Scanner sc = new Scanner(new File("in.txt"));

            Dron dron = new Dron();

            while(sc.hasNext()){


                String routeLine = sc.nextLine();

                FlightController fc = new FlightController();


                System.out.println("\ninitial -> " + dron.getPosition());

                fc.runDron(dron, routeLine);

                System.out.println("end -> " + dron.getPosition());

            }









        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }



    }
}
