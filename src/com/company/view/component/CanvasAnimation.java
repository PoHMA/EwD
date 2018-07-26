package com.company.view.component;

import com.company.view.component.canvas.AnimacionNodo;
import com.company.view.component.canvas.CanvasListener;
import com.company.view.component.canvas.Game;
import com.company.view.component.informationPanel.methodPanel.MethodEvent;
import com.company.view.component.informationPanel.methodPanel.MethodListener;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Animation extends JPanel implements  ActionListener{

    private CanvasListener listener;

    private Game game;
    private Timer timer;

    public Animation(){
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
