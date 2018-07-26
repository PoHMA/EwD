package com.company.view.component.informationPanel.methodPanel;

import java.util.EventObject;

public class MethodEvent extends EventObject {


    private String name;

    public MethodEvent(Object source) {
        super(source);
    }

    public MethodEvent(Object source, String name){
        super(source);
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

}
