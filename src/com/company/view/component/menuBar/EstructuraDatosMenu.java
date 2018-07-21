/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.view.component.menuBar;

import com.company.controller.ControllerCanvas;
import com.company.controller.menuBar.ControllerEstructuraDatosMenu;
import com.company.view.component.canvas.StringListener;
import com.company.view.component.menuBar.estructuraDato.EstructuraDatoLineal;
import com.company.view.component.Information;

import javax.swing.JMenu;

/**
 *
 * @author migi
 */
public class EstructuraDatosMenu extends JMenu{
    
    private ControllerEstructuraDatosMenu controller;
    private ControllerCanvas controllerCanvas;

    private EstructuraDatoLineal strcLineal;
    private MethodMenu methodMenu;

    private StringListener textListener;


    public EstructuraDatosMenu(Information info, MethodMenu methodMenu){
        super("Estructura De Datos");
        this.methodMenu = methodMenu;
        controller = new ControllerEstructuraDatosMenu(info,methodMenu);
        initComponents();
    }

    private void initComponents() {
        strcLineal = new EstructuraDatoLineal(controller);
        add(strcLineal);
    }

    public void setStringListener(StringListener listener){
        this.textListener = listener;
        strcLineal.setStringListener(textListener);
    }


}
