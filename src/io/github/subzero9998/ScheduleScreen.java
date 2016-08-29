/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.subzero9998;

import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Jeremy
 */
public class ScheduleScreen extends JPanel {
    
    public ScheduleScreen() {
        repaint();
    }
    
    public void paint(Graphics g) {
        //(x, y, width, height)
        int xInc = 0;
        int yInc = 0;
        for (int i = 0; i < 168; i++) {
            if(xInc == 525) {
                xInc = 0;
                yInc += 25;
            }
            checkFill(g, xInc, yInc);
            xInc += 75;
        }
        g.setFont(new Font("Arial", Font.PLAIN, 12));
        //(string, x, y)
        //base at 18, 22 space between
        g.drawString("Monday", 56, 20);
        g.drawString("Tuesday", 56 + 75, 20);
        g.drawString("Wednesday", 48 + 75*2, 20);
        g.drawString("Thursday", 56 + 75*3, 20);
        g.drawString("Friday", 64 + 75*4, 20);
        g.drawString("Saturday", 56 + 75*5, 20);
        g.drawString("Sunday", 60 + 75*6, 20);
        int time = 1;
        int xInc2 = 0;
            g.drawString("12AM", 5, 45);
        for (int i = 0; i < 11; i++) {
            g.drawString(time + "AM", 5, 70 + xInc2);
            time += 1;
            xInc2 += 25;
        }
        time = 1;
        g.drawString("12PM", 5, 345);
        for (int k = 0; k < 11; k++) {
            g.drawString(time + "PM",5 ,70 + 25 + xInc2);
            time += 1;
            xInc2 += 25;
        }
    }
    
    private void checkFill(Graphics g, int xInc, int yInc) {
        g.drawRect(42 + xInc, 28 + yInc, 75, 25);
    }
}
