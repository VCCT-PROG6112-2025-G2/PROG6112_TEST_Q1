package prog6112_q1_test;

import java.util.Scanner;

public class SACricketerApplication {

    // columns and rows for the 2D array
    private static final String[] BATSMEN = {
        "Jacques Kallis",
        "Hashim Amla",      
        "AB de Villiers"
    };

    private static final String[] STADIUMS = {
        "Kingsmead",
        "St Georges",
        "Wanderers"
    };

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // rows = stadiums, cols = batsmen
        int[][] runs = new int[STADIUMS.length][BATSMEN.length];

        System.out.println("SA CRICKETER APPLICATION");
        System.out.println("------------------------------------------------------------");
        System.out.println();

       
        for (int s = 0; s < STADIUMS.length; s++) {
            for (int b = 0; b < BATSMEN.length; b++) {
                runs[s][b] = promptForNonNegativeInt(
                    in,
                    "Enter the number of runs scored by " + BATSMEN[b] + " at " + STADIUMS[s] + ": "
                );
            }
        }

        // ===== REPORTS ===== //
        System.out.println("------------------------------------------------------------");
        System.out.println("\nRuns Scored Report");
        System.out.println("------------------------------------------------------------");
        
        for (int b = 0; b < BATSMEN.length; b++) {
            for (int s = 0; s < STADIUMS.length; s++) {
                System.out.println(BATSMEN[b] + " runs scored at " + STADIUMS[s] + " = " + runs[s][b]);
            }
            System.out.println(); // spacing
        }

      

        // Totals per stadium 
        int[] stadiumTotals = computeStadiumTotals(runs);
                System.out.println("------------------------------------------------------------");
                System.out.println("\nTotal Runs at Stadiums");
                System.out.println("------------------------------------------------------------");
        for (int s = 0; s < STADIUMS.length; s++) {
            System.out.println(STADIUMS[s] + " = " + stadiumTotals[s]);
        }

       

        // Stadium with the most runs 
        int maxStadiumIndex = 0;
        for (int s = 1; s < STADIUMS.length; s++) {
            if (stadiumTotals[s] > stadiumTotals[maxStadiumIndex]) {
                maxStadiumIndex = s;
            }
        }
        System.out.println("\nStadium with the most runs : " +
                STADIUMS[maxStadiumIndex]);
        System.out.println("------------------------------------------------------------");
        in.close();
    }

 

    // Prompt user until  valid 
    private static int promptForNonNegativeInt(Scanner in, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (in.hasNextInt()) {
                int value = in.nextInt();
                if (value >= 0) return value;
                System.out.println("Please enter a non-negative integer.");
            } else {
                System.out.println("Invalid input. Please enter an integer number.");
                in.next(); // clear invalid token
            }
        }
    }

    //  totals per batsman
    private static int[] computeBatsmanTotals(int[][] runs) {
        int batsmen = runs[0].length;
        int stadiums = runs.length;
        int[] totals = new int[batsmen];

        for (int b = 0; b < batsmen; b++) {
            int sum = 0;
            for (int s = 0; s < stadiums; s++) {
                sum += runs[s][b];
            }
            totals[b] = sum;
        }
        return totals;
    }

    //totals per stadium
    private static int[] computeStadiumTotals(int[][] runs) {
        int stadiums = runs.length;
        int batsmen = runs[0].length;
        int[] totals = new int[stadiums];

        for (int s = 0; s < stadiums; s++) {
            int sum = 0;
            for (int b = 0; b < batsmen; b++) {
                sum += runs[s][b];
            }
            totals[s] = sum;
        }
        return totals;
    }
}