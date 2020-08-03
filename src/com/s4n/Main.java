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

            Scanner psc = new Scanner(new File("conf.properties"));
            String conf = psc.nextLine();
            String v[] = conf.split(",");

            char x = v[0].charAt(0);
            char y = v[1].charAt(0);
            char o = v[2].charAt(0);

            for (String file : Util.getDirectoryFiles()) {

                Scanner sc = new Scanner(new File(file));
                Dron dron = new Dron(0, 0, Constants.orientation.NORTH);

                PrintWriter out = new PrintWriter(new File("files/out/out"+ file.substring(11, 13) + ".txt"));

                while (sc.hasNext()) {


                    String routeLine = sc.nextLine();
                    FlightController fc = new FlightController();

                    System.out.print("\n" + dron.getPosition());

                    fc.runDron(dron, routeLine);
                    System.out.println("   ->  " + dron.getPosition() + " \nlunchs delivered: " + dron.getLunchNumber());

                    if(x != '-')
                        dron.setX(x - '0');
                    if(y != '-')
                        dron.setY(y - '0');
                    if(o != '-')
                        dron.setO(Util.getEnumOrientation(o));

                    out.println(dron.getPosition());

                }

                out.close();


                System.out.println("\n---------------------------------------------");
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
