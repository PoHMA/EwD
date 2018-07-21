package com.company;

import com.company.view.Diagrammer;

import javax.swing.*;

public class App {

    private static final int  width = 600;
    private static final int height = 400;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                new Runnable() {
                   @Override
                   public void run() {
                       new Diagrammer(width,height);
                   }
               }
        );
    }

}
