package com.skillstorm.game;
import java.util.Random;

public class USNavyPlayer extends Player {
    private int shipCondition;
    private int ammo;

    public USNavyPlayer(String name, int health, int supplies, int gold, int shipCondition, int ammo) {
        super(name, health, supplies, gold);
        this.shipCondition = shipCondition;
        this.ammo = ammo;
    }

    public USNavyPlayer() {
        super("Sailor", 100, 70, 50);
        Random random = new Random();
        shipCondition = random.nextInt(50) + 50;
        ammo = random.nextInt(50);
    }

    public int getShipCondition() {

        return shipCondition;
    }

    public int getAmmo() {

        return ammo;
    }

    public void increaseShipCondition(int amount) {
        shipCondition += amount;
        if (shipCondition > 100) {
            shipCondition = 100;
        }
    }

    public void decreaseShipCondition(int amount) {
        shipCondition -= amount;
        if (shipCondition < 0) {
            shipCondition = 0;
        }
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