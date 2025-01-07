package opdracht22;
// clearing the console for the manticore hunting
// 25 empty lines.

import java.util.Scanner;

public class Console {
    public static void clear(){
        for (int i = 0; i < 25; i++){
            System.out.println();
        }
    }

    public static int askForNumberInRange(String text, int minRange, int maxRange) {
        // method for asking for number in range
        Scanner myRange = new Scanner(System.in);
        int numberInRange;
        System.out.println(text); // what is the manticore location
        do {
            System.out.println("Enter a number between : " + minRange + "and " + maxRange); // SOUT enter number
            numberInRange = myRange.nextInt(); // next INT = nmber in range
        } while (!(numberInRange <= maxRange && numberInRange >= minRange)); // while maxrange is less than + greater than minRange
        return numberInRange; // give number in range
    }
}
