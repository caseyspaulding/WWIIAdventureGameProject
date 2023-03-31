package com.skillstorm.game;
import java.util.Scanner;

import static com.skillstorm.game.WWIIAdventureGame.main;

public class USArmyScene extends Scene {
    public USArmyScene() {
        super("You are in a forest. What do you want to do?");
    }

    @Override
    public void play(Player player) {
        System.out.println(getDescription());
        USArmyPlayer armyPlayer = (USArmyPlayer) player;
        Scanner scanner = new Scanner(System.in);
        int choice;
        boolean playerWon = false;
        do {
            System.out.println("");
            System.out.println("1. Search for enemy soldiers");
            System.out.println("2. Set up camp");
            System.out.println("3. Advance forward");
            System.out.println("");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("");
                    System.out.println("You search for enemy soldiers and engage in a firefight.");
                    System.out.println("");
                    armyPlayer.decreaseHealth(20);
                    armyPlayer.decreaseAmmo(50);
                    System.out.println("You find a map on one of the enemy soldiers. The map leads to a hidden enemy stronghold.");
                    System.out.println("Do you want to:");
                    System.out.println("1. Follow the map to the enemy stronghold");
                    System.out.println("2. Return to base");
                    int subChoice = scanner.nextInt();
                    scanner.nextLine();
                    if (subChoice == 1) {

                        System.out.println("");
                        System.out.println("You follow the map to the enemy stronghold and successfully infiltrate it.");
                        System.out.println("*********************************************************");
                        System.out.println("Congratulations, Soldier! You win!");
                        System.out.println("*********************************************************");

                        playerWon = true;
                        System.out.println("");
                        System.out.println("Would you like to play again?");
                        System.out.println("1. Yes");
                        System.out.println("2. No");
                        int playAgainChoice = scanner.nextInt();
                        scanner.nextLine();
                        if (playAgainChoice == 1) {
                            // restart game
                            main(new String[]{});
                        } else {
                            // end game
                            System.exit(0);
                        }
                    } else if (subChoice == 2) {
                        System.out.println("");
                        System.out.println("You return to base to regroup with your fellow soldiers.");
                    } else {
                        System.out.println("Invalid choice. Please try again.");
                    }
                    break;
                case 2:
                    System.out.println("");
                    System.out.println("You set up camp and rest for the night.");
                    armyPlayer.increaseHealth(20);
                    armyPlayer.increaseSupplies(5);
                    break;
                case 3:
                    System.out.println("");
                    System.out.println("You advance forward, ready for any potential enemies.");
                    armyPlayer.increaseGold(20);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice < 1 || choice > 3); // exit loop if player won
    }

    @Override
    public int getNextSceneIndex() {

        return 1; // return index of the next scene
    }
}
