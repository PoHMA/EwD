/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.view.component;

import com.company.view.component.canvas.AnimacionNodo;
import com.company.view.component.canvas.CanvasListener;

import java.awt.Canvas;
import java.awt.Graphics;

import java.awt.Image;
import java.awt.MediaTracker;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
/**
 *
 * @author migi
 */
public class CanvasFigure extends Canvas {
    
    private final int width;
    private final int height;
    private CanvasListener listener;


    Image img;
    URL ur;
    Graphics graphics;
    Image jankulovski;
    MediaTracker tracker;
    Thread thread,thread1;
    
    public CanvasFigure(int width, int height){
        this.height = height;
        this.width = width;
        readImage();
        addListener();
        repaint();
    }

    private void readImage() {
        try {
            jankulovski = ImageIO.read(getClass().getResourceAsStream("/com/company/img/giif2.gif"));
        } catch (IOException ex) {
            Logger.getLogger(CanvasFigure.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void paint(Graphics g){
        if (img == null) {
            img = createImage(getSize().width, getSize().height);
            graphics = (Graphics)img.getGraphics();
        }
        //g.drawImage(jankulovski,10,10,20,20,this);
        g.drawImage(img, 0, 0, null);
    }
    
    private void addListener() {
        listener = new CanvasListener();
        addMouseListener(listener);
        addMouseMotionListener(listener);
    }

    public void drawGift(){
        graphics.drawImage(jankulovski, 60, 60, this);
        repaint();
    }

    public void drawStruct(String struct) { }

    public void animacionNodo() {
        Thread hilo = new AnimacionNodo();
        hilo.start();
    }



    /*
    public void drawGraph(){
        thread = new Thread(this);
        thread.setName("hilo1");
        thread.start();
        thread1 = new Thread(this);
        thread1.setName("hilo2");
        thread1.start();
    }
    */

}
