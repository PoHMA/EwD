/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.migii.view.component.menuBar;

import com.migii.view.component.menuBar.helpMenu.AboutItem;

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
