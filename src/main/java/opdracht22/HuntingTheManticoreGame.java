package opdracht22;

public class HuntingTheManticoreGame {

    public void run() {
        // player 1 sets location by askForNumberInRange method
        int manticoreLocation = Console.askForNumberInRange("Player 1, What is The Manticore's location? ", 0, 100);
        // clear (later, import method as stated in project
        Console.clear();

        // round variable and health index
        int round = 1;
        int manticoreHealth = 10;
        int cityHealth = 15;
        boolean playing = true;
        TheMagicCanon canon = new TheMagicCanon();

        do {
            showStatus(round, manticoreHealth, cityHealth);
            System.out.println("Player 2, your turn");
            int target = Console.askForNumberInRange("Guess the location of the Manticore", 0, 100);

            if (target < manticoreLocation) {
                System.out.println("Too short, guess again");
                cityHealth -= 1;
            } else if (target > manticoreLocation) {
                System.out.println("too far! guess again");
                cityHealth -= 1;
            } else {
                System.out.println("HEADSHOT! ");
                int damage = canon.fire(round);
                manticoreHealth -= damage;
                System.out.println(damage);
                // optioneel inline : manticoreHealth -= canon.fire(round);
            }
            if(manticoreHealth <= 0){
                System.out.println("You won");
                playing = false;
            } else if (cityHealth <= 0) {
                System.out.println("you lose! ");
                playing = false;
            }
            round++;
        } while (playing);
    }

    private void showStatus(int round, int manticoreHealth, int cityHealth) {
        System.out.println("round : " + round);
        System.out.println("Cityhealth : " + cityHealth);
        System.out.println("Manticorehealth : " + manticoreHealth);
    }
}

