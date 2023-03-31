package com.skillstorm.game;

public abstract class Scene {
    private String description;

    public Scene(String description) {

        this.description = description;
    }

    public String getDescription() {

        return description;
    }


    public abstract void play(Player player);

    public abstract int getNextSceneIndex();
}

