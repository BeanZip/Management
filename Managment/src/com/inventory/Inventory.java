package com.inventory;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Inventory extends Menu{

    public Inventory(@NotNull String title) {
        super(title);
        setupInventoryMenu();
    }
    private void setupInventoryMenu() {
        JMenuItem viewInventory = new JMenuItem("View Inventory");
        viewInventory.addActionListener(this::viewInventoryAction);

        fileMenu.add(viewInventory); // Add to the file menu
    }

    private void viewInventoryAction(ActionEvent e) {
        // Assume you have an InventoryList with the inventory items
        InventoryList inventoryList = new InventoryList();
        InventoryDisplay inventoryDisplay = new InventoryDisplay("Inventory", inventoryList);
        inventoryDisplay.setVisible(true);
    }

    @Override
    public void setup() {
        super.setup(); // Call the parent setup
    }
}
