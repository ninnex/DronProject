package com.s4n;

import com.s4n.business.FlightController;
import com.s4n.model.Dron;
import com.s4n.util.Constants;
import com.s4n.util.Util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        try {


            for (String file : Util.getDirectoryFiles()) {

                Scanner sc = new Scanner(new File(file));
                Dron dron = new Dron();

                PrintWriter out = new PrintWriter(new File("files/out/out"+ file.substring(11, 13) + ".txt"));

                while (sc.hasNext()) {


                    String routeLine = sc.nextLine();
                    FlightController fc = new FlightController();

                    System.out.println("\ninitial -> " + dron.getPosition());

                    fc.runDron(dron, routeLine);
                    System.out.println("end -> " + dron.getPosition() + " lunch: " + dron.getLunchNumber());
                    dron.setO(Constants.orientation.NORTH);

                    out.println(dron.getPosition());

                }

                out.close();


                System.out.println("---------------------");
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
