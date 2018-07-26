package com.company.controller;

import com.company.modelo.estructuraDatosLineales.ListaSE;
import com.company.view.component.methodPanel.MethodEvent;

public class ControllerDiagrammed {

    private ListaSE<String> listaSE;

    public ControllerDiagrammed(){
        listaSE = new ListaSE<String>();
    }

    public void addData(MethodEvent ev){
        String name = ev.getName();
        listaSE.insertar(name);
    }


}
