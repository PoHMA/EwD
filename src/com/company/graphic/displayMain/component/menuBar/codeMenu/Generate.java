/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.graphic.displayMain.component.menuBar.codeMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

/**
 *
 * @author migi
 */
public class Generate extends JMenuItem implements ActionListener{
    
    public Generate(){
        super("generar");
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    
    }
    
}
