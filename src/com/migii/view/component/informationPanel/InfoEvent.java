package com.migii.view.component.informationPanel;

import java.util.EventObject;

public class InfoEvent extends EventObject {


    private String name;

    public InfoEvent(Object source) {
        super(source);
    }

    public InfoEvent(Object source, String name){
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
