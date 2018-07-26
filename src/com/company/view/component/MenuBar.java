/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.view.component;

import com.company.controller.ControllerCanvas;
import com.company.view.component.canvas.StringListener;
import com.company.view.component.menuBar.EstructuraDatosMenu;
import com.company.view.component.menuBar.HelpMenu;
import com.company.view.component.menuBar.MethodMenu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author migi
 */
public class MenuBar extends JMenuBar{

    Information info;

    private ControllerCanvas controllerCanvas;

    private MethodMenu methodMenu;
    private EstructuraDatosMenu strctDatosMenu;
    private HelpMenu helpMenu;

    private StringListener textListener;
    
    public MenuBar(Information info){
        this.info = info;
        initMenu();
    }

    private void initMenu() {
       add(createFileMenu());
       add(createWindowMenu());
       add(createMethodMenu());
       add(createStrctDataMenu());
       add(createHelpMenu());
    }

    public void setStringListener(StringListener listener){
        this.textListener = listener;
        strctDatosMenu.setStringListener(textListener);
    }

    private JMenu createFileMenu(){
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("exit");

        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int action = JOptionPane.showConfirmDialog(MenuBar.this, "Exit","Confirm Exit",JOptionPane.OK_CANCEL_OPTION);
                if(action == JOptionPane.OK_OPTION){
                    System.exit(0);
                }
            }
        });

        fileMenu.add(exitItem);
        return fileMenu;
    }

    private JMenu createWindowMenu(){
        JMenu windowMenu = new JMenu("Window");
        JMenu showMenu = new JMenu("Show");
        JCheckBoxMenuItem showCodeItem = new JCheckBoxMenuItem("Code");

        showCodeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                JCheckBoxMenuItem menuItem = (JCheckBoxMenuItem)ev.getSource();
                System.out.println(menuItem.isSelected());
            }
        });

        showMenu.add(showCodeItem);
        windowMenu.add(showMenu);

        return windowMenu;
    }

    private JMenu createMethodMenu(){
        methodMenu = new MethodMenu();
        return methodMenu;
    }

    private JMenu createStrctDataMenu(){
        strctDatosMenu = new EstructuraDatosMenu(info, methodMenu);
        return strctDatosMenu;
    }

    private JMenu createHelpMenu(){
        helpMenu = new HelpMenu();
        return helpMenu;
    }
    
}
