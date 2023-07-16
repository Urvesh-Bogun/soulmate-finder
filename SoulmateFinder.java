import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class SoulmateFinder
{
    public static Scanner kbd = new Scanner(System.in);

    public static boolean overlappingJourneys(int s1, int e1, int s2, int e2)
    {
        if (e1 < s2 || e2 < s1)
        {
            return false;
        }
        else if (e1 == s2)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    public static int getTravellers(int start, int end)
    {
        System.out.println("Enter the overall number of travellers on the train: ");
        int noOfTravellers = kbd.nextInt();
        int noOfPotentialSoulmates = 0;
        for( int i = 0; i < noOfTravellers ; i ++)
        {
            System.out.println("Enter the traveller's name: ");
            String name = kbd.next();
            System.out.println("Enter the boarding station: ");
            int boardingStation = kbd.nextInt();
            System.out.println("Enter the exit station: ");
            int exitStation = kbd.nextInt();
            
            if (!(end < boardingStation || exitStation < start || end == boardingStation))
            {
                noOfPotentialSoulmates ++;
                System.out.println(name + " might be the soulmate.");
            }
            else
            {
                System.out.println(name + " is not the soulmate.");
            }
        }
        return noOfPotentialSoulmates;
    }
    
    public static void main(String args[])
    {
        System.out.println("Where did your journey start?");
        int start = kbd.nextInt();
        System.out.println("Where did your journey end?");
        int end = kbd.nextInt();
        System.out.println("Number of potential soulmates: " + getTravellers(start, end));
    }   
    
    public static boolean overlappingLongJourneys(int Q4S1, int Q4E1,int Q4S2,int Q4E2,int n)
    {
        boolean overlap;
        if(n <= (Q4E2-Q4S2))
        {
            overlap = true;
        }
        else
        {
            overlap = false;
        }
        return overlap;
    } 
}