package com.inventory;

import com.formdev.flatlaf.FlatLightLaf;

public class Main{
    public static void main(String[] args){
        FlatLightLaf.setup();
        Menu menu = new Menu("Management System");
        menu.setup();
        menu.active();
    }
}