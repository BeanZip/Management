package com.inventory;


import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.FlatGruvboxDarkHardIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatGruvboxDarkMediumIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatGruvboxDarkSoftIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatGitHubDarkIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatGitHubIJTheme;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Menu extends Window implements MenuInterface{
    JMenuBar menuBar = new JMenuBar();
    JMenu helpMenu = new JMenu("Help");
    JMenu optionMenu = new JMenu("Option");
    JMenu fileMenu = new JMenu("Inventory");
    JMenu Theme = new JMenu("Themes");

    // help bar //
    JMenuItem git = new JMenuItem("GitHub");
    JMenuItem tutorial = new JMenuItem("Tutorials");

    // options bar //
    JMenuItem saveFile = new JMenuItem("Save File");
    JMenuItem deleteFile = new JMenuItem("Delete File");
    JMenuItem newInventory = new JMenuItem("New Inventory");
    JMenuItem deleteInventory = new JMenuItem("Delete Inventory");

    // Themes bar //
    JMenuItem GitD = new JMenuItem("GitHub Dark");
    JMenuItem GitL = new JMenuItem("GitHub Light");
    JMenuItem light = new JMenuItem("Default");
    JMenuItem dark = new JMenuItem("Dark Mode");
    JMenuItem GruvL = new JMenuItem("GruvBox Medium");
    JMenuItem GruvS = new JMenuItem("GruvBox Soft");
    JMenuItem GruvH = new JMenuItem("GruvBox Hard");

    public Menu(@NotNull String title) {
        super(title);
    }

    @Override
    public void interactable() {
      git.addActionListener(e ->{
        try{
            Desktop.getDesktop().browse(new URI("https://github.com/BeanZip"));
        } catch (IOException | URISyntaxException ex) {
            throw new RuntimeException(ex);
        }
      });
      tutorial.addActionListener(e ->{
         JOptionPane.showMessageDialog(this,"IDK YET");
      });
      saveFile.addActionListener(e ->{

      });
      deleteFile.addActionListener(e ->{

      });
      newInventory.addActionListener(e ->{

      });
      deleteInventory.addActionListener(e ->{

      });
      GitD.addActionListener(e ->{
          FlatGitHubDarkIJTheme.setup();
          SwingUtilities.updateComponentTreeUI(this);
      });
      GitL.addActionListener(e ->{
          FlatGitHubIJTheme.setup();
          SwingUtilities.updateComponentTreeUI(this);
      });
      light.addActionListener(e ->{
          FlatLightLaf.setup();
          SwingUtilities.updateComponentTreeUI(this);
      });
      dark.addActionListener(e ->{
          FlatDarkLaf.setup();
          SwingUtilities.updateComponentTreeUI(this);
      });
      GruvL.addActionListener(e ->{
          FlatGruvboxDarkMediumIJTheme.setup();
          SwingUtilities.updateComponentTreeUI(this);
      });
      GruvS.addActionListener(e ->{
          FlatGruvboxDarkSoftIJTheme.setup();
          SwingUtilities.updateComponentTreeUI(this);
      });
      GruvH.addActionListener(e ->{
          FlatGruvboxDarkHardIJTheme.setup();
          SwingUtilities.updateComponentTreeUI(this);
      });
    }
    public void ThemeSetup(){
        Theme.add(GitD);
        Theme.add(GitL);
        Theme.add(light);
        Theme.add(dark);
        Theme.add(GruvS);
        Theme.add(GruvH);
        Theme.add(GruvL);
    }
    @Override
    public void setup() {
        interactable();
      setJMenuBar(menuBar);
      menuBar.add(helpMenu);
      menuBar.add(optionMenu);
      optionMenu.add(fileMenu);
      optionMenu.add(Theme);
      helpMenu.add(git);
      helpMenu.add(tutorial);
      fileMenu.add(saveFile);
      fileMenu.add(deleteFile);
      fileMenu.add(newInventory);
      fileMenu.add(deleteInventory);
      ThemeSetup();
    }
}
