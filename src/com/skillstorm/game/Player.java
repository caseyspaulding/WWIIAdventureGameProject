package com.skillstorm.game;

public class Player {
    protected String name;
    protected int health;
    protected int supplies;
    protected int gold;

    public Player(String name, int health, int supplies, int gold) {
        this.name = name;
        this.health = health;
        this.supplies = supplies;
        this.gold = gold;
    }

    public String getName() {

        return name;
    }

    public int getHealth() {

        return health;
    }

    public int getSupplies() {

        return supplies;
    }

    public int getGold() {

        return gold;
    }

    public void increaseHealth(int amount) {
        health += amount;
        if (health > 100) {
            health = 100;
        }
    }

    public void decreaseHealth(int amount) {
        health -= amount;
        if (health < 0) {
            health = 0;
        }
    }

    public void increaseSupplies(int amount) {
        supplies += amount;
        if (supplies > 100) {
            supplies = 100;
        }
    }

    public void decreaseSupplies(int amount) {
        supplies -= amount;
        if (supplies < 0) {
            supplies = 0;
        }
    }

    public void increaseGold(int amount) {
        gold += amount;
        if (gold > 100) {
            gold = 100;
        }
    }

    public void decreaseGold(int amount) {
        gold -= amount;
        if (gold < 0) {
            gold = 0;
        }
    }

    public boolean isAlive() {

        return health > 0;
    }
}
