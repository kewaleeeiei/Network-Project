package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class FileReader {

        public void readFile(String filename){
            try {

                File  myObj = new File ("Network-Project/" + filename);
                Scanner myReader = new Scanner(myObj);
                String filename_ = myObj.getName().replace(".","=");
                System.out.printf("|                    %-41s|\n", "Routing Table in " + filename_.split("=")[0]);
                System.out.println("|   destination subnet   |   next router   |   hops to dest   |");

                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    System.out.printf("|       %-17s|       %-10s|         %-9s|\n", data.split(":")[0],data.split(":")[1],data.split(":")[2]);
                }
                System.out.println("");

                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
//    }
}

