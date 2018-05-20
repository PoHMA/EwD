/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.company.graphic.displayMain.component;

import com.company.graphic.displayMain.Diagrammer;
import java.awt.Choice;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author migi
 */
public class Video extends JPanel{
    
    private int width,height;
    private Choice dataStructure;
    private Information info;
    
    private boolean draw;
    
    public Video(Information info){
        draw = false;
        this.height = height;
        this.width = width;
        this.info = info;
        init();
    }
    
    private void init(){
        setLayout(new GridLayout(1, 10));
        createButtonPrev();
        createButtonPlay();
        createButtonNext();
    }
    
    private void createButtonPrev() {
        JButton prev = new JButton("Prev");
        prev.setBounds(100, 100, 50, 10);
        prev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println(dataStructure.getSelectedItem());
            }
        });
        add(prev);
    }

    private void createButtonPlay() {
        JButton play = new JButton("Play");
        play.setBounds(100, 100, 50, 10);
        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                draw = !draw;
            }
        });
        add(play);
    }
    
    private void createButtonNext() {
        JButton next = new JButton("Next");
        next.setBounds(100, 100, 50, 10);
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println(dataStructure.getSelectedItem());
            }
        });
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
    
}
