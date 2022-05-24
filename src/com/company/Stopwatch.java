package com.company;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Stopwatch implements ActionListener{

    //stopwatch buttons
    JFrame myFrame = new JFrame(); //creating frame
    JButton start = new JButton("START");
    JButton reset = new JButton("RESET");
    JButton time = new JButton();
    int elapsedTime =  0; //milliseconds after starting stopwatch
    int seconds = 0; //seconds that passed
    int minutes = 0; //mins that passed
    int hours = 0; //hours passed
    boolean started = false;
    String seconds_string = String.format("%02d", seconds); //e.g. if seconds = 0, it will display two 0s
    String minutes_string = String.format("%02d", minutes);
    String hours_string = String.format("%02d", hours);

    //creating timer

    Timer timer = new Timer(1000, new ActionListener() {

        public void actionPerformed(ActionEvent e) {
            //every 1000ms ther timer will...

            elapsedTime=elapsedTime+1000;
            hours = (elapsedTime/3600000); //3.6mil ms in an hr
            minutes = (elapsedTime/60000) % 60; //don't want to go over 60 minutes, increases hrs
            seconds = (elapsedTime/1000) % 60; //don't want to go over 60 secs, increases mins
            seconds_string = String.format("%02d", seconds);
            minutes_string = String.format("%02d", minutes);
            hours_string = String.format("%02d", hours);
            time.setText(hours_string+":"+minutes_string+":"+seconds_string);

        }
    });

    Stopwatch() {

        time.setText(hours_string+":"+minutes_string+":"+seconds_string);
        time.setBounds(100,100,200,100);
        time.setFont(new Font("Serif",Font.PLAIN,30));
        time.setBorder(BorderFactory.createBevelBorder(1));
        time.setOpaque(true);
        time.setHorizontalAlignment(JTextField.CENTER);

        start.setBounds(100,200,100,50);
        start.setFont(new Font("Serif",Font.PLAIN,12));
        start.setFocusable(false);
        start.addActionListener(this); //makes button usable

        reset.setBounds(200,200,100,50);
        reset.setFont(new Font("Serif",Font.PLAIN,12));
        reset.setFocusable(false);
        reset.addActionListener(this); //makes button usable

        myFrame.add(start);
        myFrame.add(reset);
        myFrame.add(time);//inserts time label into frame
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //closes when you press X
        myFrame.setSize(420,420);
        myFrame.setLayout(null);
        myFrame.setVisible(true);
        myFrame.setResizable(false);


    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==start) {
            start(); //call the start function
            if(started==false) {
                started=true;
                start.setText("STOP");
                start();
            }
            else {
                started=false;
                stop();
                start.setText("START");

            }
        }
        if(e.getSource()==reset) {
            started=false;
            start.setText("START");
            reset();
        }
    }

    void start() {
        timer.start();
    }

    void stop() {
        timer.stop();
    }

    void reset() {
        timer.stop();
        elapsedTime = 0;
        seconds = 0;
        minutes = 0;
        hours = 0;

        //sets everything back to 0
        seconds_string = String.format("%02d", seconds);
        minutes_string = String.format("%02d", minutes);
        hours_string = String.format("%02d", hours);
        time.setText(hours_string+":"+minutes_string+":"+seconds_string);
    }

}
