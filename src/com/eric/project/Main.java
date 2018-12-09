package com.eric.project;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    static ArrayList<WeatherEntry> data = new ArrayList<WeatherEntry>();
    static HashMap<LocalDateTime, WeatherEntry> mapData = new HashMap<>();

    public static void main(String[] args) {

//********************
//Uncomment when ready to receive dates

//*******************
        String[] dates = getInput();
        String pattern = "yyyy-MM-dd HH:mm:ss";
        DateTimeFormatter parser = DateTimeFormatter.ofPattern(pattern);

      //  LocalDateTime beginLDT = LocalDateTime.parse(dates[0], parser);
      //  LocalDateTime endLDT = LocalDateTime.parse(dates[1], parser);

        LocalDateTime beginLDT = LocalDateTime.parse("2012-01-01 00:02:21", parser);
        LocalDateTime endLDT = LocalDateTime.parse("2012-01-02 00:15:43", parser);


        System.out.println(beginLDT + "; " + endLDT);

        // Opens and stores the .txt files data into an array.
        String curDir = System.getProperty("user.dir");
        TextFile txt = new TextFile(curDir);
        String strFiles = txt.getAsString();
        String[] files = strFiles.split(TextFile.getDelimiter());
        try {
            for(int i=0; i<txt.getFiles().length; i++) {
                BufferedReader reader = new BufferedReader(new FileReader(txt.getFiles()[i]));
                String line = reader.readLine();
                while ((line = reader.readLine()) != null) {
                    String[] lineData = line.split("\t");
                    WeatherEntry newEntry = new WeatherEntry(lineData);
                    data.add(newEntry);
                    mapData.put(newEntry.getDateTime(), newEntry);
                }
            }

            // Use binary search to find the beginning and end dates within the array
            boolean begin = false, end = false;
            int beginCount = data.size()/2;
            int endCount = data.size()/2;
            int beginLow = 0, endLow = 0;
            int beginHigh = data.size(), endHigh = data.size();

            System.out.println(data.get(beginCount).getDateTime().compareTo(beginLDT));
            System.out.println(data.get(beginCount).getDateTime());

            // The recorded times most likely wont match the requested times.  Need to find the
            //      best possible match to the closest times.  Otherwise this will loop forever
            //      Try comparing from date to hour to minute to second.  Then take closest match
            while ( !(begin && end) ) {
                if (!begin) {
                    int match = data.get(beginCount).getDateTime().compareTo(beginLDT);

                    if (match > 0) {
                       // Current position is greater than input.  Move down.
                        beginHigh = beginCount;
                        beginCount = beginCount - ((beginCount - beginLow) / 2);
                    }
                    else if(data.get(beginCount).getDateTime().compareTo(beginLDT) < 0) {
                        // Current position is less than input.  Move up.
                        beginLow = beginCount;
                        beginCount = ((beginHigh - beginCount) / 2) + beginCount;
                    }
                    else {
                        begin = true;
                    }
                    if (beginHigh == beginLow) {
                        // check if the input is higher/lower than the requested spot
                        if (data.get(beginHigh).getDateTime().compareTo(beginLDT) < 0) {
                            beginCount++;
                            begin = true;
                        }
                    }
                }
                if (!end) {
                    int ret = data.get(endCount).getDateTime().compareTo(endLDT);

                    if (data.get(endCount).getDateTime().compareTo(endLDT) > 0) {
                        endHigh = endCount;
                        endCount = endCount - ((endCount - endLow) / 2);
                    }
                    else if(data.get(endCount).getDateTime().compareTo(endLDT) < 0) {
                        endLow = endCount;
                        endCount = ((endHigh - endCount) / 2) + endCount;
                    }
                    else {
                        end = true;
                    }
                    if (endHigh == endLow) {
                        // check if the input is higher/lower than the requested spot
                        if (data.get(endHigh).getDateTime().compareTo(endLDT) > 0) {
                            endCount--;
                            end = true;
                        }
                    }
                }
                System.out.println("Begin Index: " + beginCount + "\t" + "End Index: " + endCount);
            }

            // Calculate the barometric trend over the period


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static String[] getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the BEGIN date and time in format (yyyy-MM-dd HH:mm:ss): ");
        String begin = scanner.nextLine();

        System.out.print("Please enter the END date and time in format (yyyy-MM-dd HH:mm:ss): ");
        String end = scanner.nextLine();

        return new String[]{begin, end};
    }
}
