/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.view;

import com.company.controller.ControllerDiagrammed;
import com.company.view.component.*;
import com.company.view.component.canvas.StringListener;
import com.company.view.component.informationPanel.InfoEvent;
import com.company.view.component.informationPanel.InformationListener;
import com.company.view.component.toolBar.ToolBarListener;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;

/**
 *
 * @author migi
 */
public class Diagrammer extends JFrame{
    
    private final int width;
    private final int height;
    private MenuBar navBar;
    private CanvasAnimation canvas;
    private ToolBar toolBar;
    private JSplitPane splitPane;
    private InformationPanel informationPanel;
    //private JTabbedPane tabbedPane;

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
        //setResizable(false);
        setComponents();
        setVisible(true);
    }

    private void setPositionScreen() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(screenSize.width/2 - width/2, screenSize.height/2 - height/2);
    }

    private void setComponents() {

        getContentPane().setLayout(new BorderLayout());

        canvas = new CanvasAnimation();
        toolBar = new ToolBar();
        navBar = new MenuBar();
        informationPanel = new InformationPanel();

        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,informationPanel,canvas);
        splitPane.setOneTouchExpandable(true);

        createListenerToolBar();
        createListenerNavBarPanel();
        createListenerInformation();

        setJMenuBar(navBar);
        getContentPane().add(toolBar,BorderLayout.PAGE_START);
        getContentPane().add(splitPane,BorderLayout.WEST);
        getContentPane().add(canvas,BorderLayout.CENTER);

    }



    private void createListenerToolBar(){
        toolBar.setToolbarListener(new ToolBarListener() {
            @Override
            public void saveEventOccured() {
                System.out.println("1");
            }

            @Override
            public void refreshEventOccured() {
                System.out.println("2");
            }
        });
    }

    private void createListenerNavBarPanel(){
        navBar.setStringListener(new StringListener() {
            public void textEmitted(String text) {
                System.out.println("eentre nav bar listener");
            }
        });
    }

    private void createListenerInformation() {
        informationPanel.setActionListener(new InformationListener() {
            @Override
            public void runActionAnimation(InfoEvent e) {
                canvas.runAddNodeLSE();
                controller.addData(e);
            }
        });
    }


}
 