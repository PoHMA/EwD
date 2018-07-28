package com.company.controller;

import com.company.modelo.estructuraDatosLineales.ListaSE;
import com.company.view.component.informationPanel.InfoEvent;

public class ControllerDiagrammed {

    private ListaSE<String> listaSE;

    public ControllerDiagrammed(){
        listaSE = new ListaSE<String>();
    }

    public void addData(InfoEvent ev){
        String name = ev.getName();
        listaSE.insertar(name);
    }


}
