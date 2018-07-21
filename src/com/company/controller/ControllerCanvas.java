package com.company.controller;

import com.company.view.component.CanvasFigure;

public class ControllerCanvas {

    private CanvasFigure canvas;

    //private static final ControllerCanvas INSTANCE = new ControllerCanvas();

    public  ControllerCanvas (CanvasFigure canvas){
        this.canvas = canvas;
    }

    //private ControllerCanvas() {
    //    canvas = new CanvasFigure(100,100);
    //}

    //public static ControllerCanvas getInstance() {
    //    return INSTANCE;
    //}

    public void addNodoGift(){
        canvas.animacionNodo();
    }


    public CanvasFigure getCanvas() {
        return canvas;
    }

    public void createGift() {
        canvas.drawGift();
    }

}
