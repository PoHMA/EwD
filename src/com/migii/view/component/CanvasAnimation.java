package com.migii.view.component;

import com.migii.view.component.canvas.CanvasListener;
import com.migii.view.component.canvas.Game;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CanvasAnimation extends JPanel implements  ActionListener{

    private CanvasListener listener;

    private Game game;
    private Timer timer;

    public CanvasAnimation(){
        addListener();
        initPanel();
        repaint();
    }

    private void initPanel(){
        game = new Game();
        timer = new Timer(500,this);
        setLayout(new BorderLayout());
        add(game, BorderLayout.CENTER);
        setBorderPanel("Estructura");
    }

    private void start(){
        timer.start();
        setBorderPanel("Lista de Simple Enlace");
    }

    private void  setBorderPanel(String title){
        Border innerBorder = BorderFactory.createTitledBorder(title);
        Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder,innerBorder));
    }

    private void addListener() {
        listener = new CanvasListener();
        addMouseListener(listener);
        addMouseMotionListener(listener);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        game.runArrowNode();
        game.repaint();
    }

    public void runAddNodeLSE(){
        start();
    }


}
