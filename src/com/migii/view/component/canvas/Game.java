package com.migii.view.component.canvas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;

public class Game extends JComponent {

    private  Ellipse2D.Double ball = new Ellipse2D.Double(100,100,15,15);
    private Ellipse2D.Double node = new Ellipse2D.Double(100,100,15,15);
    private Line2D.Double arrow = new Line2D.Double(10,10,100,100);
    private  RoundRectangle2D.Double bat = new RoundRectangle2D.Double(200,200,100,10,20,20);
    private BufferedImage buffer;

    private int xDirectionBall , yDirectionBall, xNodePos, yNodePos, xArrowPos, yArrowPos;
    private  double speed;
    private final int ARR_SIZE = 4;

    private Graphics2D g2;

    public Game(){
        xDirectionBall = 1;
        yDirectionBall = 1;
        speed = 10.0;
        xNodePos = 300;
        yNodePos = 300;
        node.x = xNodePos;
        node.y = yNodePos;
        xArrowPos = 150;
        yArrowPos = 150;
        setEvents();
    }


    public void setEvents(){
        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseMoved(MouseEvent mouseEvent) {
                bat.x = mouseEvent.getX();
                bat.y = mouseEvent.getY();
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                /* super.mouseClicked(mouseEvent); */
                ball.x = mouseEvent.getX();
                ball.y = mouseEvent.getY();
            }
        });

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent componentEvent) {
                //super.componentResized(componentEvent);
                buffer = null;
            }
        });
    }

    public void update(){
        ball.x += xDirectionBall*speed;
        ball.y += yDirectionBall*speed;
        repaint();
    }

    @Override
    public void update(Graphics g){
        paint(g);
    }

    @Override
    public void paintComponent(Graphics g){

        if (buffer == null){
            buffer = new BufferedImage(getWidth(),getHeight(),BufferedImage.TYPE_INT_RGB);
        }

        g2 = (Graphics2D)buffer.getGraphics();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        clear();

        g2.setColor(Color.red);
        g2.fill(ball);

        g2.setColor(Color.CYAN);
        g2.fill(node);

        g2.setColor(Color.red);
        drawArrow(g2,(int)ball.x+10,(int)ball.y+10,xArrowPos,yArrowPos);

        g.drawImage(buffer, 0,0,null);
    }

    public void clear(){
        g2.setColor(Color.white);
        g2.fillRect(0,0,getWidth(),getHeight());
    }

    public void runArrowNode() {
        xArrowPos+=1;
        yArrowPos+=1;
        repaint();
    }

    private void drawArrow(Graphics2D g, int x1, int y1, int x2, int y2){
        double dx = x2 - x1, dy = y2 - y1;
        double angle = Math.atan2(dy,dx);
        int len = (int)Math.sqrt(dx*dx + dy*dy);

        AffineTransform at = AffineTransform.getTranslateInstance(x1,y1);
        at.concatenate(AffineTransform.getRotateInstance(angle));
        g.transform(at);

        g.drawLine(0,0,len,0);
        g.fillPolygon(new int[] {len, len-ARR_SIZE, len-ARR_SIZE,len},
                new int[] {0, -ARR_SIZE, ARR_SIZE, 0}, 4
        );
    }
}
