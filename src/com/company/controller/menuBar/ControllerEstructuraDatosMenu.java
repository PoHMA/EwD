/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.controller.menuBar;

import com.company.graphic.displayMain.component.CanvasFigure;
import com.company.graphic.displayMain.component.Information;
import com.company.graphic.displayMain.component.menuBar.MethodMenu;
import javax.swing.JMenuItem;
import com.company.modelo.estructuraDatosLineales.ListaSE;

/**
 *
 * @author migi
 */
public class ControllerEstructuraDatosMenu {
    
    Information info;
    
    private ListaSE<Integer> listaSE;
    private final CanvasFigure canvas;
    private final MethodMenu methodMenu;
    
    public ControllerEstructuraDatosMenu(CanvasFigure canvas, Information info,MethodMenu methodMenu){
        this.canvas = canvas;
        this.info = info;
        this.methodMenu = methodMenu;
    }
    
    
    public void print(){
        System.out.println("hiii");
    }

    public void setTitle(String title) {
        info.drawTitle(title);
    }

    public void setDescription(String description) {
        info.drawDescription(description);
    }

    public void createMethods(String struct, JMenuItem [] items) {
        if(struct.equals("ListSE")){
            listaSE = new ListaSE<>();
            methodMenu.clear();
            methodMenu.addItems(items);
            canvas.drawStruct(struct);
        }
    }

    public void addNodo() {
        listaSE.insertar(1);
    }

    public void lengthList() {
        int tam = listaSE.longitud();
        System.out.println("-> "+tam);
    }
    
}
