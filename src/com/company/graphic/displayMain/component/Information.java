/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.graphic.displayMain.component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javafx.scene.layout.Border;
import javax.swing.JComponent;
import javax.swing.BorderFactory;
import javax.swing.border.CompoundBorder;

/**
 *
 * @author migi
 */
public class Information extends JComponent{
    
    CompoundBorder border = BorderFactory.createCompoundBorder(
            BorderFactory.createEtchedBorder(
                    Color.white,Color.BLUE),BorderFactory.createEmptyBorder(4, 4, 4, 4));
    
    Image img;
    Graphics graphics;
    
    public Information(){
        initComponent();
    }

    private void initComponent() {
        setBorder(border);
        repaint();
    }
    
    @Override
    public Dimension getPreferredSize(){
        return new Dimension(200, Short.MAX_VALUE);
    } 
    
    @Override
    public void paintComponent(Graphics g){
        if (img == null) {
            img = createImage(getSize().width, getSize().height);
            graphics = (Graphics)img.getGraphics();
            clear();
        }
        
        g.drawImage(img, 0, 0, null);
    }

    private void clear() {
        graphics.setColor(new Color(220,250,255));
        graphics.fillRect(0, 0, getSize().width, getSize().height);
    }
    
    public void methodTest(){
        //clear();
        graphics.setColor(Color.BLACK);
        graphics.drawString("Information", 60, 80);
        repaint();
    }

    public void drawTitle(String title) {
        graphics.setColor(Color.BLACK);
        graphics.drawString(title, 20, 20);
        repaint();
    }

    public void drawDescription(String description) {
        graphics.setColor(Color.BLACK);
        graphics.drawString(description, 20, 40);
        repaint();
    }
    
    
}
