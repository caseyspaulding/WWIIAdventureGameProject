package com.skillstorm.game;

import java.util.Scanner;

import static com.skillstorm.game.WWIIAdventureGame.main;

public class USMarineScene extends Scene {
    public USMarineScene() {
        super("You are on a beach in Iwo Jima. What do you want to do?");
    }

    @Override
    public void play(Player player) {
        System.out.println(getDescription());
        USMarinePlayer marinePlayer = (USMarinePlayer) player;
        Scanner scanner = new Scanner(System.in);
        int choice;
        boolean playerWon = false; // flag to indicate if player has won
        do {
            System.out.println("");
            System.out.println("1. Search for enemy soldiers");
            System.out.println("2. Build fortifications");
            System.out.println("3. Advance forward");
            System.out.println("");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character
            switch (choice) {
                case 1:
                    System.out.println("");
                    System.out.println("You search for enemy soldiers and engage in a firefight.");
                    System.out.println("");
                    marinePlayer.decreaseHealth(20);
                    marinePlayer.decreaseAmmo(50);
                    System.out.println("You find a map on one of the enemy soldiers. The map leads to a hidden enemy bunker.");
                    System.out.println("Do you want to:");
                    System.out.println("");
                    System.out.println("1. Follow the map to the enemy bunker");
                    System.out.println("2. Stay put and defend your position");
                    int subChoice = scanner.nextInt();
                    scanner.nextLine(); // consume the newline character
                    if (subChoice == 1) {
                        System.out.println("");
                        System.out.println("You follow the map to the enemy bunker and successfully infiltrate it.");
                        System.out.println("");
                        System.out.println("*********************************************************");
                        System.out.println("Congratulations, Marine! You captured the Beach! You win!");
                        System.out.println("*********************************************************");
                        playerWon = true; // set flag to true
                        System.out.println("");
                        System.out.println("Would you like to play again?");
                        System.out.println("1. Yes");
                        System.out.println("2. No");
                        int playAgainChoice = scanner.nextInt();
                        scanner.nextLine(); // consume the newline character
                        if (playAgainChoice == 1) {
                            // restart game
                            main(new String[]{});
                        } else {
                            // end game
                            System.exit(0);
                        }
                    } else if (subChoice == 2) {
                        System.out.println("You stay put and defend your position.");
                    } else {
                        System.out.println("Invalid choice. Please try again.");
                    }
                    break;
                case 2:
                    System.out.println("");
                    System.out.println("You build fortifications to protect your position.");
                    marinePlayer.increaseHealth(20);
                    marinePlayer.increaseSupplies(5);
                    break;
                case 3:
                    System.out.println("");
                    System.out.println("You advance forward, ready for any potential enemies.");
                    marinePlayer.increaseGold(20);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice < 1 || choice > 3 && !playerWon); // exit loop if player won
    }

    @Override
    public int getNextSceneIndex() {
        return 1; // return index of the next scene
    }
}
