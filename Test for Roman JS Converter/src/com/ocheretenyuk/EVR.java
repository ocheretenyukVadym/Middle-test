package com.ocheretenyuk;

import java.text.DecimalFormat;
import java.util.Scanner;

public class EVR  extends Converter {
    public double EVRtoUAH = 33.1877;
    public double EVRtoUSD = 1.19;
    public double EVRtoCHF = 1.07;
    public double EVRtoPLN = 4.57;

    public float value;

    public EVR(){}

    public EVR(float value){
        setValue(value);
    }
    public float getValue(){
        return this.value;
    }
    public void setValue(float value){
        if(value > 0) this.value = value;
    }

    @Override
    public float convert(USD obj) {
        return (float)(getValue()*EVRtoUSD);
    }

    @Override
    public float convert(EVR obj) {
        return getValue();
    }

    @Override
    public float convert(PLN obj) {
        return (float)(getValue()*EVRtoPLN);
    }

    @Override
    public float convert(UAH obj) {
        return (float)(getValue()*EVRtoUAH);
    }

    @Override
    public float convert(CHF obj) {
        return (float)(getValue()*EVRtoCHF);
    }
    public void convertMenu(DecimalFormat df){
        System.out.print("value: ");
        EVR evr = new EVR(new Scanner(System.in).nextFloat());
        System.out.println("Enter second currency (UAH, USD, EVR, CHF, PLN): ");
        switch (new Scanner(System.in).nextLine()){
            case "UAH":
                System.out.println("Result: " + df.format(evr.convert(new UAH())));
                break;
            case "USD":
                System.out.println("Result: " + df.format(evr.convert(new USD())));
                break;
            case "EVR":
                System.out.println("Result: " + df.format(evr.convert(new EVR())));
                break;
            case "CHF":
                System.out.println("Result: " + df.format(evr.convert(new CHF())));
                break;
            case "PLN":
                System.out.println("Result: " + df.format(evr.convert(new PLN())));
                break;
            default:
                System.out.println("Incorrect input");
                break;
        }
    }
}
