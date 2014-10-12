package com.puzzles.eggcarton;

import com.search.State;

import java.util.ArrayList;

/**
 * Created by Sondre on 11.10.2014.
 */
public class EggCartonState implements State {
    private ArrayList<Position> eggs;
    private int eggsAllowed;
    private int width;
    private int height;

    public EggCartonState(int width, int height, int eggsAllowed) {
        this.width = width;
        this.height = height;
        this.eggsAllowed = eggsAllowed;
        initialiseState();
    }

    public EggCartonState(EggCartonState state) {
        this.width = state.getWidth();
        this.height = state.getHeight();
        this.eggsAllowed = state.getEggsAllowed();
        ArrayList<Position> eggs = new ArrayList<Position>();
        for (Position egg : state.getEggs()) {
            eggs.add(new Position(egg.getX(), egg.getY()));
        }
        this.eggs = eggs;
    }

    public void initialiseState() {
        eggs = new ArrayList<Position>();
        for(int i = 0; i<width; i++) {
            for (int j=0; j<this.eggsAllowed; j++) {
                Position position = new Position(i, (int)(Math.random()*height));
                eggs.add(position);
            }
        }
    }

    public ArrayList<Position> getEggs() {
        return eggs;
    }

    public int getEggsAllowed() {
        return eggsAllowed;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i<height; i++) {
            for (int j = 0; j<width; j++) {
                boolean found = false;
                for (Position pos : eggs) {
                    if (pos.getX() == j && pos.getY() == i) {
                        found = true;
                    }
                }
                if (found) result += "O ";
                else result += "X ";
            }
            result += "\n";
        }
        return result;
    }
}
