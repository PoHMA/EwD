/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.graphic.displayMain;

import com.company.graphic.displayMain.component.CanvasFigure;
import com.company.graphic.displayMain.component.Information;
import com.company.graphic.displayMain.component.MenuBar;
import com.company.graphic.displayMain.component.Video;
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
    private final String title;
    private CanvasFigure canvas;
    private Information info;
    private MenuBar navBar;
    public Diagrammer(String title, int width, int height){
        this.title = title;
        this.width = width;
        this.height = height;
        createDisplay();
    }
    
    private void createDisplay(){
        setTitle(title);
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
        
        info = new Information();
        Video table = new Video(info);
        canvas = new CanvasFigure(100,100, table);
        navBar = new MenuBar(canvas,info);
        
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(navBar,BorderLayout.NORTH);
        getContentPane().add(canvas,BorderLayout.CENTER);
        getContentPane().add(info,BorderLayout.EAST);
        getContentPane().add(table,BorderLayout.SOUTH);
        
    }
    
    public CanvasFigure getCanvas(){
        return canvas;
    }
    
}
 