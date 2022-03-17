package com.example.vk8_4;

import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class BottleDispenser {
    private int bottles;
    private double money;

    private static BottleDispenser bottledispenser = new BottleDispenser();

    public static BottleDispenser getInstance(){
        return bottledispenser;
    }

    private ArrayList<Bottle> list = new ArrayList<Bottle>();

    private BottleDispenser() {
        bottles = 5;
        money = 0;

        list.add(new Bottle("Pepsi Max", 0.5, 1.8));
        list.add(new Bottle("Pepsi Max", 1.5, 2.2));
        list.add(new Bottle("Coca-Cola Zero", 0.5, 2.0));
        list.add(new Bottle("Coca-Cola Zero", 1.5, 2.5));
        list.add(new Bottle("Fanta Zero", 0.5, 1.95));

    }

    public void addMoney(TextView text, int value ) {
        money += value;
        text.setText("Klink! Added more money!");
    }


    public void buyBottle(TextView text, int choice) {

        if(money < list.get(choice).getPrice()){
            text.setText("Add money first!");
        }
        else if(bottles > 0){
            bottles -= 1;
            money -= list.get(choice).getPrice();
            text.setText("KACHUNK! " + list.get(choice).getName() + " came out of the dispenser!");
        }
    }

    public void returnMoney(TextView text) {

        DecimalFormat formatted = new DecimalFormat("0.00");
        text.setText("Klink klink. Money came out! You got " + formatted.format(money) + "€ back");
        money = 0;
    }

}
