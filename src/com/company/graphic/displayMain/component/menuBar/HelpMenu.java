/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.graphic.displayMain.component.menuBar;

import com.company.graphic.displayMain.component.menuBar.helpMenu.AboutItem;
import javax.swing.JMenu;

/**
 *
 * @author migi
 * 
 */

public class HelpMenu extends JMenu{
    private AboutItem aboutItem;
    
    public HelpMenu(){
        super("Help");
        initComponents();
    }

    private void initComponents() {
      aboutItem = new AboutItem();
      add(aboutItem);
    }
    
}
