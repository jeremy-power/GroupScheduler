/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.subzero9998;

import java.awt.GridLayout;
import javax.swing.JFrame;

/**
 *
 * @author Jeremy
 */public class ScheduleWindow extends JFrame {
    ScheduleScreen s;
    /**
     * Creates new form ScheduleWindow
     */
    
    public ScheduleWindow() {
        setTitle("Availability");
        setSize(580, 670);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        
        init();
    }
    public void init() {
        setLocationRelativeTo(null);
        setLayout(new GridLayout(1, 1, 0, 0));
        s = new ScheduleScreen();
        add(s);
        setVisible(true);
    }
 }