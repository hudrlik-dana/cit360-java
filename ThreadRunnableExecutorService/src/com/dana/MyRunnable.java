package com.dana;

// highlight color ANSI_BLACK, key option+return creates import
// from ThreadColors class of constraints

import static com.dana.ThreadColors.ANSI_BLACK;

// implement Runnable interface
public class MyRunnable implements Runnable {

        // constructor overrides run() method
//        @Override
        public void run() {
            System.out.println(ANSI_BLACK + "Hey this thread is from MyRunnable "
            + "implementation of the run() method");
        }
    }
