package com.inventory;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Menu extends Window {
    protected JMenuBar menuBar = new JMenuBar();
    protected JMenu helpMenu = new JMenu("Help");
    protected JMenu optionMenu = new JMenu("Options");
    protected JMenu fileMenu = new JMenu("Inventory");

    // Menu items
    protected JMenuItem git = new JMenuItem("GitHub");
    protected JMenuItem tutorial = new JMenuItem("Tutorials");
    protected JMenuItem saveFile = new JMenuItem("Save File");
    protected JMenuItem deleteFile = new JMenuItem("Delete File");
    protected JMenuItem newInventory = new JMenuItem("New Inventory");
    protected JMenuItem deleteInventory = new JMenuItem("Delete Inventory");

    public Menu(String title) {
        super(title);
        setupMenu();
    }

    private void setupMenu() {
        // Setup Help Menu
        git.addActionListener(e -> {
            try {
                Desktop.getDesktop().browse(new URI("https://github.com/BeanZip"));
            } catch (IOException | URISyntaxException ex) {
                ex.printStackTrace();
            }
        });

        tutorial.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "IDK YET");
        });

        // Setup File Menu
        fileMenu.add(saveFile);
        fileMenu.add(deleteFile);
        fileMenu.add(newInventory);
        fileMenu.add(deleteInventory);

        // Assemble the menu bar
        menuBar.add(helpMenu);
        menuBar.add(optionMenu);
        helpMenu.add(git);
        helpMenu.add(tutorial);

        // Set the menu bar
        setJMenuBar(menuBar);
    }
}
