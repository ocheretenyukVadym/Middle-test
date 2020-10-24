package com.ocheretenyuk;

import java.text.DecimalFormat;
import java.util.Scanner;

public class PLN  extends Converter {
    public double PLNtoUAH = 7.2033;
    public double PLNtoUSD = 0.26;
    public double PLNtoEVR = 0.22;
    public double PLNtoCHF = 0.23;

    public float value;

    public PLN(){}

    public PLN(float value){
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
        return (float)(getValue()*PLNtoUSD);
    }

    @Override
    public float convert(EVR obj) {
        return (float)(getValue()*PLNtoEVR);
    }

    @Override
    public float convert(PLN obj) {
        return getValue();
    }

    @Override
    public float convert(UAH obj) {
        return (float)(getValue()*PLNtoUAH);
    }

    @Override
    public float convert(CHF obj) {
        return (float)(getValue()*PLNtoCHF);
    }
    public void convertMenu(DecimalFormat df){
        System.out.print("value: ");
        PLN pln = new PLN(new Scanner(System.in).nextFloat());
        System.out.println("Enter second currency (UAH, USD, EVR, CHF, PLN): ");
        switch (new Scanner(System.in).nextLine()){
            case "UAH":
                System.out.println("Result: " + df.format(pln.convert(new UAH())));
                break;
            case "USD":
                System.out.println("Result: " + df.format(pln.convert(new USD())));
                break;
            case "EVR":
                System.out.println("Result: " + df.format(pln.convert(new EVR())));
                break;
            case "CHF":
                System.out.println("Result: " + df.format(pln.convert(new CHF())));
                break;
            case "PLN":
                System.out.println("Result: " + df.format(pln.convert(new PLN())));
                break;
            default:
                System.out.println("Incorrect input");
                break;
        }
    }
}
