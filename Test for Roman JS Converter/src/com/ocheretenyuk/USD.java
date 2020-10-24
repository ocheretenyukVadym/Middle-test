package com.ocheretenyuk;

import java.text.DecimalFormat;
import java.util.Scanner;

public class USD extends Converter {
    public double USDtoUAH = 28.2364;
    public double USDtoCHF = 0.90;
    public double USDtoEVR = 0.84;
    public double USDtoPLN = 3.85;

    public double value;

    public USD() {
    }

    public USD(double value) {
        setValue(value);
    }

    public float getValue() {
        return (float)this.value;
    }

    public void setValue(double value) {
        if (value > 0) this.value = value;
    }

    @Override
    public float convert(USD obj) {
        return getValue();
    }

    @Override
    public float convert(EVR obj) {
        return (float) (getValue() * USDtoEVR);
    }

    @Override
    public float convert(PLN obj) {
        return (float) (getValue() * USDtoPLN);
    }

    @Override
    public float convert(UAH obj) {
        return (float) (getValue() * USDtoUAH);
    }

    @Override
    public float convert(CHF obj) {
        return (float) (getValue() * USDtoCHF);
    }

    public void convertMenu(DecimalFormat df) {
        System.out.print("value: ");
        USD usd = new USD(new Scanner(System.in).nextDouble());
        System.out.println("Enter second currency (UAH, USD, EVR, CHF, PLN): ");
        switch (new Scanner(System.in).nextLine()) {
            case "UAH":
                System.out.println("Result: " + df.format(usd.convert(new UAH())));
                break;
            case "USD":
                System.out.println("Result: " + df.format(usd.convert(new USD())));
                break;
            case "EVR":
                System.out.println("Result: " + df.format(usd.convert(new EVR())));
                break;
            case "CHF":
                System.out.println("Result: " + df.format(usd.convert(new CHF())));
                break;
            case "PLN":
                System.out.println("Result: " + df.format(usd.convert(new PLN())));
                break;
            default:
                System.out.println("Incorrect input");
                break;
        }
    }
}
