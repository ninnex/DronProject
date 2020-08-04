package com.s4n.business;

import com.s4n.model.Dron;
import com.s4n.util.Constants;
import com.s4n.util.Util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManagmentDronBusiness {

    public void processDronFiles() throws InterruptedException, FileNotFoundException {


        // Loading properties file to set the dron fist position. Example (0, 0, N)
        Scanner psc = new Scanner(new File("conf.properties"));
        String conf = psc.nextLine();


        String v[] = conf.split(",");
        char x = v[0].charAt(0);
        char y = v[1].charAt(0);
        char o = v[2].charAt(0);


        List<Thread> tl = new ArrayList<>();

        for (String file : Util.getDirectoryFiles()) {

            Thread td = new Thread(new Runnable() {
                @Override
                public void run() {


                    try {
                        Scanner sc = new Scanner(new File(file));

                        Dron dron = new Dron(0, 0, Constants.orientation.NORTH);

                        //Preparing the output files
                        PrintWriter out = new PrintWriter(new File("files/out/out" + file.substring(11, 13) + ".txt"));

                        while (sc.hasNext()) {


                            String routeLine = sc.nextLine();
                            DronFlightBusiness fc = new DronFlightBusiness();

                            System.out.print("\n" + dron.getPosition());

                            fc.runDron(dron, routeLine);
                            System.out.println("   ->  " + dron.getPosition() + " \nlunchs delivered: " + dron.getLunchNumber());

                            if (x != '-')
                                dron.setX(x - '0');
                            if (y != '-')
                                dron.setY(y - '0');
                            if (o != '-')
                                dron.setO(Util.getEnumOrientation(o));


                                out.println(dron.getPosition());

                        }

                        out.close();


                        System.out.println("\n---------------------------------------------");
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }

                }
            });


            td.setName(file.substring(file.length() - 8));
            tl.add(td);


        }


        for (Thread thread : tl) {
            System.out.println(thread);
            thread.start();

        }


    }
}
