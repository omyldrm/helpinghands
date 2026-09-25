package be.kdg.pro3;


import be.kdg.pro3.model.DataFactory;

import java.io.PrintStream;

public class Main {
    private PrintStream io = System.out;
    public static void main(String[] args) {

        DataFactory.seed();

    }
}