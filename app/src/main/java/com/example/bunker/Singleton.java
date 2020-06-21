package com.example.bunker;

public class Singleton {
    private static Bunker bunker;

    public static Bunker getBunker() {
        return bunker;
    }

    public static void setBunker(int playerCount) {
        bunker = new Bunker(playerCount);
    }
}
