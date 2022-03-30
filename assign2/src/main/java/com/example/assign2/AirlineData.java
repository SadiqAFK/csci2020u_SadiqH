package com.example.assign2;

import java.io.*;
import java.util.ArrayList;

public class AirlineData {
    public static void add_collum(){

        ArrayList<String> data = new ArrayList<>();
        String line = "";
        try {
            FileReader file = new FileReader("./src/main/resources/airline_safety.csv");
            BufferedReader reader = new BufferedReader(file);

            //Read first line to avoid changing headers
            line = reader.readLine();
            line += "," + "incidents_85_14";
            data.add(line);

            //reading through file
            while((line = reader.readLine()) != null){

                String[] seperatedData = line.split(",");
                int incidentTotals = Integer.parseInt(seperatedData[2]) + Integer.parseInt(seperatedData[5]);

                line += "," + Integer.toString(incidentTotals);

                //add line with new collum to database
                data.add(line);



            }

            reader.close();
        }
        catch(Exception e){
            System.out.println(e);
        }

        //Now to rewrite the data to the file with the new collum
        try{
            FileWriter file = new FileWriter("./src/main/resources/Newairline_safety.csv");
            BufferedWriter writer = new BufferedWriter(file);

            for(String row : data){
                writer.write(row);
                writer.newLine();
            }

            writer.close();
        }
        catch(Exception e){
            System.out.println(e);
        }

    }
    public static void main(String[] args) {

        add_collum();
    }
}
