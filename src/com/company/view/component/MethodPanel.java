package com.company.view.component;

import com.company.view.component.methodPanel.MethodEvent;
import com.company.view.component.methodPanel.MethodListener;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MethodPanel extends JPanel {

    private JLabel nameLabel;
    private JTextField nameField;
    private  JButton okBtn;

    private MethodListener methodListener;

    public MethodPanel(){
        setSizePanel();
        setComponentPanel();
        setBorderPanel();
    }

    private void setSizePanel(){
        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);
    }

    private void setComponentPanel(){

        setLayout(new GridBagLayout());

        nameLabel = new JLabel("Name: ");
        nameField = new JTextField(10);
        okBtn = new JButton("tam");

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
        gc.gridy = 2;
        gc.insets = new Insets(0 , 0,0,0);
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(okBtn, gc);



    }

    private void  setBorderPanel(){
        Border innerBorder = BorderFactory.createTitledBorder("Methods");
        Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder,innerBorder));
    }

    public void setMethodListener(MethodListener listener){
        this.methodListener = listener;
    }



}
