package com.company;

import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);

        System.out.println("Hello! What's your name? ");
        String name = sn.nextLine();

        Scanner scale = new Scanner(System.in);

        System.out.println("\nHow many kilograms do you currently weigh " + name + "?\n[We use this to track your progress]");

        int weight = scale.nextInt();

        final LocalDate date = LocalDate.now();
        // Set format to month/day/year
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd yyyy");
        final String todaysDate = date.format(formatter);

        System.out.println("\nHello " + name + ", Today's date is: " + todaysDate + " and you currently weigh " + weight + " kg.");

        final List<String> workoutList = new ArrayList<>();

        workoutList.add("Bench Press");
        workoutList.add("Squats");
        workoutList.add("Deadlift");
        workoutList.add("Curls");
        workoutList.add("Push Ups");
        workoutList.add("Pull Ups");
        workoutList.add("Calf Raises");

        Scanner sn2 = new Scanner(System.in);

        System.out.println("\n" + name + ", would you like to workout today? (yes/no)");
        String response = sn2.next();

        if(response.equals("yes") || response.equals("Yes")) {
            System.out.println("\nHere are a list of workouts![7 in total] " + "\n" + workoutList);
        }
        else {
            System.out.println("Have a nice day " + name + "." );

            System.exit(1);
        }

        Scanner sn3 = new Scanner(System.in);

        System.out.println("\nSelect the amount of workouts you will be doing and list them below: ");

        String[] string = new String [sn3.nextInt()];
        //consuming the <enter> from input above
        sn3.nextLine();
        for (int i = 0; i < string.length; i++)
        {
            string[i] = sn3.nextLine();
        }
        System.out.println("\nYou will be doing the following: ");
        //for-each loop to print the string
        for(String str: string)
        {
            System.out.println(str);
        }

        Scanner sn4 = new Scanner(System.in);

        System.out.println("\nSelect your difficulty: Easy or Advanced: ");
        String response2 = sn4.next();
        if(response2.equals("Easy") || response2.equals("easy")) {

            System.out.println("\nWe recommend 3 sets of 8 reps for each workout.");

        } else {

            System.out.println("\nOh " + name + ", you are a bold one!\n\nWe recommend 5 sets of 10 reps for each workout!");
        }


        Scanner sn5 = new Scanner(System.in);

        System.out.println("\n\nAre you ready to begin your selected workout? (Type Yes when you are ready!)");
        String response3 = sn5.next();
        if(response3.equals("Yes") || response3.equals("yes")) {
            System.out.println("\n[Starting weight: " + weight + "]");
            System.out.println("\nStart the stopwatch when you are ready to begin!)");
        } else {
            System.out.println("Have a good day " + name);
            System.exit(1);
        }

        Stopwatch stopwatch = new Stopwatch();

        Scanner nxt = new Scanner(System.in);
        System.out.println("\nPress 0 to complete current workout.");
        String response9= nxt.next();
        if(response9.equals("0")) {
            Scanner sn6 = new Scanner(System.in);

            System.out.println("\nAs part of our service, we are going to provide you with a meal plan! \n\n[Type OK to continue]");
            String response4 = sn6.next();
            if(response4.equals("OK") || response4.equals("ok") || response4.equals("Ok") || response4.equals("oK")) {

            } else {
                System.out.println("Invalid input");
                System.exit(1);
            }
            //creating file
            try{
                FileWriter writer = new FileWriter("MealPlan.txt");
                writer.write("\nBreakfast:\n---------- \n2 Large Scrambled Eggs - 203 calories (12 grams of protein)\nNon-Fat Plain Greek yoghurt - 80 calories (13 grams of protein)\nWhole Grain Pancake - 78 calories (6 grams of protein) \n\nLunch/Dinner:\n--------------\n100 grams of White Rice - 130 calories (2.7 grams of protein)\nGrilled Chicken Breast - 284 calories per piece (54 grams of protein)\n100 grams of Pasta - 131 calories (5 grams of protein)\n100g of Grilled Salmon - 171 calories (23 grams of protein)\n100g of Roasted Potatoes - 93 grams (2.5 grams of protein)");
                writer.append("\n[Meal Plan provided by System]");
                writer.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }

            try{
                FileReader reader = new FileReader("MealPlan.txt");
                int data = reader.read();
                while(data != -1) {
                    System.out.print((char)data);
                    data = reader.read();
                }
                reader.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }




    }
}




