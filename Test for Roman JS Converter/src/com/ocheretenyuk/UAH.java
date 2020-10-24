package com.ocheretenyuk;

import java.text.DecimalFormat;
import java.util.Scanner;

public class UAH extends Converter {
    public double UAHtoCHF = 0.032;
    public double UAHtoUSD = 28.4434;
    public double UAHtoEVR = 33.6423;
    public double UAHtoPLN = 7.4314;


    public double value;
    public UAH(){

    }
    public UAH(double value){
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
        return (float)(getValue()/UAHtoUSD);
    }

    @Override
    public float convert(EVR obj) {
        return (float)(getValue()/UAHtoEVR);
    }

    @Override
    public float convert(PLN obj) {
        return (float)(getValue()/UAHtoPLN);
    }

    @Override
    public float convert(UAH obj) {
        return getValue();
    }

    @Override
    public float convert(CHF obj) {
        return (float)(getValue()*UAHtoCHF);
    }
    public void convertMenu(DecimalFormat df){
        System.out.print("value: ");
        UAH uah = new UAH(new Scanner(System.in).nextDouble());
        System.out.println("Enter second currency (UAH, USD, EVR, CHF, PLN): ");
        switch (new Scanner(System.in).nextLine()){
            case "UAH":
                System.out.println(df.format(uah.convert(new UAH())));
                break;
            case "USD":
                System.out.println("Result: " + df.format(uah.convert(new USD())));
                break;
            case "EVR":
                System.out.println("Result: " + df.format(uah.convert(new EVR())));
                break;
            case "CHF":
                System.out.println("Result: " + df.format(uah.convert(new CHF())));
                break;
            case "PLN":
                System.out.println("Result: " + df.format(uah.convert(new PLN())));
                break;
            default:
                System.out.println("Incorrect input");
                break;
        }
    }
}
