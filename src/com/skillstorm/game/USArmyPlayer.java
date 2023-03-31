package com.skillstorm.game;
import java.util.Random;

public class USArmyPlayer extends Player {
    private int ammo;

    public USArmyPlayer(String name, int health, int supplies, int gold, int ammo) {
        super(name, health, supplies, gold);
        this.ammo = ammo;
    }

    public USArmyPlayer() {
        super("Private", 80, 50, 30);
        Random random = new Random();
        ammo = random.nextInt(50);
    }

    public int getAmmo() {

        return ammo;
    }

    public void increaseAmmo(int amount) {
        ammo += amount;
        if (ammo > 100) {
            ammo = 100;
        }
    }

    public void decreaseAmmo(int amount) {
        ammo -= amount;
        if (ammo < 0) {
            ammo = 0;
        }
    }
}

