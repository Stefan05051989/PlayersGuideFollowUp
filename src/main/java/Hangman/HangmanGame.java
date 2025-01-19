package Hangman;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

// onderaan de code zijn alle learning subjects uitgelicht welke stof ik heb geleerd en gevonden via verschillende wegen.

public class HangmanGame extends LibraryHangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // String filePath code: implementeert de file, van de library die zojuist is aangemaakt als text bestand.
        String filePath = "src/main/java/Hangman/Library.txt";
        // Wanneer toegevoegd vanuit map zelf deed deze het niet, rechtermuisknop en verschillende
        // opties proberen voor copy- paste: Path From Content Root was de juiste.
        // Plaats ieder woord in een arraylist, zodoende kan het bestand de regels 1 voor 1 lezen
        ArrayList<String> words = new ArrayList<>();
        // Buffered reader on its own can't read files, so it needs new FileReader(filepath) to identity the words in the document
        // filePath geeft aan FileNotFoundException, deze moet doorgezet worden naar de catch + e
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            // reader optie geeft een woord per keer lijn voor lijn
            // als de regels op zijn, geeft "reader.readLine()" null terug
            // while : de waarde die terug gegeven wordt, niet hetzelfde is als null (!= null) geeft die altijd wat terug.
            while ((line = reader.readLine()) != null) {
                // words.add selecteert een woord per (line), de trim optie zorgt ervoor dat er geen whitespace
                // wordt toegevoegd aan het te raden woord (die trimt ze.)
                words.add(line.trim());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not find file. ");
        } catch (IOException e) {
            System.out.println("Something went wrong. ");
        }
        Random random = new Random();
        String word = words.get(random.nextInt(words.size()));

        ArrayList<Character> wordToGuess = new ArrayList<>();
        // wordState is een ArrayList gemaakt van characters
        int wrongGuesses = 0;
        for (int i = 0; i < word.length(); i++) {
            wordToGuess.add('_');
        }
        System.out.println("Welcome to Hangman! ");
        System.out.println("___________________");

        while (wrongGuesses < 7) {
            System.out.print(getHangmanArt(wrongGuesses));
            System.out.println("Word: ");
            for (char character : wordToGuess) { // char = character om te raden :
                System.out.print(character + " "); // character te raden + (spatie) = 5 underscores en 5 spaties ipv komma's
            }
            System.out.println();

            System.out.print("Guess a letter : ");
            char guess = scanner.next().toLowerCase().charAt(0);

            if (word.indexOf(guess) >= 0) {
                System.out.println("You guessed correct! ");
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == guess) {
                        wordToGuess.set(i, guess);
                    }
                }
                if (!wordToGuess.contains('_')) {
                    System.out.println(getHangmanArt(wrongGuesses));
                    System.out.println("You Win! ");
                    System.out.println("The word was: " + wordToGuess);
                    break;
                }
            } else {
                wrongGuesses++;
                System.out.println("Wrong! Guess again : ");
            }
        }
        // buiten de while loop:
        if (wrongGuesses >= 7) {
            System.out.print(getHangmanArt(wrongGuesses));
            System.out.println("Game Over!!! ");
            System.out.println("The word was : " + word);
        }

        scanner.close();
    }
    static String getHangmanArt(int wrongGuesses){
        return switch (wrongGuesses) { // case 0 (! -> !) -> betekent : doe dit!
            case 0 -> """



                    """;
            case 1 -> """
                     O


                    """;
            case 2 -> """
                     O
                     |


                    """;
            case 3 -> """
                     O
                     |


                    """;
            case 4 -> """
                     O
                    /|


                    """;
            case 5 -> """
                     O
                    /|\\
                    

                    """;
            case 6 -> """

                     O
                    /|\\
                    / 
                    """;
            case 7 -> """

                     O
                    /|\\
                    / \\
                    """ + "\nYou're Dead!!";
            default -> "";

        };
    }
}

// Learning methods from this assignment :
// -------
/* in case 4, wordt de rechterarm gemarkeerd door dubbel backslash omdat een enkele een escape-sequence is.
            Alle escape sequences :
            \t = insert tab;
            \b insert backspace
            \n inserts a newline
            \r carriage return. ()
            \f form feed
            \' inserts a single quote
            \"inserts a double quote
            \\ inserts a backslash

            example :

                     O
                    /|\\
                    / \\
                    """ + "\nYou're Dead!!";
            """(empty string) +"\n(new line)You're Dead!!
--------------

char guess = scanner.next().toLowerCase().charAt(0);
variabel guess = letter
scanner.next = next zorgt voor de volgende string, maar deze wordt zo omgezet naar een char als laatste stap
"scanner.next().toLowerCase = een method chain, deze bind meerdere methodes aan elkaar
to-lowercase is om hoofdletters om te zetten naar kleine letters
.toLowercase().chatAt(0) is een chain die een string omzet naar char.





_______________________________________________________
Deze code voegt alle characters toe aan een:arraylist

ArrayList<Character> wordToGuess = new ArrayList<>();
        // wordState is een ArrayList gemaakt van characters
______________________________________________________
// String filePath code: implements the file, from the library that we made as a text file.
        String filePath = "src/main/java/Hangman/Library.txt";
        // wanneer toegevoegd vanuit map zelf deed deze het niet, rechtermuisknop en verschillende
        // opties proberen voor copy-paste Path From Content Root was de juiste.
        -
        // place every word in an arraylist, so that the it can read it 1 by 1, per line!
        Meaning: if there are 2 words on the same line, it will not compile or if wil place them both in hangman
        ArrayList<String> words = new ArrayList<>();

        // Buffered reader can't read files on it's own, it needs (new FileReader) to help it read the document
        // filePath geeft aan FileNotFoundException, deze moet doorgezet worden naar de catch + e
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            // reader optie geeft een woord per keer lijn voor lijn
            // als de regels op zijn, geeft "reader.readLine()" null terug
            // while : de waarde die terug gegeven wordt, niet hetzelfde is als null (!= null) geeft die altijd wat terug.
            While ((line = reader.readLine()) != null) {
                // words.add selecteert een woord per (line), de trim optie zorgt ervoor dat er geen whitespace
                //wordt toegevoegd aan het te raden woord (die trimt ze.)
                words.add(line.trim());
 */