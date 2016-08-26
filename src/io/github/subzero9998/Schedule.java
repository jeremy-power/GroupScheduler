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
    public int[] monArray = new int[23];
    public int[] tueArray = new int[23];
    public int[] wedArray = new int[23];
    public int[] thuArray = new int[23];
    public int[] friArray = new int[23];
    public int[] satArray = new int[23];
    public int[] sunArray = new int[23];
    int[][] daysArray = new int[][]{monArray, tueArray, wedArray, thuArray, friArray, satArray, sunArray};

    public Schedule(String monday, String tuesday, String wednesday, String thursday, String friday, String saturday, String sunday) {
        this.fullSchedule = monday + tuesday + wednesday + thursday + friday + saturday + sunday;
        this.fullScheduleA = fullSchedule.toCharArray();
    }

    public void setArrays() {
        //first time
        int fTime;
        //second time
        int sTime;
        //first time # of digits
        int fDigits;
        //secont time # of digits
        int sDigits;
        //first time AM or PM
        boolean fAM;
        //second time AM or PM
        boolean sAM;
        int indexCount = 0;
        
        //loops through each day
        for (int i = 0; i < daysArray.length; i++) {
            fTime = 0;
            sTime = 0;
            fDigits = 0;
            sDigits = 0;
           //checks if the first time is 1 digit or 2 digits
            if (fullScheduleA[indexCount + 1] == ' ') {
                fTime = Character.getNumericValue(fullScheduleA[indexCount]);
                //AM or PM check (1 digit)
                fAM = fullScheduleA[indexCount+2] == 'A';
                indexCount += 4;
            } else {
                fTime = Integer.parseInt(Character.toString(fullScheduleA[indexCount]) + Character.toString(fullScheduleA[indexCount+1]));
                //AM or PM check (2 digits)
                fAM = fullScheduleA[indexCount+3] == 'A';
                indexCount += 5;
            }
            //checks if the second time is 1 digit or 2 digits
            if (fullScheduleA[indexCount + 1] == ' ') {
                sTime = Character.getNumericValue(fullScheduleA[indexCount]);
                //AM or PM check (1 digit)
                sAM = fullScheduleA[indexCount+2] == 'A';
                indexCount += 4;
            } else {
                sTime = Integer.parseInt(Character.toString(fullScheduleA[indexCount]) + Character.toString(fullScheduleA[indexCount+1]));
                //AM or PM check (2 digits)
                sAM = fullScheduleA[indexCount+3] == 'A';
                indexCount += 5;
            }
            //sets 12 to the 0th index
            if(fTime == 12)
                fTime = 0;
            // if PM, sets to time + 12th index
            if(!fAM)
                fTime += 12;
            if(!sAM)
                sTime += 12;
            if(sTime == 12 && sAM)
                sTime = 0;
            Boolean rolling = false;
            //loops through each hour of each day
            for (int k = 0; k < daysArray[i].length; k++) {
                if (k == sTime)
                    rolling = false;
                if (k == fTime)
                    rolling = true;
                if (rolling)
                    daysArray[i][k] = 1;
            }
            
        }
    }

}
