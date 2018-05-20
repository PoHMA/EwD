/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.graphic.displayMain.component.menuBar.estructuraDato;

import com.company.controller.menuBar.ControllerEstructuraDatosMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

/**
 *
 * @author migi
 */
public class ListaSE extends JMenuItem implements ActionListener{

    ControllerEstructuraDatosMenu controller;
    private JMenuItem [] methods;
    
    public ListaSE(ControllerEstructuraDatosMenu controller) {
        super("Lista Simple Enlace");
        this.controller = controller;
        addActionListener(this);
        initMethods();
      }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        controller.setTitle("Lista Simple Enlace");
        controller.setDescription("Mi Descripcion: \n blabla");
        controller.createMethods("ListSE", methods);
    }
    
    private void initMethods() {
        methods = new JMenuItem [2];
        methods[0] = addNodoList(); 
        methods[1] = lengthList(); 
    }
            
    public JMenuItem addNodoList(){
        JMenuItem method = new JMenuItem("insertar");
        method.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        controller.addNodo();
                    }
                }
        );
        return method;
    }
    
    public JMenuItem lengthList(){
        JMenuItem method = new JMenuItem("longitud");
        method.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        controller.lengthList();
                    }
                }
        );
        return method;
    }
    
}
