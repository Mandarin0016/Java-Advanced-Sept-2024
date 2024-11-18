package org.example;

import org.example.mockito.LuckyWheel;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        LuckyWheel wheel = new LuckyWheel(new Random());

        int win = wheel.riskAndWin(5);

        System.out.println(win);
    }
}