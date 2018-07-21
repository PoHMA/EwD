/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.view.component.menuBar;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 *
 * @author migi
 */
public class MethodMenu extends JMenu {
    
    
    private JMenuItem [] items;
    
    public MethodMenu(){
        super("Metodos");
        items = new JMenuItem[0];
        initComponents();
    }

    private void initComponents() {
      //generate = new Generate();
      //add(generate);
    }
    
    public void addItems(JMenuItem[] methods){
        items = methods;
        for (JMenuItem method : methods) {
            add(method);
        }
    }
    
    public void clear(){
        for (JMenuItem item : items) 
            remove(item);
    }
    
}
