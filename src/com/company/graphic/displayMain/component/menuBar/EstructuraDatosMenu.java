/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.graphic.displayMain.component.menuBar;

import com.company.controller.menuBar.ControllerEstructuraDatosMenu;
import com.company.graphic.displayMain.component.CanvasFigure;
import com.company.graphic.displayMain.component.Information;
import com.company.graphic.displayMain.component.menuBar.estructuraDato.EstructuraDatoLineal;
import javax.swing.JMenu;

/**
 *
 * @author migi
 */
public class EstructuraDatosMenu extends JMenu{
    
    private ControllerEstructuraDatosMenu controller;
    
    private EstructuraDatoLineal strcLineal;
    private MethodMenu methodMenu;
    
    public EstructuraDatosMenu(CanvasFigure canvas, Information info, MethodMenu methodMenu){
        super("Estructura De Datos");
        this.methodMenu = methodMenu;
        controller = new ControllerEstructuraDatosMenu(canvas,info,methodMenu);
        initComponents();
    }

    private void initComponents() {
        strcLineal = new EstructuraDatoLineal(controller);
        add(strcLineal);
    }
    
}
