package com.dana;

import static com.dana.ThreadColors.ANSI_RED;

// extend from Thread superclass
public class MyOtherThread extends Thread{

// Runnable and Thread
    @Override
    public void run() {
        // first method print out immediately
        System.out.println(ANSI_RED + "Hey I'm " + currentThread().getName());

        try {
            // sleeps for 5 seconds, gives other thread time, then wakes up and finishes
            Thread.sleep(5000);
            // Thread.sleep(3000);

        // catch exception, print message in blue
        } catch(InterruptedException interruptException) {
            System.out.println(ANSI_RED + "Thanks MyOtherThread for waking me up");
            return;
        }
        System.out.println(ANSI_RED + "Five seconds has passed, I'm awake now");
    }
}
