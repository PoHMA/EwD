/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.view.component.informationPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.company.view.component.informationPanel.functionPanel.MethodEvent;
import com.company.view.component.informationPanel.functionPanel.MethodListener;

import javax.swing.*;
import javax.swing.border.CompoundBorder;

/**
 *
 * @author migi
 */
public class FunctionPanel extends JPanel {

    private JLabel nameLabel;
    private JTextField nameField;
    private JButton okBtn;

    private JButton addNode;
    private MethodListener methodListener;

    CompoundBorder border = BorderFactory.createCompoundBorder(
            BorderFactory.createEtchedBorder(
                    Color.white,Color.BLUE),BorderFactory.createEmptyBorder(4, 4, 4, 4));

    Image img;
    Graphics graphics;
    
    public FunctionPanel(){
        initComponent();
    }

    private void initComponent() {

        setSizePanel();
        setComponentPanel();
        setBorder(border);
        //add(new JScrollPane(textArea),BorderLayout.CENTER);
        repaint();
    }

    public void appendText(String text){
        //textArea.append(text);
    }
    
    @Override
    public Dimension getPreferredSize(){
        return new Dimension(200, Short.MAX_VALUE);
    } 
    
    @Override
    public void paintComponent(Graphics g){
        if (img == null) {
            img = createImage(getSize().width, getSize().height);
            graphics = img.getGraphics();
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
        graphics.drawString("FunctionPanel", 60, 80);
        repaint();
    }

    public void drawTitle(String title) {
        graphics.setColor(Color.BLACK);
        graphics.drawString(title, 20, 20);
        repaint();
    }

    public void appendDescription(String description) {
        graphics.setColor(Color.BLACK);
        graphics.drawString(description, 20, 40);
        repaint();
    }

    private void setComponentPanel(){

        setLayout(new GridBagLayout());

        nameLabel = new JLabel("Name: ");
        nameField = new JTextField(10);
        okBtn = new JButton("tam");
        addNode = new JButton("insertar");

        okBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();

                MethodEvent ev = new MethodEvent(this, name);

                if (methodListener != null){
                    methodListener.methodEventOccurred(ev);
                }
            }
        });

        addNode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String name = "1";
                MethodEvent ev = new MethodEvent(this, name);

                if (methodListener != null){
                    methodListener.executeActionAddNodeLSE(ev);
                }

            }
        });

        GridBagConstraints gc = new GridBagConstraints();

        gc.weightx = 1;
        gc.weighty = 1;

        gc.gridx = 0;
        gc.gridy = 0;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0 , 0,0,5);

        add(nameLabel, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        gc.insets = new Insets(0 , 0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(nameField, gc);


        gc.weightx = 1;
        gc.weighty = 2.0;
        gc.gridx = 1;
        gc.gridy = 1;
        gc.insets = new Insets(0 , 0,0,0);
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(okBtn, gc);

        // Next

        gc.weightx = 1;
        gc.weighty = 2.0;
        gc.gridx = 1;
        gc.gridy = 2;
        gc.insets = new Insets(0 , 0,0,0);
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(addNode, gc);

    }

    private void setSizePanel(){
        Dimension dim = getPreferredSize();
        dim.width = 100;
        setPreferredSize(dim);
    }

    public void setMethodListener(MethodListener listener){
        this.methodListener = listener;
    }


}
