package com.skillstorm.game;
import java.util.Scanner;

public class USNavyScene extends Scene {

    public USNavyScene() {

        super("You are on a US Navy ship in Pearl Harbor. What do you want to do?");
    }

    @Override
    public void play(Player player) {
        System.out.println("You have chosen the U.S. Navy!" );
        System.out.println("Current status");
        System.out.println("score: " + player.health + " health, " + player.supplies + " supplies, " + player.gold + " gold");
        System.out.println(getDescription());

        USNavyPlayer navyPlayer = (USNavyPlayer) player;

        Scanner scanner = new Scanner(System.in);

        int choice;

        boolean playerWon = false; // flag to indicate if player has won

        do {
            System.out.println("1. Search for enemy ships");
            System.out.println("2. Repair damaged ship components");
            System.out.println("3. Practice drills with the crew");
            System.out.println("");
            System.out.print("Enter your choice: ");
            System.out.println("");

            choice = scanner.nextInt();

            scanner.nextLine(); // consume the newline character

            switch (choice) {
                case 1:
                    System.out.println("");
                    System.out.println("You search for enemy ships using the ship's radar system. You detect an incoming wave of enemy planes and engage in air combat.");
                    System.out.println("You successfully shoot down all enemy planes and defend your ship.");
                    System.out.println("");
                    navyPlayer.decreaseHealth(20);
                    navyPlayer.decreaseAmmo(50);
                    System.out.println("");
                    System.out.println("*********************************************************");
                    System.out.println("Congratulations, Sailor, You win!");
                    System.out.println("*********************************************************");
                    System.out.println("");

                    System.out.println("Score: " + navyPlayer.getHealth() + " health, " + navyPlayer.getAmmo() + " ammo, " + navyPlayer.getGold() + " gold, " + navyPlayer.getSupplies() + " supplies, " + navyPlayer.getShipCondition() + " ship condition");
                    playerWon = true; // set flag to true

                    System.out.println("");
                    System.out.println("Would you like to play again in a different branch of the military?");
                    System.out.println("");
                    System.out.println("1. Yes");
                    System.out.println("2. No");

                    int playAgainChoice = scanner.nextInt();
                    scanner.nextLine(); // consume the newline character
                    if (playAgainChoice == 1) {
                        // restart game
                        WWIIAdventureGame.main(new String[]{});
                    } else {
                        // end game
                        System.exit(0);
                    }
                    break;
                case 2:
                    System.out.println("");
                    System.out.println("You repair damaged ship components and ensure the ship is in top condition for any potential battles.");
                    navyPlayer.increaseShipCondition(10);
                    navyPlayer.increaseSupplies(5);
                    break;
                case 3:
                    System.out.println("");
                    System.out.println("You practice drills with the crew to improve their readiness for battle.");
                    navyPlayer.increaseGold(20);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice < 1 || choice > 3 && !playerWon); // exit loop if player won
    }

    @Override
    public int getNextSceneIndex() {
        return 2; // return index of the next scene
    }
}
