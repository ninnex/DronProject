package com.s4n;

import com.s4n.business.DronFlightBusiness;
import com.s4n.business.FileManagmentDronBusiness;
import com.s4n.model.Dron;
import com.s4n.util.Constants;
import com.s4n.util.Util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        FileManagmentDronBusiness fmdron = new FileManagmentDronBusiness();

        try {


            fmdron.processDronFiles();



        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
