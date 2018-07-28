/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.company.view.component;

import com.company.library.Utils;
import com.company.view.component.informationPanel.FunctionPanel;
import com.company.view.component.toolBar.ToolBarListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author migi
 */
public class ToolBar extends JToolBar implements ActionListener{
    
    private int width,height;
    private Choice dataStructure;
    private boolean draw;

    private JButton save, refresh;

    private ToolBarListener listener;
    
    public ToolBar(){
        draw = false;
        this.height = height;
        this.width = width;
        init();
    }
    
    private void init(){
        setBorder(BorderFactory.createEtchedBorder());
        //setLayout(new GridLayout(1,10));

        save = new JButton("Save");
        refresh = new JButton("Refresh");

        save.setIcon(Utils.createIcon("/com/company/img/Save16.gif"));
        save.setToolTipText("Save");

        refresh.setIcon(Utils.createIcon("/com/company/img/Refresh16.gif"));
        refresh.setToolTipText("Refresh");


        save.addActionListener(this);
        refresh.addActionListener(this);

        add(save);
        add(refresh);

    }

    private void createListDataStructure() {
        dataStructure = new Choice();
        dataStructure.addItem("Lista Simple Enlace");
        dataStructure.addItem("Lista Doble Enlace");
        add(dataStructure);
    }

    public void setToolbarListener(ToolBarListener listener){
        this.listener = listener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton)e.getSource();

        if (clicked == save) {
            listener.saveEventOccured();
        }
        if (clicked == refresh) {
            listener.refreshEventOccured();
        }

    }
}
