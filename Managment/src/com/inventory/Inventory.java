package com.inventory;

import javax.swing.*;

public class Inventory extends Menu {

    public Inventory(String title) {
        super(title);
        setupInventoryMenu();
        activate(); // Show the window
    }

    private void setupInventoryMenu() {
        JMenuItem viewInventory = new JMenuItem("View Inventory");
        viewInventory.addActionListener(e -> {
            InventoryList inventoryList = new InventoryList(); // Load or create your inventory list
            InventoryDisplay display = new InventoryDisplay("Inventory", inventoryList);
            display.setVisible(true);
        });

        fileMenu.add(viewInventory); // Add to the file menu
    }
}

