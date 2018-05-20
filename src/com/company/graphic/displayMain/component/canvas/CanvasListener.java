/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.graphic.displayMain.component.canvas;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author migi
 */
public class CanvasListener extends MouseAdapter{
  
  
  @Override
  public void mousePressed(MouseEvent e) {
      Point point = e.getPoint();
  }
  
  @Override
  public void mouseDragged(MouseEvent e) {
      Point point = e.getPoint();
  }
  
  @Override
  public void mouseReleased(MouseEvent e) {
      Point point = e.getPoint();
  }
  
  
}
