/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.graphic.displayMain.component;

import com.company.graphic.displayMain.component.canvas.CanvasListener;
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
public class CanvasFigure extends Canvas implements Runnable{
    
    private final int width;
    private final int height;
    private CanvasListener listener;
    private Video video;
    
    Image img;
    URL ur;
    Graphics graphics;
    Image jankulovski;
    MediaTracker tracker;
    Thread thread;
    
    public CanvasFigure(int width, int height, Video video){
        this.height = height;
        this.width = width;
        this.video = video;
        try {
            jankulovski = ImageIO.read(getClass().getResourceAsStream("/com/company/img/giif2.gif"));
        } catch (IOException ex) {
            Logger.getLogger(CanvasFigure.class.getName()).log(Level.SEVERE, null, ex);
        }
        //ur = CanvasFigure.class.getResource("/img/giif2.gif");
        //jankulovski = Toolkit.getDefaultToolkit().getImage(ur);
        //tracker = new MediaTracker(this);
        //tracker.addImage(jankulovski, 0);
        
        addListener();
        repaint();
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

    public void drawStruct(String struct) {
        /*
        try{
            tracker.waitForID(0);
        }catch(InterruptedException e){}
        */
        graphics.drawImage(jankulovski, 60, 60, this);
        //graphics.drawOval(100, 100, 30, 30);
        repaint();
    }
    
    public void drawGraph(){
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        System.out.println("emtreessss");
        while(isPlay()){
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(CanvasFigure.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("dibujando");
        }
    }

    private boolean isPlay() {
        return video.getPlay();
    }
    
   
    
}
