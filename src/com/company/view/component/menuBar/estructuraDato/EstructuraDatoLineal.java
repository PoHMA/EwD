/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.view.component.menuBar.estructuraDato;

import com.company.controller.menuBar.ControllerEstructuraDatosMenu;
import com.company.view.component.canvas.StringListener;

import javax.swing.JMenu;

/**
 *
 * @author migi
 */
public class EstructuraDatoLineal extends JMenu {
    
    private ListaSE listEnlazada;
    private ControllerEstructuraDatosMenu controller;

    private StringListener textListener;


    public EstructuraDatoLineal(ControllerEstructuraDatosMenu controller){
        super("Estructura Dato Lineal");
        this.controller = controller;
        initComponents();
    }

    private void initComponents() {
        listEnlazada = new ListaSE(controller);
        add(listEnlazada);
    }

    public void setStringListener(StringListener listener){
        this.textListener = listener;
        listEnlazada.setStringListener(textListener);
    }


}
