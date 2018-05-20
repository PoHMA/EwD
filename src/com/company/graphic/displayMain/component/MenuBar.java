/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.graphic.displayMain.component;

import com.company.graphic.displayMain.component.menuBar.CodeMenu;
import com.company.graphic.displayMain.component.menuBar.EstructuraDatosMenu;
import com.company.graphic.displayMain.component.menuBar.HelpMenu;
import com.company.graphic.displayMain.component.menuBar.MethodMenu;
import com.company.graphic.displayMain.component.menuBar.RecursividadMenu;
import javax.swing.JMenuBar;

/**
 *
 * @author migi
 */
public class MenuBar extends JMenuBar{
    
    CanvasFigure canvas;
    Information info;
    
    private RecursividadMenu recursividadMenu;
    private MethodMenu methodMenu;
    private EstructuraDatosMenu strctDatosMenu;
    private CodeMenu codeMenu;
    private HelpMenu helpMenu;
    
    public MenuBar(CanvasFigure canvas, Information info){
        this.canvas = canvas;
        this.info = info;
        initComponent();
    }

    private void initComponent() {
       recursividadMenu = new RecursividadMenu();
       add(recursividadMenu);
       methodMenu = new MethodMenu();
       add(methodMenu);
       strctDatosMenu = new EstructuraDatosMenu(canvas,info, methodMenu);
       add(strctDatosMenu);
       codeMenu = new CodeMenu();
       add(codeMenu);
       helpMenu = new HelpMenu();
       add(helpMenu);
    }
    
}
