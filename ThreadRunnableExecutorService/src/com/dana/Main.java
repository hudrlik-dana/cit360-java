package com.dana;

// the decision of priority - which thread is running - is up to the system to schedule
// it will not always be in the same order of printing

import static com.dana.ThreadColors.*;

// if only going to run once, can use anonymous thread
// only one instance of a thread can be started at a time
public class Main {

    public static void main(String[] args) throws InterruptedException {

        System.out.println(ANSI_GREEN + "I'm the main thread");
        System.out.println(ANSI_BLACK + "I'm another thread");
        System.out.println( ANSI_CYAN + "I'm one more thread");

        // create an instance of the Thread
        Thread myOtherThread = new MyOtherThread();
        myOtherThread.setName("** My Other Thread **");

        // use start() method to invoke the JVM run() method for the thread
        myOtherThread.start();

        // anonymous class thread
        new Thread() {
            public void run() {
                System.out.println(ANSI_PURPLE + "I'm an anonymous class thread");
            }
         // start the thread
        }.start();

        // create an instance of the thread class
        // pass parameter new object of MyRunnable class to the constructor
        // call the thread instance's start() method

        // subclass of Thread class
        // Thread myRunnableThread = new Thread(new MyRunnable());

        // anonymous runnable thread
        Thread myRunnableThread = new Thread(new MyRunnable()) {
            // override the constructor
            @Override
            public void run() {
                System.out.println(ANSI_BLUE + "I'm an anonymous class implementation of run() method");

                // exception block
                try {
                    // call join() method to the current thread, join to myOtherThread
                    myOtherThread.join(3000);
                    //myOtherThread.join();
                    System.out.println(ANSI_BLUE + "MyOtherThread has timed out or "
                            + "terminated, so I better run again");

                    // catch exception of join() method if terminates prematurely
                    // if this thread is interrupted by another thread
                } catch (InterruptedException interruptedException) {
                    System.out.println(ANSI_BLUE + "I was interrupted. I guess I waited too long");
                }
            }
        };

        // calling instance start() method
        myRunnableThread.start();

        // terminate the thread
        // myOtherThread.interrupt();

        System.out.println(ANSI_GREEN + "Main thread here again");
    }
}
