/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.view;

import com.company.controller.ControllerDiagrammed;
import com.company.view.component.*;
import com.company.view.component.canvas.StringListener;
import com.company.view.component.methodPanel.MethodEvent;
import com.company.view.component.methodPanel.MethodListener;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author migi
 */
public class Diagrammer extends JFrame{
    
    private final int width;
    private final int height;
    private Information info;
    private MenuBar navBar;
    private CanvasFigure canvas;
    private ToolBar toolBar;
    private MethodPanel methodPanel;

    private ControllerDiagrammed controller;

    public Diagrammer(int width, int height){
        super("PWD");
        this.width = width;
        this.height = height;
        controller = new ControllerDiagrammed();
        createDisplay();
    }
    
    private void createDisplay(){
        setSize(width,height);
        setPositionScreen();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setComponents();
        setVisible(true);
    }

    private void setPositionScreen() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(screenSize.width/2 - width/2, screenSize.height/2 - height/2);
    }

    private void setComponents() {

        getContentPane().setLayout(new BorderLayout());

        canvas = new CanvasFigure(100,100);

        info = new Information();
        toolBar = new ToolBar(info);
        navBar = new MenuBar(info);
        methodPanel = new MethodPanel();

        navBar.setStringListener(new StringListener() {
            public void textEmitted(String text) {
                info.appendDescription(text);
            }
        });

        methodPanel.setMethodListener(new MethodListener() {
            @Override
            public void methodEventOccurred(MethodEvent e) {
                controller.addData(e);
            }
        });

        getContentPane().add(navBar,BorderLayout.NORTH);
        getContentPane().add(canvas,BorderLayout.CENTER);
        getContentPane().add(methodPanel,BorderLayout.WEST);
        getContentPane().add(info,BorderLayout.EAST);
        getContentPane().add(toolBar,BorderLayout.SOUTH);
        
    }

}
 