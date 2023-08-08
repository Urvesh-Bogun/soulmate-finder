import java.util.*;
import java.io.*;

public class SoulmateFinder {
    public static Scanner kbd = new Scanner(System.in);

    //Boolean to check if there is an overlap
    public static boolean overlappingJourneys(int start1, int end1, int start2, int end2) {
        return !(end1 < start2 || end2 < start1);
    }

    //Method to count the number of overlaps
    public static int getPotentialSoulmates(int start, int end, Scanner inputFileScanner) {
        int potentialSoulmates = 0;

        while (inputFileScanner.hasNextLine()) {
            String line = inputFileScanner.nextLine();
            String[] parts = line.split(" ");

            String name = parts[0];
            int boardingStation = Integer.parseInt(parts[1]);
            int exitStation = Integer.parseInt(parts[2]);

            if (end >= boardingStation && exitStation >= start) {
                potentialSoulmates++;
                System.out.println(name + " might be the soulmate.");
            } else {
                System.out.println(name + " is not the soulmate.");
            }
        }

        return potentialSoulmates;
    }

    //Main method that asks for user input to compare with access-log-1.txt
    public static void main(String args[]) {
        try {
            File file = new File("access-log-1.txt");
            Scanner scanner = new Scanner(file);

            System.out.println("Where did your journey start?");
            int start = getInputInt();
            System.out.println("Where did your journey end?");
            int end = getInputInt();

            int potentialSoulmates = getPotentialSoulmates(start, end, scanner);
            System.out.println("Number of potential soulmates: " + potentialSoulmates);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }

    //Method to ensure input is valid
    public static int getInputInt() {
        int input = -1;
        boolean validInput = false;
        
        while (!validInput) {
            try {
                input = kbd.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                kbd.next();
            }
        }
        return input;
    }
}