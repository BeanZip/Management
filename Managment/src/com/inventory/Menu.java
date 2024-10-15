package com.inventory;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.FlatGruvboxDarkHardIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatGruvboxDarkMediumIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatGruvboxDarkSoftIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatGitHubDarkIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatGitHubIJTheme;

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
    protected JMenu themeMenu = new JMenu("Themes"); // Main Themes Menu

    // Menu items
    protected JMenuItem git = new JMenuItem("GitHub");
    protected JMenuItem tutorial = new JMenuItem("Tutorials");
    protected JMenuItem saveFile = new JMenuItem("Save File");
    protected JMenuItem deleteFile = new JMenuItem("Delete File");
    protected JMenuItem newInventory = new JMenuItem("New Inventory");
    protected JMenuItem deleteInventory = new JMenuItem("Delete Inventory");

    // GitHub theme submenu
    protected JMenu githubMenu = new JMenu("GitHub Colors");
    protected JMenu gruvboxMenu = new JMenu("Gruvbox Colors");

    public Menu(String title) {
        super(title);
        setupMenu();
        setupThemeMenu();
    }

    void setupMenu() {
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

        // Setup Theme Menu
        setupThemeMenu();

        // Assemble the menu bar
        menuBar.add(helpMenu);
        menuBar.add(optionMenu);
        helpMenu.add(git);
        helpMenu.add(tutorial);
        optionMenu.add(fileMenu);
        optionMenu.add(themeMenu);
        themeMenu.add(githubMenu);
        themeMenu.add(gruvboxMenu);
    }

    void setupThemeMenu() {
        // GitHub Themes
        JMenuItem gitHubDark = new JMenuItem("GitHub Dark");
        JMenuItem gitHubLight = new JMenuItem("GitHub Light");
        gitHubDark.addActionListener(e -> {
            FlatGitHubDarkIJTheme.setup();
            SwingUtilities.updateComponentTreeUI(this);
        });
        gitHubLight.addActionListener(e -> {
            FlatGitHubIJTheme.setup();
            SwingUtilities.updateComponentTreeUI(this);
        });
        githubMenu.add(gitHubDark);
        githubMenu.add(gitHubLight);

        // Gruvbox Themes
        JMenuItem gruvboxDarkMedium = new JMenuItem("Gruvbox Medium");
        JMenuItem gruvboxDarkSoft = new JMenuItem("Gruvbox Soft");
        JMenuItem gruvboxDarkHard = new JMenuItem("Gruvbox Hard");
        gruvboxDarkMedium.addActionListener(e -> {
            FlatGruvboxDarkMediumIJTheme.setup();
            SwingUtilities.updateComponentTreeUI(this);
        });
        gruvboxDarkSoft.addActionListener(e -> {
            FlatGruvboxDarkSoftIJTheme.setup();
            SwingUtilities.updateComponentTreeUI(this);
        });
        gruvboxDarkHard.addActionListener(e -> {
            FlatGruvboxDarkHardIJTheme.setup();
            SwingUtilities.updateComponentTreeUI(this);
        });
        gruvboxMenu.add(gruvboxDarkMedium);
        gruvboxMenu.add(gruvboxDarkSoft);
        gruvboxMenu.add(gruvboxDarkHard);
    }
}
