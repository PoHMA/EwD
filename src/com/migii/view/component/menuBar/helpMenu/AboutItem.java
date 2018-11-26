/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.migii.view.component.menuBar.helpMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


/**
 *
 * @author migi
 * 
 */
public class AboutItem extends JMenuItem implements ActionListener{
  public AboutItem() {
    super("About");
    addActionListener(this);
  }

   @Override
   public void actionPerformed(ActionEvent e) {
    JOptionPane.showMessageDialog(null,
            "Miguel Poma \n version 1.1\nCopyright (c) UMSS 2018",
            "About",
            JOptionPane.INFORMATION_MESSAGE);
   }
    
}
