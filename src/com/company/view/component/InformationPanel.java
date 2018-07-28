package com.company.view.component;

import com.company.view.component.informationPanel.FunctionPanel;
import com.company.view.component.informationPanel.IndexPanel;
import com.company.view.component.informationPanel.InfoEvent;
import com.company.view.component.informationPanel.InformationListener;
import com.company.view.component.informationPanel.functionPanel.MethodEvent;
import com.company.view.component.informationPanel.functionPanel.MethodListener;
import com.company.view.component.informationPanel.indexPanel.MessageListener;

import javax.swing.*;

public class InformationPanel extends JTabbedPane {

    private FunctionPanel functionPanel;
    private IndexPanel indexPanel;

    private InformationListener listener;

    public InformationPanel(){
        functionPanel = new FunctionPanel();
        indexPanel = new IndexPanel();
        initPanel();
    }

    private void initPanel() {
        addTab("Clases",indexPanel);
        addTab("Metodos",functionPanel);
        createListenerIndexPanel();
        createListenerMethodPanel();
    }

    private void createListenerIndexPanel(){
        indexPanel.addMessageListener(new MessageListener() {
            @Override
            public void textEmitted(String text) {
                System.out.println(text);
            }
        });
    }

    private void createListenerMethodPanel(){
        functionPanel.setMethodListener(new MethodListener() {
            @Override
            public void methodEventOccurred(MethodEvent e) {
                //controller.addData(e);
                System.out.println("entreListener0");
            }

            @Override
            public void executeActionAddNodeLSE(MethodEvent e) {
                InfoEvent event = new InfoEvent(this, e.getName());
                listener.runActionAnimation(event);
            }
        });
    }


    public void setActionListener(InformationListener informationListener) {
        this.listener = informationListener;
    }

}
