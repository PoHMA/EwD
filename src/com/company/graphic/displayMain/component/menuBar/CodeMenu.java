/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.graphic.displayMain.component.menuBar;

import com.company.graphic.displayMain.component.menuBar.codeMenu.Generate;
import javax.swing.JMenu;

/**
 *
 * @author migi
 */
public class CodeMenu extends JMenu{
    
    Generate generate;
    
    public CodeMenu(){
        super("Code");
        initComponents();
    }

    private void initComponents() {
      generate = new Generate();
      add(generate);
    }
    
    
}
