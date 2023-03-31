// Name: Casey Spaulding
// Date: 3/30/2023

// Assignment: WW2 Adventure Game
// Instructor: Miles Mixon
// Class: SkillStorm Java
// Description: This is a text-based adventure game where the player chooses a character type and then plays through a series of scenes.

// This is the main class for the game. It is responsible for creating the player and scenes.
// It also contains the main game loop.


package com.skillstorm.game;
import java.util.Scanner;

public class WWIIAdventureGame {
    private Player player;
    private Scene[] scenes;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name: Casey Spaulding");
        System.out.println();
        System.out.println("Assignment: WW2 Adventure Game");
        System.out.println("Class: SkillStorm Java");
        System.out.println("__________________________________________________________");
        System.out.println();
        System.out.println("Welcome to the WW2 Adventure Game!");
        System.out.println();
        System.out.println("Please enter your name:");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");
        System.out.println("");

        boolean playAgain = true;
        while (playAgain) {
            System.out.println("----------------------------------");
            System.out.println("Time to join the fight. Choose your military branch:");
            System.out.println("");
            System.out.println("1. US Army");
            System.out.println("2. US Navy");
            System.out.println("3. US Marines");
            int choice = scanner.nextInt();
            Player player;
            switch (choice) {
                case 1:
                    player = new USArmyPlayer();
                    break;
                case 2:
                    player = new USNavyPlayer();
                    break;
                case 3:
                    player = new USMarinePlayer();
                    break;
                default:
                    System.out.println("Invalid choice. Exiting game.");
                    return;
            }
            System.out.println("Welcome, " + player.getName() +"!");
            System.out.println("");
            Scene[] scenes;
            switch (choice) {
                case 1:
                    scenes = new Scene[] {
                            new USArmyScene(),
                            new USArmyScene(),
                            new USArmyScene()
                    };
                    break;
                case 2:
                    scenes = new Scene[] {
                            new USNavyScene(),
                            new USNavyScene(),
                            new USNavyScene()
                    };
                    break;
                case 3:
                    scenes = new Scene[] {
                            new USMarineScene(),
                            new USMarineScene(),
                            new USMarineScene()
                    };
                    break;
                default:
                    System.out.println("Invalid choice. Exiting game.");
                    return;
            }
            int currentSceneIndex = 0;
            while (currentSceneIndex >= 0 && currentSceneIndex < scenes.length) {
                Scene currentScene = scenes[currentSceneIndex];
                currentScene.play(player);
                currentSceneIndex = currentScene.getNextSceneIndex();
            }



        }
        System.out.println("Thanks for playing! Goodbye.");
    }
}