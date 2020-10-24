package com.ocheretenyuk;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0.0000");
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your currency (UAH, USD, EVR, CHF, PLN): ");

        switch (scan.nextLine()){
            case "UAH":
                new UAH().convertMenu(df);
                break;
            case "USD":
                new USD().convertMenu(df);
                break;
            case "EVR":
                new EVR().convertMenu(df);
                break;
            case "CHF":
                new CHF().convertMenu(df);
                break;
            case "PLN":
                new PLN().convertMenu(df);
                break;
            default:
                System.out.println("Incorrect input");
                break;
        }
    }
}
