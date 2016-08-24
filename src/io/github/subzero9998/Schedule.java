/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.subzero9998;

/**
 *
 * @author Jeremy
 */
public class Schedule {
    
    public String fullSchedule;
    public char[] fullScheduleA;
    
    public Schedule(String monday, String tuesday, String wednesday, String thursday, String friday, String saturday, String sunday) {
        this.fullSchedule = monday + tuesday + wednesday + thursday + friday + saturday + sunday;
        this.fullScheduleA = fullSchedule.toCharArray();
    }
    
    
}
