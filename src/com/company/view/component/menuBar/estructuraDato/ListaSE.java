/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.view.component.menuBar.estructuraDato;

import com.company.controller.ControllerCanvas;
import com.company.controller.menuBar.ControllerEstructuraDatosMenu;
import com.company.view.component.canvas.StringListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

/**
 *
 * @author migi
 */
public class ListaSE extends JMenuItem implements ActionListener{

    private ControllerEstructuraDatosMenu controller;
    private JMenuItem [] methods;
    private ControllerCanvas controllerCanvas;

    private StringListener textListener;


    public ListaSE(ControllerEstructuraDatosMenu controller) {
        super("Lista Simple Enlace");
        this.controller = controller;
        addActionListener(this);
        initMethods();
      }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        controller.setTitle("Lista Simple Enlace");
        if(textListener != null) {
            textListener.textEmitted("Mi Descripcion: \n blabla");
        }
        //controller.createMethods("ListSE", methods);
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

    public void setStringListener(StringListener listener){
        this.textListener = listener;
    }

}
