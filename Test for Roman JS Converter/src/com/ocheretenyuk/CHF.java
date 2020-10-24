package com.ocheretenyuk;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CHF extends Converter {
    public double CHFtoUAH = 31.3000;
    public double CHFtoUSD = 1.11;
    public double CHFtoEVR = 0.93;
    public double CHFtoPLN = 4.26;

    public double value;
    public CHF(){}
    public CHF(double value){
        setValue(value);
    }
    public float getValue(){
        return (float)this.value;
    }
    public void setValue(double value){
        if(value > 0) this.value = value;
    }

    @Override
    public float convert(USD obj) {
        return (float)(getValue()*CHFtoUSD);
    }

    @Override
    public float convert(EVR obj) {
        return (float)(getValue()*CHFtoEVR);
    }

    @Override
    public float convert(PLN obj) {
        return (float)(getValue()*CHFtoPLN);
    }

    @Override
    public float convert(UAH obj) {
        return (float)(getValue()*CHFtoUAH);
    }

    @Override
    public float convert(CHF obj) {
        return getValue();
    }

    public void convertMenu(DecimalFormat df){
        System.out.print("value: ");
        CHF chf = new CHF(new Scanner(System.in).nextDouble());
        System.out.println("Enter second currency (UAH, USD, EVR, CHF, PLN): ");
        switch (new Scanner(System.in).nextLine()){
            case "UAH":
                System.out.println("Result: " + df.format(chf.convert(new UAH())));
                break;
            case "USD":
                System.out.println("Result: " + df.format(chf.convert(new USD())));
                break;
            case "EVR":
                System.out.println("Result: " + df.format(chf.convert(new EVR())));
                break;
            case "CHF":
                System.out.println("Result: " + df.format(chf.convert(new CHF())));
                break;
            case "PLN":
                System.out.println("Result: " + df.format(chf.convert(new PLN())));
                break;
            default:
                System.out.println("Incorrect input");
                break;
        }
    }
}
