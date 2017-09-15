package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by user on 20.11.2016.
 */
public class Hippodrome {
    public static Hippodrome game;

    ArrayList<Horse> horses = new ArrayList<>();

    public ArrayList<Horse> getHorses() {
        return horses;
    }

    public static void main(String[] args) {
        game = new Hippodrome();
        Horse horse1 = new Horse("Forward", 3, 0);
        Horse horse2 = new Horse("Hurricane", 3, 0);
        Horse horse3 = new Horse("Wind", 3, 0);

        game.getHorses().add(horse1);
        game.getHorses().add(horse2);
        game.getHorses().add(horse3);

        game.run();
        game.printWinner();
    }

    public void move() {
        for (Horse horse : horses) {
            horse.move();
        }
    }

    public void print() {
        for (Horse horse : horses) {
            horse.print();
        }

        System.out.println();
        System.out.println();
    }

    public void run() {

        for (int i = 0; i < 100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Horse getWinner() {
        double distance = 0;
        Horse isWinner = null;
        for (Horse horse : horses) {
            if (horse.getDistance() > distance) {
                isWinner = horse;
                distance = horse.getDistance();
            }
        }
        return isWinner;
    }

    public void printWinner() {
        System.out.println(String.format("Winner is %s!", getWinner().getName()));
    }

}
