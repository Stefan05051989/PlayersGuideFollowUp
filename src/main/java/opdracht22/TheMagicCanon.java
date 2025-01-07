package opdracht22;

/*
Every third turn of a crank, the fire gem activates, and the cannon
produces a fire blast. The electric gem activates every fifth turn of the crank, and the cannon makes an
electric blast. When the two line up, it generates a potent combined blast.
- Write a program that will loop through the values between 1 and 100 and display what kind of blast
the crew should expect. (The % operator may be of use.)
- Change the color of the output based on the type of blast. (For example, red for Fire, yellow for
Electric, and blue for Electric and Fire).
Red : public static final String RED_BOLD = "\033[1;31m";
 - System.out.println(RED_BOLD + "(" + row + ", " + (col+1) + ")" + Reset);
Yellow : public static final String YELLOW_BOLD = "\033[1;33m";
Blue :public static final String BLUE_BOLD = "\033[1;34m";
Reset : public static final String RESET = "\033[0m";

met modulo kunnen we toetsen of een waarde deelbaar is door een andere waarde.
in dit geval : als i = 5, is i % (modulo) 5 gelijk aan 0 (de restwaarde)
restwaarde over : officieel niet deelbaar.
 */

public class TheMagicCanon {

    public int fire(int index) {
        if (index % 3 == 0 && index % 5 == 0) {
            System.out.println(colours.BLUE_BOLD_BRIGHT + "dikkecomboraketjongeuh" + colours.RESET);
            return 10;
        } else if (index % 3 == 0) {
            System.out.println(colours.RED_UNDERLINED + "vuurkanon" + colours.RESET);
            return 3;
        } else if (index % 5 == 0) {
            System.out.println(colours.YELLOW_BOLD + "electrischkanon" + colours.RESET);
            return 5;
        } else {
            System.out.println("normaal kanon");
            return 1;
        }
    }
}

