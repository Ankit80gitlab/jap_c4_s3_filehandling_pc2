package com.jap.salesanalyzer;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;

/**
This class performs the file reading and stores the data in SalesRecord array
 */
public class SalesAnalysis {
    // This method reads a file and returns the count of lines in the file
    // omit any headers present in the file

     public int countOfSalesRecords(String fileName){

         int recordCount=-1;
         try {
             File file = new File(fileName);
             FileReader reader = new FileReader(file);
             BufferedReader buffer = new BufferedReader(reader);

             // declaring variables
             String str1 = "";
             String str;

             // implementation
             while ((str = buffer.readLine()) != null) {
                 str1 = str1 + str + "@";
                 recordCount++;
             }
         }
         catch (IOException e)
         {
             System.out.println("File not found");
         }

        return recordCount;
    }

    // This method reads a file and adds each line of the file into the corresponding SalesRecord object
    public SalesRecord[] readRecords(String fileName,int recordCount) throws ParseException {

        SalesRecord[] data = new SalesRecord[recordCount];

        try {
            File file = new File(fileName);
            FileReader reader = new FileReader(file);
            BufferedReader buffer = new BufferedReader(reader);

            // declaring variables
            String str1 = "";
            String str;
            int count1 = 0;

            // implementation
            while ((str = buffer.readLine()) != null) {
                str1 = str1 + str + "@";
                count1++;
            }

            // splitting by @ separator
            String[] splitArray = str1.split("@");
            for (int i = 0; i < data.length; i++) {
                String[] array2 = splitArray[1].split(",");


                //Date date1 = new Date(array2[0]);
                String dt = array2[0];
                Date date1 = new SimpleDateFormat("dd/MM/yy").parse(dt);
                //String d1 = array2[0];

                //DateFormat format = new SimpleDateFormat("dd/MM/yy");

                data[i] = new SalesRecord(date1 , Integer.parseInt(array2[1]), Integer.parseInt(array2[2]),
                        array2[3], Double.parseDouble(array2[4]), Double.parseDouble(array2[5]), Integer.parseInt(array2[6]));
            }
            //SalesRecord[] data = new SalesRecord[count1];

            SalesRecord[] salesData = null;
            return data;
        }
        catch (IOException e)
        {
            System.out.println("File not found");
        }
        return data;
    }


    public static void main(String[] args) throws ParseException{
        SalesAnalysis salesAnalysis = new SalesAnalysis();
        // read the file purchase_details.csv
        String fileName = "src/main/resources/purchase_details.csv";
        // the count of lines in the file
        int count = 0;

        salesAnalysis.readRecords(fileName,0);
        //array to hold the sales records
        SalesRecord[] salesRecords = null;


       // display the records that have been read from the file
        SalesRecord sales = new SalesRecord(new Date(),34138,506,"paypal",
                56.04,17,10);
        System.out.println(sales.toString());
    }
}
