package com.inventory;

import com.formdev.flatlaf.FlatLightLaf;

public class Main{
    public static void main(String[] args){
        FlatLightLaf.setup();
        new Inventory("Inventory Manager");
    }
}