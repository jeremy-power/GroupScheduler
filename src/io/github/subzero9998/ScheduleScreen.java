/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.subzero9998;

import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;
import io.github.subzero9998.Schedule;
import java.awt.Color;

/**
 *
 * @author Jeremy
 */
public class ScheduleScreen extends JPanel {

    public ScheduleScreen() {
        repaint();
    }
    //draws schedule GUI
    public void paint(Graphics g) {
        //(x, y, width, height)
        int xInc = 0;
        int yInc = 0;
        //for each day
        for (int i = 0; i < 7; i++) {
            //for each hour of each day
            for (int k = 0; k < 24; k++) {
                //if 23 boxes have been drawn
                if (yInc == 600) {
                    //start back at the top 75 pixels to the right
                    yInc = 0;
                    xInc += 75;
                }
                //draw a box
                checkFill(g, xInc, yInc, i, k);
                //draw the next box 25 pixels lower
                yInc += 25;
            }
        }
        g.setFont(new Font("Arial", Font.PLAIN, 12));
        //(string, x, y)
        //base at 18, 22 space between
        g.drawString("Monday", 56, 20);
        g.drawString("Tuesday", 56 + 75, 20);
        g.drawString("Wednesday", 48 + 75 * 2, 20);
        g.drawString("Thursday", 56 + 75 * 3, 20);
        g.drawString("Friday", 64 + 75 * 4, 20);
        g.drawString("Saturday", 56 + 75 * 5, 20);
        g.drawString("Sunday", 60 + 75 * 6, 20);
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
            g.drawString(time + "PM", 5, 70 + 25 + xInc2);
            time += 1;
            xInc2 += 25;
        }
    }

    private void checkFill(Graphics g, int xInc, int yInc, int i, int k) {
        boolean check;
        check = true;
        
        for (int p = 0; p < GroupSchedulerGUI.persons.size(); p++) {
            if (GroupSchedulerGUI.persons.get(p).schedule.daysArray[i][k] == 0) {
                check = false;
                break;
            }
        }
        if (check) {
            //if everyone is available at this hour on this day
            //draws a green box
            g.setColor(Color.GREEN);
            g.fillRect(42 + xInc, 28 + yInc, 75, 25);
            g.setColor(Color.BLACK);
            g.drawRect(42 + xInc, 28 + yInc, 75, 25);
        } else {
            //otherwise draws an empty box
            g.drawRect(42 + xInc, 28 + yInc, 75, 25);
        }
    }
}
