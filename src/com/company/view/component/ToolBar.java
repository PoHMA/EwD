/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.company.view.component;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author migi
 */
public class ToolBar extends JPanel implements ActionListener{
    
    private int width,height;
    private Choice dataStructure;
    private Information info;
    
    private boolean draw;

    private JButton prev,play,next;
    
    public ToolBar(Information info){
        draw = false;
        this.height = height;
        this.width = width;
        this.info = info;
        init();
    }
    
    private void init(){
        //setLayout(new FlowLayout(FlowLayout.LEFT));
        setLayout(new GridLayout(1,10));

        prev = new JButton("Prev");
        play = new JButton("Play");
        next = new JButton("Next");

        prev.addActionListener(this);
        play.addActionListener(this);
        next.addActionListener(this);

        add(prev);
        add(play);
        add(next);

    }

    private void createListDataStructure() {
        dataStructure = new Choice();
        dataStructure.addItem("Lista Simple Enlace");
        dataStructure.addItem("Lista Doble Enlace");
        add(dataStructure);
    }

    
    public boolean getPlay() {
        return draw;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton)e.getSource();

        if (clicked == next) {
            System.out.println("1");
        }
        if (clicked == play) {
            System.out.println("2");
        }
        if (clicked == prev) {
            System.out.println("3");
        }
    }
}
